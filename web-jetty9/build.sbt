name := "shifter-web-jetty9"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.0.0",
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "ch.qos.logback" % "logback-classic" % "1.0.6",
  "org.eclipse.jetty" % "jetty-webapp" % "9.0.1.v20130408",
  "org.eclipse.jetty" % "jetty-server" % "9.0.1.v20130408",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "provided;test;runtime" artifacts (Artifact("javax.servlet", "jar", "jar")),
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "junit" % "junit" % "4.10" % "test"
)

