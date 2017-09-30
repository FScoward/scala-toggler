package fscoward.toggle.request

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import fscoward.Routes
import fscoward.toggle.response.TimeEntryResponse

import scalaj.http.Http

object TimeEntries {
  def getWithRange(start: ZonedDateTime, end: ZonedDateTime)(implicit apiToken: ApiToken) = {
    val response = Http(Routes.TimeEntries.entries)
      .params(Map("startDate" -> start.format(DateTimeFormatter.ISO_DATE), "endDate" -> end.format(DateTimeFormatter.ISO_DATE)))
      .auth(apiToken.value, "api_token")
      .asString.body
    TimeEntryResponse(response)
  }
}
