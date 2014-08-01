import play.api.GlobalSettings

object Global extends GlobalSettings {

  System.setProperty("activate.storage.mongo.factory","net.fwbrasil.activate.storage.mongo.MongoStorageFactory")
  System.setProperty("activate.storage.mongo.host","localhost")
  System.setProperty("activate.storage.mongo.port","27017")
  System.setProperty("activate.storage.mongo.db","polyglot")
  System.setProperty("activate.storage.mongo.user","")
  System.setProperty("activate.storage.mongo.password","")
  System.setProperty("activate.storage.mongo.dialect","mongoIdiom")

  System.setProperty("activate.storage.postgre.factory","net.fwbrasil.activate.storage.relational.PooledJdbcRelationalStorageFactory")
  System.setProperty("activate.storage.postgre.jdbcDriver","org.postgresql.Driver")
  System.setProperty("activate.storage.postgre.user","")
  System.setProperty("activate.storage.postgre.password","")
  System.setProperty("activate.storage.postgre.url","jdbc:postgresql://localhost/polyglot")
  System.setProperty("activate.storage.postgre.dialect","postgresqlDialect")
}