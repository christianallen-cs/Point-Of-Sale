package tests

import store.model.checkout._
import org.scalatest.FunSuite
import store.model.items._

class Task3 extends FunSuite{

  val EPSILON: Double = 0.01

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }

  test("test 1") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem: Item = new Item("apple",5.00)
    testSelfCheckout.addItemToStore("123", testItem)

    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)

    testSelfCheckout.enterPressed()
    testSelfCheckout.cashPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem))

    testSelfCheckout.enterPressed()
    testSelfCheckout.creditPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem, testItem))

    testSelfCheckout.enterPressed()
    testSelfCheckout.loyaltyCardPressed()

    assert(testSelfCheckout.itemsInCart() == List(testItem, testItem, testItem))
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString() == "")
  }

  test("test 2") {
    var testSelfCheckout2: SelfCheckout = new SelfCheckout()
    var testItem2: Item = new Item("pear", 5.00)
    testSelfCheckout2.addItemToStore("789", testItem2)

    testSelfCheckout2.numberPressed(7)
    testSelfCheckout2.numberPressed(8)
    testSelfCheckout2.numberPressed(9)
    testSelfCheckout2.enterPressed()

    assert(testSelfCheckout2.itemsInCart() == List(testItem2))

    testSelfCheckout2.checkoutPressed()

    assert(testSelfCheckout2.displayString() == "cash or credit")

    testSelfCheckout2.cashPressed()

    assert(testSelfCheckout2.itemsInCart() == List())
  }

}
