package com.lukastymo.shopping

import squants.market.{ GBP, Money }
import squants.market.MoneyConversions.MoneyConversions

object Shop {
  private val applePrice  = 0.6 GBP
  private val orangePrice = 0.25 GBP

  sealed trait Item
  case object Apple  extends Item
  case object Orange extends Item

  sealed trait Offer
  sealed trait BuySomeGetFree extends Offer {
    val item: Item
    val noRequiredToBuy: Int

    def noItemsForFree(items: List[Item]): Int =
      // try to take one more elements than required, this one extra item will be free
      items.filter(_ == item).grouped(noRequiredToBuy + 1).count { xs =>
        xs.length == (noRequiredToBuy + 1)
      }
  }
  case object BuyOneGetOneFreeOnApples extends BuySomeGetFree {
    val item: Item           = Apple
    val noRequiredToBuy: Int = 1
  }

  /**
    * "Three for the price of two" is a business term, in other (generic) terms it is "Buy two and get one free"
    *
    * If you have a basket of item1, item2, this offer won't be applied, but
    * if you have a basket with item1, item2, item3, the item3 will be for free
    */
  case object ThreeForThePriceOfTwoOnOranges extends BuySomeGetFree {
    val item: Item           = Orange
    val noRequiredToBuy: Int = 2
  }

  def price(items: Item): Money =
    items match {
      case Apple  => applePrice
      case Orange => orangePrice
    }
}
