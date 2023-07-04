
import model.{Apple, Cart, Orange}
import org.scalatest.wordspec.AnyWordSpec

class CheckoutServiceTest extends AnyWordSpec {


  val checkoutService = new CheckoutService

  "checkout" should {
    "return £2.05 when checking out with Apples amd Oranges" in {
      val fruits = Seq(Apple, Apple, Orange, Apple)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 2.05)
    }

    "return £1.80 when checking out with just Apples" in {
      val fruits = Seq(Apple, Apple, Apple)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 1.80)

    }

    "return £1.00 when checking out with just Apples" in {
      val fruits = Seq(Orange, Orange, Orange, Orange)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 1.00)
    }
  }
}
