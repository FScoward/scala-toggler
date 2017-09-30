package fscoward.toggle.request

import fscoward.Routes
import fscoward.toggle.response.workspaces.{ TasksResponse, WorkspacesResponse }

import scala.util.Try
import scalaj.http.Http

object WorkspacesRequest {
  def list(implicit apiToken: ApiToken): Seq[fscoward.toggle.response.workspaces.Workspace] = {
    val string = Http(Routes.Workspaces.list).auth(apiToken.value, "api_token").asString
    WorkspacesResponse(string.body).values
  }
  def single(id: Long)(implicit apiToken: ApiToken): Either[Throwable, WorkspacesResponse] = {
    Try {
      val response = Http(Routes.Workspaces.get(id)).auth(apiToken.value, "api_token").asString
      WorkspacesResponse(response.body)
    }.toEither
  }
  def clients(id: Long)(implicit apiToken: ApiToken) =
    Try {
      Http(Routes.Workspaces.clients(id)).auth(apiToken.value, "api_token").asString.body
    }.toEither

  def tasks(id: Long)(implicit apiToken: ApiToken): Either[Throwable, TasksResponse] = {
    Try {
      TasksResponse(Http(Routes.Workspaces.tasks(id)).auth(apiToken.value, "api_token").asString.body)
    }.toEither
  }
}
