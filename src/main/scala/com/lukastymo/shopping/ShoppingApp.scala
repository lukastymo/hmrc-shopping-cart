package com.lukastymo.shopping

import com.lukastymo.shopping.Shop._

object ShoppingApp extends App {
  println("Stage 1 demo")
  println(CheckoutSystem.checkout(List(Apple, Orange), List.empty)) // Load it from somewhere, db or input

  println("Stage 2 demo")
  println(
    CheckoutSystem.checkout(
      List(Orange, Apple, Orange, Apple, Orange),
      List(ThreeForThePriceOfTwoOnOranges, BuyOneGetOneFreeOnApples)
    )
  )
}
