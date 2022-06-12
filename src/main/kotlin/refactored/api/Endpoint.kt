package refactored.api

import common.DomainObject
import common.DomainObjectApiResponse
import common.DomainService
import common.ResponseEntity
import refactored.domain.DomainException

class Endpoint(
    private val domainService: DomainService
) {

    fun handle(): ResponseEntity<*> =
        try {
            domainService.doSomething().toResponseEntity()
        } catch (e: DomainException) {
            e.toResponseEntity()
        } catch (e: Exception) {
            ResponseEntity.internalServerError()
        }

    private fun DomainObject.toResponseEntity() = ResponseEntity.ok(
        DomainObjectApiResponse(
            id = this.id,
            name = this.name
        )
    )

    private fun DomainException.toResponseEntity() = when(this) {
        is DomainException.NotFound -> ResponseEntity.notFound()
        is DomainException.Validation -> ResponseEntity.badRequest()
    }
}