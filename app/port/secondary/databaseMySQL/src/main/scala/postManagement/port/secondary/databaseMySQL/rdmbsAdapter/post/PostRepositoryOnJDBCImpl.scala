package port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter.post

import domain.src.main.scala.postManagement.domain.internal.post.PostRepository
import domain.src.main.scala.postManagement.domain.internal.post.model.{ Post, PostFields, PostId }
import port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter.BasicWithIdFeatureRepositoryOnJDBC

class PostRepositoryOnJDBCImpl(override protected[this] val dao: PostDao = new PostDao)
  extends PostRepository with BasicWithIdFeatureRepositoryOnJDBC[PostId, PostFields, Post, Long, PostRecord] {

  override type DAO = PostDao

  override protected def convertToEntity(record: PostRecord): Post = {
    Post(
      identifier = PostId(record.id),
      title = record.title,
      createdAt = record.createdAt,
      updatedAt = record.updatedAt,
      createdBy = record.createdBy,
      content = record.content,
      thumbnail = record.thumbnail
    )
  }

  override protected def convertToRecordId(id: PostId): Long = id.value
}
