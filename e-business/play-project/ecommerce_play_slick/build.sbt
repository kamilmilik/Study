name := """play-scala-slick-example"""

version := "2.7.x"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "com.typesafe.play" %% "play-slick" % "4.0.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "4.0.0"

libraryDependencies += "com.h2database" % "h2" % "1.4.197"

// mysql
//libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.15"


//sqlite
libraryDependencies += "org.xerial"        %  "sqlite-jdbc" % "3.21.0"

libraryDependencies += specs2 % Test

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"