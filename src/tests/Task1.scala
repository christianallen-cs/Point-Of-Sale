package tests

import org.scalatest.FunSuite
import store.model.checkout._
import store.model.items._

class Task1 extends FunSuite {

  val EPSILON: Double = 0.001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }

  test("test 1") {
    var testItem0: Item = new Item("banana", 100)
    var testItem1: Item = new Item("rice", 100)

    assert(testItem0.description() == "banana")
    assert(compareDoubles(testItem0.price(), 100))
    testItem1.setBasePrice(50)
    assert(compareDoubles(testItem1.price(), 50))
  }

  test("test 3") {
    var testSelfCheckout1: SelfCheckout = new SelfCheckout()
    var testItem2: Item = new Item("apple", 5)
    testSelfCheckout1.addItemToStore("12345", testItem2)

    testSelfCheckout1.displayString()
    assert(testSelfCheckout1.displayString() == "")
    testSelfCheckout1.numberPressed(1)
    testSelfCheckout1.numberPressed(2)
    testSelfCheckout1.numberPressed(3)
    testSelfCheckout1.numberPressed(4)
    testSelfCheckout1.numberPressed(5)
    assert(testSelfCheckout1.displayString() == "12345")
    testSelfCheckout1.enterPressed()
    assert(testSelfCheckout1.itemsInCart() == List(testItem2))
    testSelfCheckout1.clearPressed()
    assert(testSelfCheckout1.displayString() == "")

  }

    test("test 4") {
      var testSelfCheckout2: SelfCheckout = new SelfCheckout()
      var testItem3: Item = new Item("milk", 10)
      testSelfCheckout2.addItemToStore("0123", testItem3)

      testSelfCheckout2.displayString()
      testSelfCheckout2.numberPressed(0)
      testSelfCheckout2.numberPressed(1)
      testSelfCheckout2.numberPressed(2)
      testSelfCheckout2.numberPressed(3)
      assert(testSelfCheckout2.displayString() == "0123")
      testSelfCheckout2.enterPressed()
      assert(testSelfCheckout2.itemsInCart() == List(testItem3))
      testSelfCheckout2.clearPressed()
      assert(testSelfCheckout2.displayString() == "")
    }

  test("test 5") {
    var testSelfCheckout3: SelfCheckout = new SelfCheckout()

    testSelfCheckout3.numberPressed(1)
    testSelfCheckout3.numberPressed(3)
    testSelfCheckout3.clearPressed()
    assert(testSelfCheckout3.displayString() == "")
    testSelfCheckout3.clearPressed()
    testSelfCheckout3.numberPressed(2)
    testSelfCheckout3.numberPressed(3)
    testSelfCheckout3.numberPressed(7)
    testSelfCheckout3.clearPressed()
    assert(testSelfCheckout3.displayString() == "")
    assert(testSelfCheckout3.itemsInCart() == List())
  }

  test("test 6") {
    var testSelfCheckout4: SelfCheckout = new SelfCheckout()
    var testItem4: Item = new Item("pear", 2)
    var testItem5: Item = new Item("hot dog", 8)
    testSelfCheckout4.addItemToStore("000", testItem4)
    testSelfCheckout4.addItemToStore("111", testItem5)

    testSelfCheckout4.numberPressed(0)
    testSelfCheckout4.numberPressed(0)
    testSelfCheckout4.numberPressed(0)
    testSelfCheckout4.enterPressed()
    testSelfCheckout4.numberPressed(1)
    testSelfCheckout4.numberPressed(1)
    testSelfCheckout4.numberPressed(1)
    testSelfCheckout4.enterPressed()
    assert(testSelfCheckout4.itemsInCart() == List(testItem4, testItem5))
  }

  test("test 7") {
    var testSelfCheckout5: SelfCheckout = new SelfCheckout()

    testSelfCheckout5.enterPressed()

    val finalCart: List[Item] = testSelfCheckout5.itemsInCart()
    assert(finalCart.size == 1)
    assert(finalCart.head.description() == "error")
    assert(math.abs(finalCart.head.price()) - 0.0 < EPSILON)

  }
  }
