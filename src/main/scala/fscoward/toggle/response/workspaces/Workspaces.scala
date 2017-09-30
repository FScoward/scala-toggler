package fscoward.toggle.response.workspaces

import org.json4s._
import org.json4s.native.JsonMethods._

case class WorkspacesResponse(private val response: String) {
  private implicit val formats = DefaultFormats
  private val json = parse(response)
  lazy val value = (json \ "data").extract[Workspace]
  lazy val values = json.extract[Seq[Workspace]]
}
case class Workspace(
  id: Double,
  name: String,
  profile: Double,
  premium: Boolean,
  admin: Boolean,
  default_hourly_rate: Double,
  default_currency: String,
  only_admins_may_create_projects: Boolean,
  only_admins_see_billable_rates: Boolean,
  only_admins_see_team_dashboard: Boolean,
  projects_billable_by_default: Boolean,
  rounding: Double,
  rounding_minutes: Double,
  api_token: String,
  at: String,
  ical_enabled: Boolean)
