package app.models

import play.api.libs.json.Json

case class User(id: Long, name: String, password: String, email: String, country: String, street: String, city: String, address: String, postal: String)

object User {
  implicit val userFormat = Json.format[User]
}