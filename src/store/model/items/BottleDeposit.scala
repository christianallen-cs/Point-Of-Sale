package store.model.items

class BottleDeposit(charged: Double) extends Modifier {

  override def updatePrice(input: Double): Double = {
    input
  }

  override def computeTax(param: Double): Double = {
    charged
  }

}
