package store.model.checkout

class CheckoutFeatures(checkout: SelfCheckout) extends State(checkout) {

  override def numberPressed(number: Int): Unit = {
    checkout.stringNumber += number
  }

  override def clearPressed(): Unit = {
    checkout.stringNumber = ""
  }

  override def enterPressed(): Unit = {
    checkout.repeatItem = checkout.myMap.getOrElse(checkout.stringNumber, checkout.errorItem)
    checkout.cart :+= checkout.repeatItem
    checkout.stringNumber = ""
    checkout.state = new ReScan(checkout)
  }

  override def checkoutPressed(): Unit = {
    checkout.stringNumber = "cash or credit"
    checkout.state = new ReadyToPay(checkout)
  }

  override def cashPressed(): Unit = {
  }

  override def creditPressed(): Unit = {
  }
}
