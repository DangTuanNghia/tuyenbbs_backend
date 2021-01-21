package port.primary.webService.src.main.scala.postManagement.port.primary.webService.restAdapter.dto

case class WarningParameter(key: String, code: String, message: String)

case class ErrorParameter(code: Int, message: String)

case class APIResult(
    success: Boolean,
    result: Option[Any] = None,
    warning: Option[Seq[WarningParameter]] = None,
    error: Option[ErrorParameter] = None)

object APIResult {
  def toSuccessJson(result: Any): APIResult = {
    APIResult(
      success = true,
      Some(result)
    )
  }

}
