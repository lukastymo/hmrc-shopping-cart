package com.lukastymo.shopping

import com.lukastymo.shopping.Shop.Item
import squants.market.Money
import squants.market.MoneyConversions.MoneyConversions

object CheckoutSystem {

  def cost(products: List[Item]): Money =
    products.map(Shop.price).foldLeft(0 GBP)(_ + _)
}
