package domain.src.main.scala.postManagement.domain.internal.post.model

import org.joda.time.DateTime
import utility.src.main.scala.postManagement.utility.model.Fields

trait PostFields extends Fields {
  val title: String
  val updatedAt: Option[DateTime]
  val createdAt: Option[DateTime]
  val createdBy: Long
  val content: Option[String]
  val thumbnail: Option[String]
}
