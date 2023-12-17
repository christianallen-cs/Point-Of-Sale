package store.model.items

abstract class Modifier() {

  def updatePrice(input: Double): Double

  def computeTax(param: Double): Double

}
