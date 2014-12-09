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
    val out = baseDirectory.value / "cafedoku"
    IO.write(out, contents)
    out.setExecutable(true)
    out
  }

lazy val root = (project in file(".")).
  settings(
    name := "CafeDoku",
    version := "1.0",
    scalaVersion := "2.11.4",
    cafedokuSetting,
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"
  ).
  dependsOn(cafeSat)

lazy val cafeSat = {
  val commit = "b20ab56dec599c91e51d33dc4512a55fafeea497"
  val githubLink = s"git://github.com/regb/scabolic.git#$commit"
  RootProject(uri(githubLink))
}
