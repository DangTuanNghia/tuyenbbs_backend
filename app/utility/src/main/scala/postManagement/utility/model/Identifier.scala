package utility.src.main.scala.postManagement.utility.model

trait Identifier[+A] extends Serializable {
  def value: A
}
