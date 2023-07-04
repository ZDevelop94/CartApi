import model.{Apple, Cart, Fruit, Orange}

class CheckoutService {

  def checkout(cart: Cart): BigDecimal = {
    discountCalculation(cart.fruits)
  }

  private def discountCalculation(fruits: Seq[Fruit]): BigDecimal = {
    val applesTotal = applyTwoForOne(fruits.filter( _ == Apple ))
    val orangesTotal = applyThreeForTwo(fruits.filter( _ == Orange ))

    applesTotal + orangesTotal

  }

  private def applyTwoForOne(fruits: Seq[Fruit]): BigDecimal = {
    val remainder = fruits.size % 2

    val subjectToDiscountTotal = fruits.drop(remainder).map(_.price).sum / 2

    val remainderTotal = remainder * Apple.price

    subjectToDiscountTotal + remainderTotal
  }

  private def applyThreeForTwo(fruits: Seq[Fruit]): BigDecimal = {

    val subjectToDiscount = fruits.size - (fruits.size % 3)

    val subjectToDiscountTotal = (subjectToDiscount / 3) * (Orange.price * 2)

    val remainderTotal = (fruits.size % 3) * Orange.price

    subjectToDiscountTotal + remainderTotal
  }
}
