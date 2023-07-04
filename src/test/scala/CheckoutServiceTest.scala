
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

    "return £1.80 when checking out with just Apples with 2 for 1 applied" in {
      val fruits =
        Seq(Apple, Apple, Apple, Apple, Apple) //Added additional apples as total would be the same for some inputs
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 1.80)

    }

    "return £0.75 when checking out with just Oranges with 3 for 2" in {
      val fruits = Seq(Orange, Orange, Orange, Orange)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 0.75)
    }

    "return £2.20 when checking out with Apples and Oranges with 2 for 1 applied and 3 for 2" in {
      val fruits = Seq(Orange, Orange, Apple, Orange, Orange, Apple, Apple)
      val cart = Cart(fruits)
      val result = checkoutService.checkout(cart)

      assert(result === 1.95)
    }
  }
}
