package shifter.http.client

import concurrent._

trait HttpClient {
  protected implicit lazy val ec: ExecutionContext =
    shifter.io.Implicits.IOContext

  // To Implement
  def request(
    method: String,
    url: String,
    data: Map[String, String],
    headers: Map[String, String]
  ): Future[HttpClientResponse]

  // To Implement
  def request(
    method: String,
    url: String,
    body: Array[Byte],
    headers: Map[String, String]
  ): Future[HttpClientResponse]

  // To Implement
  def close()

  def request(method: String, url: String): Future[HttpClientResponse] =
    request(method, url, Map.empty[String, String])

  def request(method: String, url: String, data: Map[String, String]): Future[HttpClientResponse] =
    request(method, url, data, Map.empty[String, String])

  def requestWithAuth(method: String, url: String, data: Map[String, String], user: Option[String], password: Option[String]): Future[HttpClientResponse] = {
    val headers =
      for (u <- user; p <- password) yield {
        val auth = "Basic " + Base64.encode((u + ":" + p).getBytes("UTF-8"))
        Map("Authorization" -> auth)
      }

    request(method, url, data, headers.getOrElse(Map.empty))
  }
}

