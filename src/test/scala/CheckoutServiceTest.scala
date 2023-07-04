
import model.{Apple, Cart, Orange}
import org.scalatest.wordspec.AnyWordSpec

class CheckoutServiceTest extends AnyWordSpec {


  val checkoutService = new CheckoutService

  "checkout" should {
    "return £1.45 when checking out with Apples and Oranges with 2 for 1 applied" in {
      val fruits = Seq(Apple, Apple, Orange, Apple)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 1.45)
    }

    "return £1.20 when checking out with just Apples with 2 for 1 applied" in {
      val fruits = Seq(Apple, Apple, Apple)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 1.20)

    }

    "return £1.00 when checking out with just Oranges with 3 for 2" in {
      val fruits = Seq(Orange, Orange, Orange, Orange)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 1.00)
    }

    "return £2.20 when checking out with Apples and Oranges with 2 for 1 applied and 3 for 2" in {
      val fruits = Seq(Orange, Orange, Apple, Orange, Orange, Apple, Apple)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 2.20)
    }
  }
}
