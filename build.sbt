val Scala_212 = "2.12.11"
val scalatest = "org.scalatest" %% "scalatest" % "3.1.1" % Test 
val cats_core = "org.typelevel" %% "cats-core" % "2.0.0"
val cats_effect = "org.typelevel" %% "cats-effect" % "2.0.0"
val kindProjector = compilerPlugin("org.spire-math" %% "kind-projector" % "0.9.4")

inThisBuild(List(
scalaVersion := Scala_212,
organization := "com.chloejay",
homepage := Some(url("https://github.com/Chloejay/minimal")),
developers := List(
Developer(
    "chloe",
    "Chloe Ji",
    "chloejiy@gmail.com",
    url("https://chloejay.github.io/")
)))
)

lazy val minimal = (project in file(".")).
settings(moduleName := "minimal",
libraryDependencies ++= Seq(
    scalatest,
    cats_core,
    cats_effect,
    kindProjector
    )
)
scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds",
  "-Ypartial-unification")
// scalacOptions += "-Ypartial-unification"
