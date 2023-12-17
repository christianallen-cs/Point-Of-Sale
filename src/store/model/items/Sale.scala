package store.model.items

class Sale(percentOff: Double) extends Modifier {

  override def updatePrice(price: Double): Double = {
    val total: Double = (this.percentOff / 100) * price
    price - total
  }

  override def computeTax(param: Double): Double = {
    0.0
  }

}
