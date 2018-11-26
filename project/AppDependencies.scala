import play.core.PlayVersion
import play.sbt.PlayImport._
import sbt._

object AppDependencies {

  val compile = Seq(
    "uk.gov.hmrc" %% "bootstrap-play-26"    % "0.32.0",
    "uk.gov.hmrc" %% "simple-reactivemongo" % "7.0.0-play-26",
    ws
  )

  val test = Seq(
    "org.scalatest"     %% "scalatest"          % "3.0.4"             % Test,
    "org.pegdown"       % "pegdown"             % "1.6.0"             % Test,
    "com.typesafe.play" %% "play-test"          % PlayVersion.current % Test,
    "uk.gov.hmrc"       %% "reactivemongo-test" % "4.1.0-play-26"     % Test
  )

}
