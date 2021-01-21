package application.src.main.scala.postManagement.application.module

import com.google.inject.AbstractModule
import domain.src.main.scala.postManagement.domain.internal.post.PostRepository
import net.codingwell.scalaguice.ScalaModule
import port.secondary.databaseMySQL.src.main.scala.postManagement.port.secondary.databaseMySQL.rdmbsAdapter.post.PostRepositoryOnJDBCImpl

class BBSModule extends AbstractModule with ScalaModule {
  lazy val postRepository: PostRepository = new PostRepositoryOnJDBCImpl

  override def configure(): Unit = {
    bind(classOf[PostRepository]).toInstance(postRepository)
  }
}
