package crudMySql

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.LockModeType
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Service
class CrudService {

    companion object {
        private var log = LoggerFactory.getLogger(CrudService::class.java)
    }

    @Autowired
    private lateinit var crudRepo:CrudRepo

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Transactional
    fun pessimisticRead(id:Long):Person{
        var person = crudRepo.findById(id).get()
        entityManager.lock(person,LockModeType.PESSIMISTIC_READ)
        log.info("read:going to sleep with person:$person")
        Thread.sleep(10000)
        person.name = "sonu"
        log.info("read:woke to sleep with entity:${person}")
        return crudRepo.save(person)
    }

    @Transactional
    fun pessimisticWrite(id:Long):Person{
        var person = crudRepo.findById(id).get()
        entityManager.lock(person,LockModeType.PESSIMISTIC_WRITE)
        log.info("write:going to sleep with person:${person}")
        Thread.sleep(10000)
        person.name = "monu"
        log.info("write:woke to sleep with entity:${person}")
        return crudRepo.save(person)
    }

    fun getPerson(id:Long):Person{
        return crudRepo.findById(id).get()
    }

    @Transactional
    fun updatePerson(id: Long): Person {
        var person = crudRepo.findById(id).get()
        log.info("updating with person:${person}")
        entityManager.lock(person,LockModeType.PESSIMISTIC_WRITE)
        person.roll = 5
        return crudRepo.save(person)
    }
}
