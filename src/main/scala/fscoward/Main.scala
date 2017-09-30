package fscoward

import java.time.{ ZoneId, ZonedDateTime }

import fscoward.toggle.AuthenticationResponse
import fscoward.toggle.request.ApiToken

import scalaj.http.Http

object Main {

  def main(args: Array[String]): Unit = {
    val request = Http(Routes.Authentication.url).auth("***", "api_token")

    val response = AuthenticationResponse(request.asString.body)
    implicit val apiToken = ApiToken("***")

    val workspaces = fscoward.toggle.request.WorkspacesRequest.list
    workspaces.map(_.id).foreach(s => println(s"*** $s"))

    val tasks = fscoward.toggle.request.WorkspacesRequest.tasks(1083176L)

    val clients = fscoward.toggle.request.WorkspacesRequest.clients(1083176L)
    println(clients)
    val start = ZonedDateTime.of(2017, 9, 1, 0, 0, 0, 0, ZoneId.of("Asia/Tokyo"))
    val end = ZonedDateTime.of(2017, 9, 30, 23, 59, 59, 999, ZoneId.of("Asia/Tokyo"))
    val entries = fscoward.toggle.request.TimeEntries.getWithRange(start, end)
    println(entries.values)

  }

}
