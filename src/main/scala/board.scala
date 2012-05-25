package com.github.hexx.messageboard

import java.util.Date
import unfiltered.request._
import unfiltered.response._
import com.github.hexx.gaeds.{ Datastore, Mapper, Property }
import com.github.hexx.gaeds.Property._

class Message(
    val name: Property[String],
    val message: Property[String],
    val date: Property[Date])
  extends Mapper[Message] {
  def this() = this(mock, mock, mock)
  def this(name: String, message: String) = this(name, message, new Date)
}

object Message extends Message

case class Twirl(html: twirl.api.Html) extends ComposeResponse(HtmlContent ~> ResponseString(html.body))

class MessageBoard extends unfiltered.filter.Plan {
  val messageLimit = 100

  def intent = {
    case GET(Path("/")) => view
    case POST(Path("/") & Params(params)) => {
      val m = new Message(params("name")(0), params("message")(0))
      if (Message.query.count >= messageLimit) {
        Datastore.delete(Message.query.sort(_.date asc).asSingleKey)
      }
      m.put()
      view
    }
  }

  def view = Ok ~> Twirl(html.index())
}
