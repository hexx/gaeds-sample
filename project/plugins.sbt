scalaVersion := "2.9.1"

addSbtPlugin("cc.spray" % "sbt-twirl" % "0.5.3")

addSbtPlugin("com.eed3si9n" % "sbt-appengine" % "0.4.0")

resolvers +=
  Resolver.url("sbt-plugin-releases",
    url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
