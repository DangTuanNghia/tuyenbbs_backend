package utility.src.main.scala.postManagement.utility.model

trait Entity[ID <: Identifier[_]] extends RecordTimestamp {
  val identifier: ID
}
