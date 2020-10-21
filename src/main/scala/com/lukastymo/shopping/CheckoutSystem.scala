package com.lukastymo.shopping

import com.lukastymo.shopping.Shop.{ Apple, BuySomeGetFree, Item, Offer }
import squants.market.Money
import squants.market.MoneyConversions.MoneyConversions

object CheckoutSystem {

  def checkout(items: List[Item], offers: List[Offer]): Money = {
    val discounts = offers.flatMap {
      case offer: BuySomeGetFree =>
        offer.noItemsForFree(items) match {
          case 0 => None
          case n => Some(Shop.price(offer.item).mapAmount(_ * n))
        }
    }
    val beforeOffers   = items.map(Shop.price).foldLeft(0 GBP)(_ + _)
    val totalDiscounts = discounts.foldLeft(0 GBP)(_ + _)
    beforeOffers - totalDiscounts
  }
}
