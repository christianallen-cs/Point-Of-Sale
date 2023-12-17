package store.model.checkout

class ReadyToPay(checkout: SelfCheckout) extends State(checkout) {

  override def checkoutPressed(): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
  }

  override def clearPressed(): Unit = {
  }

  override def enterPressed(): Unit = {
  }

  override def cashPressed(): Unit = {
    checkout.cart = List()
    checkout.stringNumber = ""
    checkout.repeatItem = checkout.errorItem
    checkout.state = new CheckoutFeatures(checkout)
  }

  override def creditPressed(): Unit = {
    checkout.cart = List()
    checkout.stringNumber = ""
    checkout.repeatItem = checkout.errorItem
    checkout.state = new CheckoutFeatures(checkout)
  }

}
