package tests

import store.model.checkout._
import org.scalatest.FunSuite
import store.model.items._


class Task2 extends FunSuite {

  val EPSILON: Double = 0.01

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }

  test("test 1") {

    var a_Sale: Sale = new Sale(50.0)
    var next_Sale = new Sale(20)
    var an_item = new Item("beans", 10)
    var an_tax1 = new SalesTax(50)

    an_item.addModifier(a_Sale)
    assert(compareDoubles(an_item.price(), 5))
    an_item.addModifier(next_Sale)
    assert(compareDoubles(an_item.price(), 4))
    an_item.addModifier(an_tax1)
    assert(compareDoubles(an_item.tax(),2))
    assert(math.abs(an_item.tax()) - 2 < EPSILON)

  }

  test("test 2") {

    var new_item = new Item("pear", 4)
    var new_sale = new Sale(50)

    new_item.addModifier(new_sale)
    assert(compareDoubles(new_item.price(),2))

  }

  test("test 3") {

    var aSale = new Sale(50)

    aSale.computeTax(100)
    assert(compareDoubles(aSale.computeTax(10),0.0))
    aSale.computeTax(101)
    assert(compareDoubles(aSale.computeTax(11),0.0))

  }

  test("test 4") {

    var aSalesTax = new SalesTax(10)

    aSalesTax.updatePrice(100)
    assert(compareDoubles(aSalesTax.updatePrice(50),50.00))

  }

  test("test 5") {

    var aBottleDeposit = new BottleDeposit(1)

    aBottleDeposit.computeTax(100)
    assert(compareDoubles(aBottleDeposit.computeTax(10),1))

  }

  test("test 6") {
    var testSelfCheckout4: SelfCheckout = new SelfCheckout()
    var testItem4: Item = new Item("pepper", 2.56)
    var testItem5: Item = new Item("cereal", 8.42)
    testSelfCheckout4.addItemToStore("999", testItem4)
    testSelfCheckout4.addItemToStore("303", testItem5)

    testSelfCheckout4.numberPressed(9)
    testSelfCheckout4.numberPressed(9)
    testSelfCheckout4.numberPressed(9)
    testSelfCheckout4.enterPressed()
    testSelfCheckout4.numberPressed(3)
    testSelfCheckout4.numberPressed(0)
    testSelfCheckout4.numberPressed(3)
    testSelfCheckout4.enterPressed()
    assert(testSelfCheckout4.itemsInCart() == List(testItem4, testItem5))
    assert(compareDoubles(testSelfCheckout4.subtotal(),10.98))

  }

  test("test 7") {
    var checkout: SelfCheckout = new SelfCheckout()
    var item: Item = new Item("water", .99)
    var tax: SalesTax = new SalesTax(6.25)
    checkout.addItemToStore("456", item)

    checkout.numberPressed(4)
    checkout.numberPressed(5)
    checkout.numberPressed(6)
    checkout.enterPressed()
    assert(checkout.itemsInCart() == List(item))
    item.addModifier(tax)
    assert(compareDoubles(item.tax(),0.061875))
    assert(compareDoubles(checkout.subtotal(),0.99))
    assert(compareDoubles(checkout.total(),1.051875))

  }
}
