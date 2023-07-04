import model.Cart

class CheckoutService {

  def checkout(cart: Cart): BigDecimal = {
    cart.fruits.map(_.price).sum
  }

}
