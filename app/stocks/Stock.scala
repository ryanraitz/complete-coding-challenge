package stocks
import play.api.{Configuration, Logger}
import akka.NotUsed
import akka.stream.ThrottleMode
import akka.stream.scaladsl.Source

import scala.concurrent.duration._

import yahoofinance.YahooFinance

import yahoofinance.{Stock => YahooStock}
import yahoofinance.quotes.stock.{StockQuote => YahooStockQuote}

/**
 * A stock is a source of stock quotes and a symbol.
 */
class Stock(val symbol: StockSymbol) {
  private val stockQuoteGenerator: StockQuoteGenerator = new FakeStockQuoteGenerator(symbol)

  private val source: Source[StockQuote, NotUsed] = {
    Source.unfold(stockQuoteGenerator.seed) { (last: StockQuote) =>
      val next = stockQuoteGenerator.newQuote(last)
      Some(next, next)
    }
  }

  /**
   * Returns a source of stock history, containing a single element.
   */
  def history(n: Int): Source[StockHistory, NotUsed] = {
    source.grouped(n).map(sq => new StockHistory(symbol, sq.map(_.price))).take(1)
  }

  /**
   * Provides a source that returns a stock quote every 75 milliseconds.
   */
  def update: Source[StockUpdate, NotUsed] = {
    source
      .throttle(elements = 1, per = 5000.millis, maximumBurst = 1, ThrottleMode.shaping)
      .map(sq => new StockUpdate(sq.symbol, sq.name, sq.price))
  }

  override val toString: String = s"Stock($symbol)"
}

trait StockQuoteGenerator {
  def seed: StockQuote
  def newQuote(lastQuote: StockQuote): StockQuote
}

class FakeStockQuoteGenerator(symbol: StockSymbol) extends StockQuoteGenerator {
  private def random: Double = scala.util.Random.nextDouble
  private def ranName: String = "name"
  private val logger = Logger(this.getClass)

  def seed: StockQuote = 
  {
    StockQuote(symbol, StockName(ranName), StockPrice(random * 800))
  }

  def newQuote(lastQuote: StockQuote): StockQuote = 
  {
    val stock: YahooStock = YahooFinance.get(lastQuote.symbol.toString)
    val quote: YahooStockQuote = stock.getQuote(true)
    val name: String = stock.getName()
    logger.info(s"quote acquired for $name $quote")

    StockQuote(symbol, StockName(name), StockPrice(quote.getPrice().doubleValue()))
  }
}

case class StockQuote(symbol: StockSymbol, name: StockName, price: StockPrice)

/** Value class for a stock symbol */
class StockSymbol private (val raw: String) extends AnyVal {
  override def toString: String = raw
}

object StockSymbol {
  import play.api.libs.json._ // Combinator syntax

  def apply(raw: String) = new StockSymbol(raw)

  implicit val stockSymbolReads: Reads[StockSymbol] = {
    JsPath.read[String].map(StockSymbol(_))
  }

  implicit val stockSymbolWrites: Writes[StockSymbol] = Writes {
    (symbol: StockSymbol) => JsString(symbol.raw)
  }
}

/** Value class for a stock name */
class StockName private (val raw: String) extends AnyVal {
  override def toString: String = raw
}

object StockName {
  import play.api.libs.json._ // Combinator syntax

  def apply(raw: String) = new StockName(raw)

  implicit val stockNameReads: Reads[StockName] = {
    JsPath.read[String].map(StockName(_))
  }

  implicit val stockNameWrites: Writes[StockName] = Writes {
    (name: StockName) => JsString(name.raw)
  }
}

/** Value class for stock price */
class StockPrice private (val raw: Double) extends AnyVal {
  override def toString: String = raw.toString
}

object StockPrice {
  import play.api.libs.json._ // Combinator syntax

  def apply(raw: Double):StockPrice = new StockPrice(raw)

  implicit val stockPriceWrites: Writes[StockPrice] = Writes {
    (price: StockPrice) => JsNumber(price.raw)
  }
}

// Used for automatic JSON conversion
// https://www.playframework.com/documentation/2.7.x/ScalaJson

// JSON presentation class for stock history
case class StockHistory(symbol: StockSymbol, prices: Seq[StockPrice])

object StockHistory {
  import play.api.libs.json._ // Combinator syntax

  implicit val stockHistoryWrites: Writes[StockHistory] = new Writes[StockHistory] {
    override def writes(history: StockHistory): JsValue = Json.obj(
      "type" -> "stockhistory",
      "symbol" -> history.symbol,
      "history" -> history.prices
    )
  }
}

// JSON presentation class for stock update
case class StockUpdate(symbol: StockSymbol, name: StockName, price: StockPrice)

object StockUpdate {
  import play.api.libs.json._ // Combinator syntax

  implicit val stockUpdateWrites: Writes[StockUpdate] = new Writes[StockUpdate] {
    override def writes(update: StockUpdate): JsValue = Json.obj(
      "type" -> "stockupdate",
      "symbol" -> update.symbol,
      "name" -> update.name,
      "price" -> update.price
    )
  }
}