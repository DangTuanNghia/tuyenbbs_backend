package port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter.post

import org.joda.time.DateTime
import utility.src.main.scala.postManagement.utility.model.Record

case class PostRecord(
    id: Long,
    title: String,
    override val createdAt: Option[DateTime],
    override val updatedAt: Option[DateTime],
    createdBy: Long,
    content: Option[String],
    thumbnail: Option[String]
) extends Record
