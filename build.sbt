import Dependencies._

ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.lukastymo.shopping"
ThisBuild / organizationName := "Codeily LTD"

lazy val root = (project in file("."))
  .settings(
    name := "shopping-cart",
    libraryDependencies ++= Seq(
          Libraries.squants,
          Libraries.scalaTest
        )
  )

scalacOptions ++= Seq(
  "-language:postfixOps"
)
