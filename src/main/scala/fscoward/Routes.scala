package fscoward

import java.time.ZonedDateTime

object Routes {
  private val BASE = "https://www.toggl.com/api/v8"
  object Authentication {
    val url = s"${BASE}/me"
  }

  object Workspaces {
    val list = s"${BASE}/workspaces"
    val get = (id: Long) => s"${BASE}/workspaces/${id}"
    val clients = (id: Long) => s"${BASE}/workspaces/${id}/clients"
    val tasks = (id: Long) => s"${BASE}/workspaces/${id}/tasks"
  }

  object TimeEntries {
    val entries = s"${BASE}/time_entries"
  }
}
