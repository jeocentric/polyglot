package models

import models.PersistenceContext._
import net.fwbrasil.activate.migration.Migration

final class CreateSchema extends Migration {

  def timestamp = System.currentTimeMillis

  def up = {

    removeAllEntitiesTables.ifExists
    createTableForAllEntities.ifNotExists
  }
}