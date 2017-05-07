enablePlugins(ScalaJSPlugin)
name := "practice"

version := "1.0"

scalaVersion := "2.12.2"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"
