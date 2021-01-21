package port.primary.webService.src.main.scala.postManagement.port.primary.webService.restAdapter.controller

import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.write
import play.api.mvc.{ AbstractController, ControllerComponents, Result }
import port.primary.webService.src.main.scala.postManagement.port.primary.webService.restAdapter.dto.APIResult

abstract class APIController(cc: ControllerComponents) extends AbstractController(cc) {
  implicit val formats = DefaultFormats

  protected def success[T](result: Seq[T]): Result =
    Ok(write(APIResult.toSuccessJson(result)))
}
