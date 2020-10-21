package com.lukastymo.shopping

import com.lukastymo.shopping.Shop._
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpec

class BuySomeGetFreeSpec extends AnyWordSpec {

  "offers" should {

    "buy one, get one free on Apples" in {
      BuyOneGetOneFreeOnApples.noItemsForFree(Nil) mustBe 0
      BuyOneGetOneFreeOnApples.noItemsForFree(List(Apple)) mustBe 0
      BuyOneGetOneFreeOnApples.noItemsForFree(List.fill(2)(Apple)) mustBe 1
      BuyOneGetOneFreeOnApples.noItemsForFree(List.fill(3)(Apple)) mustBe 1
      BuyOneGetOneFreeOnApples.noItemsForFree(List.fill(4)(Apple)) mustBe 2
      BuyOneGetOneFreeOnApples.noItemsForFree(List.fill(5)(Apple)) mustBe 2
      BuyOneGetOneFreeOnApples.noItemsForFree(List.fill(100)(Apple)) mustBe 50
      BuyOneGetOneFreeOnApples.noItemsForFree(List.fill(101)(Apple)) mustBe 50
    }

    "three for the price of 2 on Oranges" in {
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(Nil) mustBe 0
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(List.fill(1)(Orange)) mustBe 0
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(List.fill(2)(Orange)) mustBe 0
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(List.fill(3)(Orange)) mustBe 1
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(List.fill(4)(Orange)) mustBe 1
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(List.fill(5)(Orange)) mustBe 1
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(List.fill(99)(Orange)) mustBe 33
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(List.fill(100)(Orange)) mustBe 33
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(List.fill(101)(Orange)) mustBe 33
    }

    "mix offers" in {
      val offers = List.fill(100)(Apple) ++ List.fill(101)(Orange)
      BuyOneGetOneFreeOnApples.noItemsForFree(offers) mustBe 50
      ThreeForThePriceOfTwoOnOranges.noItemsForFree(offers) mustBe 33
    }
  }
}
