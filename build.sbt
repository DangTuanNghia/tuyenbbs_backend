import scalariform.formatter.preferences._

name := """BBSBackend"""
organization := "com.flinters"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(evolutions, guice, ehcache, ws, jdbc, specs2 % Test)
//libraryDependencies ++= Seq(guice, jdbc, evolutions)

libraryDependencies ++= Seq(
  //"com.h2database"  %  "h2"                           % "1.4.200", // your jdbc driver here
  "mysql" % "mysql-connector-java" % "8.0.22",
  "org.scalikejdbc" %% "scalikejdbc"                  % "3.5.0",
  "org.scalikejdbc" %% "scalikejdbc-config"           % "3.5.0",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.8.0-scalikejdbc-3.5",
  // Skinny ORM configuration
  "org.skinny-framework" %% "skinny-orm" % "3.0.3",
  //
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  //Scala Guice
  "net.codingwell" %% "scala-guice" % "4.2.6",
  "org.json4s" %% "json4s-jackson" % "3.6.7"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.flinters.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.flinters.binders._"

scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(DanglingCloseParenthesis, Preserve)