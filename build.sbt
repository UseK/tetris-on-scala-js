lazy val root = project.in(file(".")).
  aggregate(tetrisJS, tetrisJVM).
  settings(
    publish := {},
    publishLocal := {},
    publishM2 := {}
  )

lazy val tetris = crossProject.in(file(".")).
  settings(
    inThisBuild(List(
      organization := "com.usek.tetris",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Tetris",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.1" % Test
).
  jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % Provided
    // Add JVM-specific settings here
  ).
  jsSettings(
    scalaJSUseMainModuleInitializer := true,
    // Add JS-specific settings here
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"
  )

lazy val tetrisJVM = tetris.jvm
lazy val tetrisJS = tetris.js

