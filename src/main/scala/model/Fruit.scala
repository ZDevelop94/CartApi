package model

sealed trait Fruit {

  val price: BigDecimal

}

case object Apple extends Fruit {
  val price = 0.6
}
case object Orange extends Fruit {
  val price = 0.25
}