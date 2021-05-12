import play.core.PlayVersion
import play.sbt.PlayImport
import sbt._

object AppDependencies {

  val hmrcMongoVersion = "0.50.0"

  val compile = Seq(
    "uk.gov.hmrc"       %% "bootstrap-backend-play-28" % "5.2.0",
    "uk.gov.hmrc.mongo" %% "hmrc-mongo-play-28"        % hmrcMongoVersion,
    PlayImport.ws
  )

  val test = Seq(
    "org.scalatest"        %% "scalatest"                % "3.2.6"             % Test,
    "com.vladsch.flexmark" %  "flexmark-all"             % "0.35.10"           % Test,
    "com.typesafe.play"    %% "play-test"                % PlayVersion.current % Test,
    "uk.gov.hmrc.mongo"    %% "hmrc-mongo-test-play-28"  % hmrcMongoVersion    % Test
  )
}
