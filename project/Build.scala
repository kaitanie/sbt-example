import sbt._
import Keys._

case class ScalaVersionStr(major : Int, minor : Int, patchlevel : Int) {
  val featureVersionStr = major.toString() + "." + minor.toString()
  val fullVersionStr = featureVersionStr + "." + patchlevel
}

object ExampleBuild extends Build {
  val appScalaVersion = ScalaVersionStr(2, 10, 0)
  val akkaVersion = "2.1.0"
  val akkaScalaVersion = appScalaVersion.featureVersionStr

  val localScalacOptions = Seq(
    "-unchecked",
    "-deprecation",
    "-feature"
  )

  val localSettings = Seq(
    scalaVersion := appScalaVersion.fullVersionStr,
    scalacOptions := localScalacOptions
  )

  val akkaLibraries = Seq(
    "com.typesafe.akka" % ("akka-actor_" + akkaScalaVersion) % akkaVersion,
    "com.typesafe.akka" % ("akka-remote_" + akkaScalaVersion) % akkaVersion,
    "com.typesafe.akka" % ("akka-testkit_" + akkaScalaVersion) % akkaVersion,
    "com.typesafe.akka" % ("akka-kernel_" + akkaScalaVersion) % akkaVersion,
    "com.typesafe.akka" % ("akka-kernel_" + akkaScalaVersion) % akkaVersion,
    "com.typesafe.akka" % ("akka-transactor_" + akkaScalaVersion) % akkaVersion,
    "com.typesafe.akka" % ("akka-zeromq_" + akkaScalaVersion) % akkaVersion,
    "com.typesafe.akka" % ("akka-agent_" + akkaScalaVersion) % akkaVersion,
    "com.typesafe.akka" % ("akka-cluster-experimental_" + akkaScalaVersion) % akkaVersion
  )

  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.1.0"
  )

  lazy val root = Project(id = "ExampleProject",
    base = file("."),
    settings = Project.defaultSettings ++ localSettings ++ Seq(
      libraryDependencies ++= akkaLibraries))
}
