package store.model.items

class SalesTax(percentOfTax: Double) extends Modifier {

  override def updatePrice(firstPrice: Double): Double = {
    firstPrice
  }

  override def computeTax(finalPriceBeforeTax: Double): Double = {
    val tax: Double = this.percentOfTax
    val finalPrice: Double = (tax / 100) * finalPriceBeforeTax
    finalPrice
  }

}
