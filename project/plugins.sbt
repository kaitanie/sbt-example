// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.1.0")

addSbtPlugin("com.typesafe.sbteclipse" %% "sbteclipse-plugin" % "2.1.1")

