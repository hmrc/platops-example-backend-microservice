import play.core.PlayVersion
import play.sbt.PlayImport._
import sbt._

object AppDependencies {

  val compile = Seq(
    "uk.gov.hmrc" %% "bootstrap-backend-play-27"    % "3.0.0",
    "uk.gov.hmrc" %% "simple-reactivemongo"         % "7.30.0-play-27",
    ws
  )

  val test = Seq(
    "org.scalatest"             %% "scalatest"          % "3.1.2"             % "test",
    "com.vladsch.flexmark"      % "flexmark-all"        % "0.35.10"           % Test,
    "com.typesafe.play"         %% "play-test"          % PlayVersion.current % Test,
    "uk.gov.hmrc"               %% "reactivemongo-test" % "4.21.0-play-27"    % Test
  )

}
