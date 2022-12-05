import play.core.PlayVersion
import play.sbt.PlayImport
import sbt._

object AppDependencies {

  private val bootstrapPlayVersion = "7.0.0"
  private val hmrcMongoVersion     = "0.69.0"

  val compile = Seq(
    "uk.gov.hmrc"       %% "bootstrap-backend-play-28" % bootstrapPlayVersion,
    "uk.gov.hmrc.mongo" %% "hmrc-mongo-play-28"        % hmrcMongoVersion,
    "com.typesafe.akka" %% "akka-actor"                % "2.7.0",
    PlayImport.ws
  )

  val test = Seq(
    "uk.gov.hmrc"       %% "bootstrap-test-play-28"    % bootstrapPlayVersion % Test,
    "uk.gov.hmrc.mongo" %% "hmrc-mongo-test-play-28"   % hmrcMongoVersion     % Test,
    "uk.gov.hmrc"       %% "webdriver-factory"         % "0.37.0"             % Test
  )
}
