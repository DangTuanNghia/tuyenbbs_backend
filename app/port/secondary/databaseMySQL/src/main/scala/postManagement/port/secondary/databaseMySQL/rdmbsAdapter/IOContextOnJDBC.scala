package port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter

import scalikejdbc.DBSession
import utility.src.main.scala.postManagement.utility.repository.IOContext

case class IOContextOnJDBC(session: DBSession) extends IOContext
