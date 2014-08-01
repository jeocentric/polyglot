package controllers

import models.PersistenceContext._
import models.Foo
import net.fwbrasil.activate.play.EntityForm
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import views.html

object Foos extends Controller {

  val fooForm = EntityForm[Foo](
    _.name -> text
  )

  def read = Action {
    transactional {
      Ok(html.foos.read(all[Foo]))
    }
  }

  def edit(id: String) = Action {
    transactional {
      byId[Foo](id).map {
        foo => Ok(html.foos.edit(id, fooForm.fillWith(foo)))
      }
    }.getOrElse(NotFound)
  }

  def update(id: String) = Action {
    implicit request =>
    transactional {
      fooForm.bindFromRequest.fold(
        formWithErrors => BadRequest(html.foos.edit(id, formWithErrors)),
        fooData => {
          fooData.updateEntity(id).id
          Ok(html.foos.read(all[Foo]))
        }
      )
    }
  }

  def create = Action {
    transactional {
      Ok(html.foos.create(fooForm))
    }
  }

  def save = Action {
    implicit request =>
    transactional {
      fooForm.bindFromRequest.fold(
        formWithErrors => BadRequest(html.foos.create(formWithErrors)),
        fooData => {
          fooData.createEntity.id
          Ok(html.foos.read(all[Foo]))
        }
      )
    }
  }

  def delete(id: String) = Action {
    transactional {
      byId[Foo](id).get.delete
      Ok(html.foos.read(all[Foo]))
    }
  }
}