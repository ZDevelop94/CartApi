import model.{Cart, Fruit}

class CheckoutService {

  def checkout(cart: Cart): BigDecimal = {
    cart.fruits.map(_.price).sum
  }

  private def discountCalculation(fruits: Seq[Fruit]): BigDecimal = {
    ???
  }

  private def applyTwoForOne(fruits: Seq[Fruit]): BigDecimal = {
    ???
  }

  private def applyThreeForTwo(fruits: Seq[Fruit]): BigDecimal = {
    ???
  }
}
