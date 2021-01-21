package application.src.main.scala.postManagement.application.feature.service.post

import domain.src.main.scala.postManagement.domain.internal.post.PostRepository
import domain.src.main.scala.postManagement.domain.internal.post.model.Post

import javax.inject.{ Inject, Singleton }
import scala.util.Try

@Singleton
class PostService @Inject() (postRepository: PostRepository) {
  def getAll: Try[Seq[Post]] = postRepository.resolveAll()

}
