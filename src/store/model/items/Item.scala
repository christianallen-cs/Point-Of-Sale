package store.model.items

class Item(description: String, var prices: Double) {

  var allMod: List[Modifier] = List()

  def description(): String = {
    this.description
  }

  def price(): Double = {
    var new_price: Double = this.prices
    for(mods <- allMod) {
      new_price = mods.updatePrice(new_price)
    }
    new_price
  }

  def setBasePrice(update: Double): Unit = {
    prices = update
  }

  def addModifier(the_modifier: Modifier): Unit = {
    this.allMod = this.allMod :+ the_modifier
  }

  def tax(): Double = {
    var finalPrice = price()
    var totalTax: Double = 0.0
    for (mod <- allMod) {
      totalTax = totalTax + mod.computeTax(finalPrice)
    }
    totalTax
  }
}
