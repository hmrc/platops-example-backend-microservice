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

import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import uk.gov.hmrc.mongo.test.DefaultPlayMongoRepositorySupport

import java.time.Instant
import java.time.temporal.ChronoUnit
import scala.concurrent.ExecutionContext.Implicits.global

class ExampleRepositorySpec
  extends AnyWordSpec
     with Matchers
     with OptionValues
     with DefaultPlayMongoRepositorySupport[Address]
     with ScalaFutures
     with IntegrationPatience:
  
  override val repository: ExampleRepository = ExampleRepository(mongoComponent)

  "The example" should:
    "be able to save an address to mongo and read it back" in:
      val anAddress = Address("Flat 2", "Some Road", "AAAAAA", "London", Instant.now().truncatedTo(ChronoUnit.MILLIS))

      repository.insert(anAddress).futureValue
      repository.findAll().futureValue.headOption.value shouldBe anAddress
