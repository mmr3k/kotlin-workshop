package refactored.domain

import common.DomainObject
import common.DomainRepository
import common.DomainService

class DomainServiceImpl(override val domainRepository: DomainRepository) : DomainService {

    override fun doSomething(): DomainObject =
        domainRepository.findDomainObject()
}