package com.lukastymo.shopping

import squants.market.{ GBP, Money }
import squants.market.MoneyConversions.MoneyConversions

object Shop {
  sealed trait Item
  case object Apple  extends Item
  case object Orange extends Item

  def price(items: Item): Money =
    items match {
      case Apple  => 0.6 GBP
      case Orange => 0.25 GBP
    }
}
