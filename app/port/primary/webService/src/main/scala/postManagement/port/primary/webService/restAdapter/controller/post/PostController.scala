package port.primary.webService.src.main.scala.postManagement.port.primary.webService.restAdapter.controller.post

import application.src.main.scala.postManagement.application.feature.service.post.PostService
import play.api.mvc.{ Action, AnyContent, ControllerComponents }
import port.primary.webService.src.main.scala.postManagement.port.primary.webService.restAdapter.controller.APIController
import port.primary.webService.src.main.scala.postManagement.port.primary.webService.restAdapter.dto.post.PostResponse

import javax.inject.Inject

class PostController @Inject() (postService: PostService, cc: ControllerComponents) extends APIController(cc) {

  def list(): Action[AnyContent] = Action {
    success(PostResponse(postService.getAll.get))
  }

}

//class PostController @Inject() (cc: ControllerComponents) extends AbstractController(cc) {
//
//  def list(): Action[AnyContent] = Action {
//    val postImpl = new PostRepositoryOnJDBCImpl()
//    postImpl.resolveAll().get.foreach(println(_))
//    Ok("OK")
//  }
//
//}
