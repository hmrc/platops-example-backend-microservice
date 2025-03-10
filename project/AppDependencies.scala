import play.core.PlayVersion
import play.sbt.PlayImport
import sbt._

object AppDependencies {
  private val bootstrapPlayVersion = "9.11.0"
  private val hmrcMongoVersion     = "2.5.0"

  val compile = Seq(
    "uk.gov.hmrc"       %% "bootstrap-backend-play-30" % bootstrapPlayVersion,
    "uk.gov.hmrc.mongo" %% "hmrc-mongo-play-30"        % hmrcMongoVersion,
    PlayImport.ws
  )

  val test = Seq(
    "uk.gov.hmrc"       %% "bootstrap-test-play-30"    % bootstrapPlayVersion % Test,
    "uk.gov.hmrc.mongo" %% "hmrc-mongo-test-play-30"   % hmrcMongoVersion     % Test,
  )

  val it = Seq.empty
}
