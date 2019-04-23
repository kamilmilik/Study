package app.models

import play.api.libs.json.Json

case class Order(id: Long, userId: Long, dateTime: String, address: String)

object Order {
  implicit val orderFormat = Json.format[Order]
}