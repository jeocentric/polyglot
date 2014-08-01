import play.Project._

name := "polyglot"

version := "1.0"

scalaVersion := "2.10.4"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.typesafeRepo("releases"),
  Resolver.sonatypeRepo("releases"),
  "fwbrasil.net" at "http://fwbrasil.net/maven"
)

libraryDependencies ++= Seq(
  "net.fwbrasil" %% "activate-play" % "1.6" exclude("org.scala-stm", "scala-stm_2.10.0"),
  "net.fwbrasil" %% "activate-jdbc" % "1.6",
  "net.fwbrasil" %% "activate-mongo" % "1.6",
  "org.postgresql" % "postgresql" % "9.3-1101-jdbc41"
)

playScalaSettings