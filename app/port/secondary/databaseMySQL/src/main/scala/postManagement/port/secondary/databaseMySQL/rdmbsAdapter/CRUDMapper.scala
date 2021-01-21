package port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter

import skinny.orm.SkinnyMapperBase

trait CRUDMapper[ObjectFields, Entity] extends SkinnyMapperBase[Entity] {
  def toNamedValues(entity: Entity): Seq[(Symbol, Any)]
}
