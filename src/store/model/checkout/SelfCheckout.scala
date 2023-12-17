package store.model.checkout

import store.model.items._

class SelfCheckout {

  var stringNumber: String = ""
  var errorItem: Item = new Item("error", 0.0)
  var myMap: Map[String, Item] = Map()
  var cart: List[Item] = List()
  var repeatItem: Item = errorItem
  var state: State = new CheckoutFeatures(this)

  def addItemToStore(barcode: String, item: Item): Unit = {
    myMap = myMap + (barcode -> item)
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def enterPressed(): Unit = {
    this.state.enterPressed()
  }

  def checkoutPressed(): Unit = {
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    this.state.creditPressed()
  }

  def loyaltyCardPressed(): Unit = {
  }

  def displayString(): String = {
    this.stringNumber
  }

  def itemsInCart(): List[Item] = {
    cart
  }

  def subtotal(): Double = {
    var sub: Double = 0.0
    for (items <- cart) {
      sub = items.price() + sub
    }
    sub
  }

  def tax(): Double = {
    var totalTax: Double = 0.0
    for (items <- cart) {
      totalTax = items.tax() + totalTax
    }
    totalTax
  }

  def total(): Double = {
    var totalPrice = subtotal() + tax()
    totalPrice
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.

    // Example usage:
    //val testItem: Item = new Item("test item", 100.0)
    //this.addItemToStore("472", testItem)
  }

}
