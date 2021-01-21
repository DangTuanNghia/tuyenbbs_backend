package port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter

import scalikejdbc.{ AutoSession, DBSession }
import utility.src.main.scala.postManagement.utility.model
import utility.src.main.scala.postManagement.utility.repository.{ IOContext, Repository, ResolveAllFeatureRepository }

import scala.util.{ Success, Try }

trait BaseRepositoryOnJDBC[Identifier <: model.Identifier[_], Fields <: model.Fields, Entity <: model.Entity[Identifier], Record <: model.Record]
  extends Repository[Identifier, Fields, Entity] {

  protected def getDBSession(implicit ctx: IOContext): Try[DBSession] = {
    ctx match {
      case IOContextOnJDBC(session) => Success(session)
      case _                        => Success(AutoSession)
    }
  }

  protected def withDBSession[T](f: DBSession => T)(implicit ctx: IOContext): Try[T] = {
    getDBSession.map(f)
  }
}

trait RepositoryWithIdOnJDBC[Identifier <: model.Identifier[_], Fields <: model.Fields, Entity <: model.Entity[Identifier], RecordId, Record <: model.Record]
  extends BaseRepositoryOnJDBC[Identifier, Fields, Entity, Record] {

  type DAO <: CRUDMapperWithId[RecordId, Fields, Record]

  protected[this] val dao: DAO

  protected def convertToRecordId(identifier: Identifier): RecordId
}

trait ResolveAllWithIdFeatureRepositoryOnJDBC[Identifier <: model.Identifier[_], Fields <: model.Fields, Entity <: model.Entity[Identifier], RecordId, Record <: model.Record]
  extends RepositoryWithIdOnJDBC[Identifier, Fields, Entity, RecordId, Record]
  with ResolveAllFeatureRepository[Identifier, Fields, Entity] {

  protected def convertToEntity(record: Record): Entity

  def resolveAll()(implicit ctx: IOContext): Try[Seq[Entity]] = withDBSession { implicit session =>
    dao.findAll().map(convertToEntity)
  }

  //  def resolveAll()(implicit ctx: IOContext): Try[Seq[Entity]]
}

trait BasicWithIdFeatureRepositoryOnJDBC[Identifier <: model.Identifier[_], Fields <: model.Fields, Entity <: model.Entity[Identifier], RecordId, Record <: model.Record]
  extends ResolveAllWithIdFeatureRepositoryOnJDBC[Identifier, Fields, Entity, RecordId, Record]
