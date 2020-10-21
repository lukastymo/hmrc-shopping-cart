package com.lukastymo.shopping

import com.lukastymo.shopping.Shop._
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import squants.market.MoneyConversions.MoneyConversions

class CheckoutSystemSpec extends AnyWordSpec with Matchers {

  "shopping system" should {

    "calculate price" in {
      CheckoutSystem.cost(List.empty) mustBe (0 GBP)
      CheckoutSystem.cost(List(Apple, Apple, Orange, Apple)) mustBe (2.05 GBP)
    }
  }

}
