/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.example.repositories

import javax.inject.{Inject, Singleton}
import play.api.libs.json.{OFormat, __}
import play.api.libs.functional.syntax._
import uk.gov.hmrc.mongo.MongoComponent
import uk.gov.hmrc.mongo.play.json.PlayMongoRepository

import scala.concurrent.{ExecutionContext, Future}

case class Address(
  line1   : String,
  line2   : String,
  postCode: String,
  town    : String
)

object Address {
  val mongoFormat: OFormat[Address] =
   ( (__ \ "line1"   ).format[String]
   ~ (__ \ "line2"   ).format[String]
   ~ (__ \ "postCode").format[String]
   ~ (__ \ "town"    ).format[String]
   )(Address.apply, unlift(Address.unapply))
}

@Singleton
class ExampleRepository @Inject()(
  mongoComponent: MongoComponent
)(implicit ec: ExecutionContext
) extends PlayMongoRepository[Address](
  mongoComponent = mongoComponent,
  collectionName = "reports",
  domainFormat   = Address.mongoFormat,
  indexes        = Seq.empty
) {
  def findAll(): Future[Seq[Address]] =
    collection.find().toFuture

  def insert(address: Address): Future[Unit] =
    collection.insertOne(address).toFuture.map(_ => ())
}
