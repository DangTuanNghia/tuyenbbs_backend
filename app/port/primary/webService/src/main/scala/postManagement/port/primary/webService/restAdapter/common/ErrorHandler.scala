package port.primary.webService.src.main.scala.postManagement.port.primary.webService.restAdapter.common

import play.api.http.DefaultHttpErrorHandler
import play.api.mvc.Results._
import play.api.mvc._
import play.api.routing.Router
import play.api.{ Configuration, Environment, OptionalSourceMapper }

import javax.inject.{ Inject, Provider, Singleton }
import scala.concurrent.Future

@Singleton
class ErrorHandler @Inject() (
    env: Environment,
    config: Configuration,
    sourceMapper: OptionalSourceMapper,
    router: Provider[Router]) extends DefaultHttpErrorHandler(env, config, sourceMapper, router) {

  override def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] = {
    Future.successful(
      Status(statusCode)("A client error occurred: " + message)
    )
  }

  override def onServerError(request: RequestHeader, exception: Throwable): Future[Result] = {
    Future.successful(
      InternalServerError("A server error occurred: " + exception.getMessage)
    )
  }
}
