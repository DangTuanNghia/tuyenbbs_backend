package domain.src.main.scala.postManagement.domain.internal.post.model

import org.joda.time.DateTime
import utility.src.main.scala.postManagement.utility.model.Entity

trait Post extends Entity[PostId] with PostFields

object Post {
  def apply(
    identifier: PostId,
    title: String,
    createdAt: Option[DateTime],
    updatedAt: Option[DateTime],
    createdBy: Long,
    content: Option[String],
    thumbnail: Option[String]): Post = PostImpl(
    identifier,
    title,
    createdAt,
    updatedAt,
    createdBy,
    content,
    thumbnail)

  def unapply(arg: Post): Option[Nothing] = None
}
