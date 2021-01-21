package port.primary.webService.src.main.scala.postManagement.port.primary.webService.restAdapter.dto.post

import domain.src.main.scala.postManagement.domain.internal.post.model.Post
import play.api.libs.json.{ Json, OFormat }

case class PostJson(
    id: Option[Long],
    title: String,
    createdAt: Option[String],
    updatedAt: Option[String],
    createdBy: Long,
    content: Option[String],
    thumbnail: Option[String]
)

object PostResponse {

  def apply(posts: Seq[Post]): Seq[PostJson] = posts.map(PostResponse(_))

  def apply(post: Post): PostJson = PostJson(
    id = Some(post.identifier.value),
    title = post.title,
    createdAt = post.createdAt.map(_.toString("yyyy-MM-dd")),
    updatedAt = post.updatedAt.map(_.toString("yyyy-MM-dd")),
    createdBy = post.createdBy,
    content = post.content,
    thumbnail = post.thumbnail
  )
}
