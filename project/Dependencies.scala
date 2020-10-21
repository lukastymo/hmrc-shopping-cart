import sbt._

object Dependencies {
  object Versions {
    val squants = "1.6.0"

    val scalaTest = "3.2.0"
  }

  object Libraries {
    val squants = "org.typelevel" %% "squants" % Versions.squants

    val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest % Test
  }
}
