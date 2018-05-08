name := """ReactiveTweets"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies += guice

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.4"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.2"
libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "4.0.4"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.11" % Test

libraryDependencies ++= Seq(
  "com.h2database" % "h2" % "1.4.196",
  "org.assertj" % "assertj-core" % "3.6.2" % Test,
  "org.awaitility" % "awaitility" % "2.0.0" % Test,
  "javax.xml.bind" % "jaxb-api" % "2.1"
)

libraryDependencies ++= Seq(
  jdbc,
  ehcache,
  ws,
  guice,
  logback
  //"org.scalatestplus.play"    %% "scalatestplus-play" % "1.5.1" % Test,
  //"com.typesafe.play.extras"  %% "iteratees-extras"   % "1.5.0"
)