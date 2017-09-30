package fscoward.toggle.response

import org.json4s.DefaultFormats

import org.json4s._
import org.json4s.native.JsonMethods._

case class TimeEntryResponse(private val response: String) {
  private implicit val formats = DefaultFormats
  private val json = parse(response)
  lazy val values = json.extract[Seq[TimeEntry]]
}
case class TimeEntry(
  id: Long,
  wid: Long,
  pid: Option[Long],
  billable: Boolean,
  start: String,
  stop: String,
  duration: Long,
  description: String,
  tags: List[String],
  at: String)
