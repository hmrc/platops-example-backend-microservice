import uk.gov.hmrc.DefaultBuildSettings

lazy val microservice = Project("platops-example-backend-microservice", file("."))
  .enablePlugins(play.sbt.PlayScala, SbtDistributablesPlugin)
  .settings(
    scalaVersion        := "2.13.12",
    majorVersion        := 0,
    libraryDependencies ++= AppDependencies.compile ++ AppDependencies.test
  )
  .settings(PlayKeys.playDefaultPort := 9931)
  .settings(resolvers += Resolver.jcenterRepo)
  .settings(scalacOptions +=  "-Wconf:src=routes/.*:s")
