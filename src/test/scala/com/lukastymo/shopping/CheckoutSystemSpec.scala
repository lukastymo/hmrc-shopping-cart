package com.lukastymo.shopping

import com.lukastymo.shopping.Shop._
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpec
import squants.market.MoneyConversions.MoneyConversions

class CheckoutSystemSpec extends AnyWordSpec {
  val noOffers = List[Offer]()

  "shopping system" should {

    "calculate price without offers" in {
      CheckoutSystem.checkout(List.empty, noOffers) mustBe (0 GBP)
      CheckoutSystem.checkout(List(Apple, Apple, Orange, Apple), noOffers) mustBe (2.05 GBP)
      CheckoutSystem.checkout(List(Apple), noOffers) mustBe (0.6 GBP)
      CheckoutSystem.checkout(List(Orange), noOffers) mustBe (0.25 GBP)
    }

    "calculate price with the offer for Apples" in {
      CheckoutSystem.checkout(List.empty, List(BuyOneGetOneFreeOnApples)) mustBe (0 GBP)
      CheckoutSystem.checkout(List(Apple, Apple), List(BuyOneGetOneFreeOnApples)) mustBe (0.6 GBP)
      CheckoutSystem.checkout(List(Apple, Orange, Apple), List(BuyOneGetOneFreeOnApples)) mustBe (0.85 GBP)
      CheckoutSystem.checkout(List(Orange, Orange, Orange), List(ThreeForThePriceOfTwoOnOranges)) mustBe (0.5 GBP)

      CheckoutSystem.checkout(
        List(Apple, Orange, Orange, Orange, Apple),
        List(BuyOneGetOneFreeOnApples, ThreeForThePriceOfTwoOnOranges)
      ) mustBe (1.1 GBP)

      CheckoutSystem.checkout(
        List(Apple, Apple, Apple, Apple, Apple) ++                        // pay for 3, get 2 free
            List(Orange, Orange, Orange, Orange, Orange, Orange, Orange), // pay for 5, get 2 free
        List(BuyOneGetOneFreeOnApples, ThreeForThePriceOfTwoOnOranges)
      ) mustBe (3.05 GBP)
    }

  }

}
