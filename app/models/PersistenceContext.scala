package models

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.storage.StorageFactory

object PersistenceContext extends ActivateContext {

  // First Datasource
  val mongo = StorageFactory.fromSystemProperties("mongo")

  // Second Datasource
  val postgre = StorageFactory.fromSystemProperties("postgre")

  // Default Datasource for entities not specified in `def additionalStorages: Map`
  val storage = postgre

  // Datasource to be specifically used for a given entity, thus overriding the default Datasource
  override def additionalStorages = Map(
    mongo -> Set(classOf[Bar])
  )
}
