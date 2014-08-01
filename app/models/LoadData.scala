package models

import models.PersistenceContext._
import net.fwbrasil.activate.migration.Migration

final class LoadData extends Migration {

  def timestamp = System.currentTimeMillis + 100

  def up = {

    customScript {

      val foo_1 = Foo("foo #1")
      val foo_2 = Foo("foo #2")
      val foo_3 = Foo("foo #3")

      val bar_1 = Bar("bar #1")
      val bar_2 = Bar("bar #2")
      val bar_3 = Bar("bar #3")
    }
  }
}
