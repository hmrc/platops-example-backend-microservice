import play.core.PlayVersion
import play.sbt.PlayImport
import sbt._

object AppDependencies {

  private val bootstrapPlayVersion = "7.23.0"
  private val hmrcMongoVersion     = "1.4.0"

  val compile = Seq(
    "uk.gov.hmrc"       %% "bootstrap-backend-play-28" % bootstrapPlayVersion,
    "uk.gov.hmrc.mongo" %% "hmrc-mongo-play-28"        % hmrcMongoVersion,
    PlayImport.ws
  )

  val test = Seq(
    "uk.gov.hmrc"       %% "bootstrap-test-play-28"    % bootstrapPlayVersion % Test,
    "uk.gov.hmrc.mongo" %% "hmrc-mongo-test-play-28"   % hmrcMongoVersion     % Test
  )

  val it = Seq.empty
}
