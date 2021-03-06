# Shifter

Toolkit for building lean and mean web services in Scala.

## Quick Description

The project is made of several smaller projects, that can be used independently:

* **shifter-core** - complements to Scala's standard library
* **shifter-geoip** - wrapper around Maxwind's GeoIP client, can
  download the
  [GeoLite City database](http://dev.maxmind.com/geoip/geolite) by
  itself  
* **shifter-http-client** - wrapper around
  [Ning's AsyncHttpClient](https://github.com/AsyncHttpClient/async-http-client)
  for working with
  [Futures/Promises](http://docs.scala-lang.org/sips/pending/futures-promises.html)
* **shifter-db** - wrapper around JDBC
* **shifter-migrations** - a simple system for dealing with
  migrations, like database migrations, though usage isn't
  restricted to JDBC databases at all
* **shifter-cache** - wrapper around
  [SpyMemcached](http://code.google.com/p/spymemcached/) for working
  with
  [Futures/Promises](http://docs.scala-lang.org/sips/pending/futures-promises.html),
  also contains a stupidly simple in-memory cache implementation of
  the same interface (see the [README](https://github.com/alexandru/shifter/blob/master/cache/README.md) for samples)
* **shifter-web-api**, **shifter-web-jetty8**, **shifter-web-jetty9** - for servicing web requests, built over Servlets 3.0 and Jetty

## Usage From SBT

Add these resolvers:

```
resolvers ++= Seq(
  "BionicSpirit Releases" at "http://maven.bionicspirit.com/releases/",
  "BionicSpirit Snapshots at "http://maven.bionicspirit.com/snapshots/"
)
```

You may need other resolvers, depending on what subprojects you want,
but right now you can get away with these:

```scala
resolvers ++= Seq(
  // just in case you don't have it already
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  // for SpyMemcached (shifter-cache dependency)
  "Spy" at "http://files.couchbase.com/maven2/",
  // for Shifter
)
```

Specify the dependency for individual subprojects:

```scala
dependencies += "shifter" %% "shifter-cache" % "0.3.106-SNAPSHOT"
```

Or for the whole project, pulling in all required dependencies:

```scala
dependencies += "shifter" %% "shifter" % "0.3.106-SNAPSHOT"
```
