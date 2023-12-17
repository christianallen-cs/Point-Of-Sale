package store.model.checkout

class ReScan(checkout: SelfCheckout) extends State(checkout) {


  override def checkoutPressed(): Unit = {
    checkout.stringNumber = "cash or credit"
    checkout.state = new ReadyToPay(checkout)
  }

  override def numberPressed(number: Int): Unit = {
    checkout.stringNumber += number
    checkout.state = new CheckoutFeatures(checkout)
  }

  override def clearPressed(): Unit = {
    checkout.stringNumber = ""
    checkout.state = new CheckoutFeatures(checkout)
  }

  override def enterPressed(): Unit = {
    checkout.cart = checkout.cart :+ checkout.repeatItem
    checkout.stringNumber = ""
  }

  override def cashPressed(): Unit = {
  }

  override def creditPressed(): Unit = {
  }
}
