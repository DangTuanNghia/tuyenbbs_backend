package utility.src.main.scala.postManagement.utility.repository

import utility.src.main.scala.postManagement.utility.model

import scala.util.Try

trait Repository[Identifier <: model.Identifier[_], Fields <: model.Fields, Entity <: model.Entity[Identifier]]

trait ResolveAllFeatureRepository[Identifier <: model.Identifier[_], Fields <: model.Fields, Entity <: model.Entity[Identifier]]
  extends Repository[Identifier, Fields, Entity] {
  def resolveAll()(implicit ctx: IOContext = IOContext): Try[Seq[Entity]]
}

trait BasicFeatureRepository[Identifier <: model.Identifier[_], Fields <: model.Fields, Entity <: model.Entity[Identifier]]
  extends Repository[Identifier, Fields, Entity]
  with ResolveAllFeatureRepository[Identifier, Fields, Entity]

trait FeatureWithIdFieldRepository[Identifier <: model.Identifier[_], Fields <: model.Fields, Entity <: model.Entity[Identifier]]
  extends BasicFeatureRepository[Identifier, Fields, Entity]