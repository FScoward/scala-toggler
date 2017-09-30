package fscoward.toggle

import org.json4s._
import org.json4s.native.JsonMethods._

case class AuthenticationResponse(private val response: String) {
  private implicit val formats = DefaultFormats
  private val json = parse(response)
  val api_token = json \ "data" \ "api_token"

}
