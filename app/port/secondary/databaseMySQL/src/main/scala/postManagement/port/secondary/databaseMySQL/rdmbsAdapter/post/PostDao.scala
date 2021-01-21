package port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter.post

import domain.src.main.scala.postManagement.domain.internal.post.model.PostFields
import port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter.CRUDMapperWithId
import scalikejdbc.WrappedResultSet
import skinny.orm.Alias

private[post] class PostDao extends CRUDMapperWithId[Long, PostFields, PostRecord] {
  override lazy val defaultAlias: Alias[PostRecord] = createAlias("posts")
  override lazy val tableName = "posts"
  override lazy val primaryKeyFieldName = "id"

  override def columnNames: Seq[String] = Seq(
    "id",
    "title",
    "created_at",
    "updated_at",
    "created_by",
    "content",
    "thumbnail"
  )

  override def toNamedValues(record: PostRecord): Seq[(Symbol, Any)] = Seq(
    Symbol("id") -> record.id,
    Symbol("title") -> record.title,
    Symbol("created_at") -> record.createdAt,
    Symbol("updated_at") -> record.updatedAt,
    Symbol("created_by") -> record.createdBy,
    Symbol("content") -> record.content,
    Symbol("thumbnail") -> record.thumbnail
  )

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[PostRecord]): PostRecord = {

    PostRecord(
      id = rs.get(n.id),
      title = rs.get(n.title),
      createdAt = rs.get(n.createdAt),
      updatedAt = rs.get(n.updatedAt),
      createdBy = rs.get(n.createdBy),
      content = rs.get(n.content),
      thumbnail = rs.get(n.thumbnail)
    )
  }

  override def idToRawValue(id: Long): Long = id

  override def rawValueToId(value: Any): Long = value.asInstanceOf[Long]
}
