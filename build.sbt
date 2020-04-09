
name := "s3-client"

version := "0.1"

scalaVersion := "2.12.5"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:postfixOps")

libraryDependencies ++= {

  lazy val minioVersion = "6.0.13"
  lazy val commonsioVersion = "2.5"

  Seq(
    "commons-io" % "commons-io" % "2.5",
    "io.minio" % "minio" % minioVersion,
    "commons-io" % "commons-io" % commonsioVersion,
    "org.slf4j" % "slf4j-api" % "1.7.5",
    "ch.qos.logback" % "logback-classic" % "1.0.9",
    "software.amazon.awssdk" % "s3" % "2.11.9",
  )
}

resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)
