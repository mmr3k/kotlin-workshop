package refactored.domain

sealed class DomainException(type: String, open val info: String) : RuntimeException("[$type]: $info") {

    override fun fillInStackTrace() = this

    data class NotFound(override val info: String) : DomainException("NOT_FOUND", info)
    data class Validation(override val info: String) : DomainException("VALIDATION", info)
}
