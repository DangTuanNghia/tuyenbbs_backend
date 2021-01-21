package domain.src.main.scala.postManagement.domain.internal.post.model

import org.joda.time.DateTime

case class PostImpl(
    identifier: PostId = PostId(0),
    title: String,
    override val createdAt: Option[DateTime],
    override val updatedAt: Option[DateTime],
    createdBy: Long,
    content: Option[String],
    thumbnail: Option[String]) extends Post
