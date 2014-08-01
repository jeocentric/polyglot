package controllers

import models.PersistenceContext._
import models.Bar
import net.fwbrasil.activate.play.EntityForm
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import views.html

object Bars extends Controller {

  val barForm = EntityForm[Bar](
    _.name -> text
  )

  def read = Action {
    transactional {
      Ok(html.bars.read(all[Bar]))
    }
  }

  def edit(id: String) = Action {
    transactional {
      byId[Bar](id).map {
        bar => Ok(html.bars.edit(id, barForm.fillWith(bar)))
      }
    }.getOrElse(NotFound)
  }

  def update(id: String) = Action {
    implicit request =>
    transactional {
      barForm.bindFromRequest.fold(
        formWithErrors => BadRequest(html.bars.edit(id, formWithErrors)),
        barData => {
          barData.updateEntity(id).id
          Ok(html.bars.read(all[Bar]))
        }
      )
    }
  }

  def create = Action {
    transactional {
      Ok(html.bars.create(barForm))
    }
  }

  def save = Action {
    implicit request =>
    transactional {
      barForm.bindFromRequest.fold(
        formWithErrors => BadRequest(html.bars.create(formWithErrors)),
        barData => {
          barData.createEntity.id
          Ok(html.bars.read(all[Bar]))
        }
      )
    }
  }

  def delete(id: String) = Action {
    transactional {
      byId[Bar](id).get.delete
      Ok(html.bars.read(all[Bar]))
    }
  }
}