lazy val cafedoku = taskKey[File]("Create the cafedoku run script")

lazy val cafedokuScriptTemplate = 
"""#!/bin/sh
java -classpath "%s" %s "$@"
"""

lazy val cafedokuSetting: Setting[Task[File]] = 
  cafedoku := { 
    val cp = (fullClasspath in Runtime).value
    val mainClass = "cafedoku.Main"
    val contents = cafedokuScriptTemplate.format(cp.files.absString, mainClass)
    val out = target.value / "cafedoku"
    IO.write(out, contents)
    out.setExecutable(true)
    out
  }

lazy val root = (project in file(".")).
  settings(
    name := "CafeDoku",
    version := "1.0",
    scalaVersion := "2.11.7",
    cafedokuSetting,
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"
  ).
  dependsOn(cafeSat)

lazy val cafeSat = {
  val commit = "e39e2fb11b66b5daf8002cb5bf457a2a2f889e05"
  val githubLink = s"git://github.com/regb/cafesat.git#$commit"
  RootProject(uri(githubLink))
}
