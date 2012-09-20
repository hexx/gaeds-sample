scalaVersion := "2.9.1"

resolvers +=
  Resolver.url("sbt-plugin-releases",
    url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-filter" % "0.6.4",
  "com.github.hexx" %% "gaeds" % "0.1.0",
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "org.mortbay.jetty" % "jetty" % "6.1.26" % "container"
)

seq(appengineSettings: _*)

seq(Twirl.settings: _*)
