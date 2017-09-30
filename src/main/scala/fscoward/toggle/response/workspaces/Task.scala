package fscoward.toggle.response.workspaces

import org.json4s.DefaultFormats

import org.json4s._
import org.json4s.native.JsonMethods._

case class TasksResponse(private val response: String) {
  private implicit val formats = DefaultFormats
  private val json = parse(response)
  lazy val values = json.extract[Seq[Task]]
}
case class Task(
  name: String,
  id: Double,
  wid: Double,
  pid: Double,
  uid: Double,
  active: Boolean,
  at: String,
  estimated_seconds: Double)
