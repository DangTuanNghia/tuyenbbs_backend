package domain.src.main.scala.postManagement.domain.internal.post

import domain.src.main.scala.postManagement.domain.internal.post.model.{ Post, PostFields, PostId }
import utility.src.main.scala.postManagement.utility.repository.FeatureWithIdFieldRepository

trait PostRepository extends FeatureWithIdFieldRepository[PostId, PostFields, Post]
