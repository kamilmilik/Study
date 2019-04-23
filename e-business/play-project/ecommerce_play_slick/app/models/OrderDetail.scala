package app.models

import play.api.libs.json.Json

case class OrderDetail(id: Int, orderId: Int, productId: Int, orderProductQuantity: Int)

object OrderDetail {
  implicit val orderDetailFormat = Json.format[OrderDetail]
}