import uk.gov.hmrc.DefaultBuildSettings

ThisBuild / scalaVersion  := "3.3.5"
ThisBuild / majorVersion  := 0
ThisBuild / scalacOptions += "-Wconf:msg=Flag.*repeatedly:s"

lazy val microservice = Project("platops-example-backend-microservice", file("."))
  .enablePlugins(play.sbt.PlayScala, SbtDistributablesPlugin)
  .settings(
    libraryDependencies ++= AppDependencies.compile ++ AppDependencies.test
  )
  .settings(PlayKeys.playDefaultPort := 9931)
  .settings(resolvers += Resolver.jcenterRepo)
  .settings(scalacOptions +=  "-Wconf:src=routes/.*:s")

lazy val it = project
  .enablePlugins(PlayScala)
  .dependsOn(microservice % "test->test")
  .settings(DefaultBuildSettings.itSettings())
  .settings(libraryDependencies ++= AppDependencies.it)
