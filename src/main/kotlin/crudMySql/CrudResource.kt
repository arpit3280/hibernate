package crudMySql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/crud")
class CrudResource {

    @Autowired
    private lateinit var crudService:CrudService


    @PostMapping("/write")
    fun pessimisticWrite(@RequestParam id:Long):Person{
        return crudService.pessimisticWrite(id)
    }

    @PostMapping("/read")
    fun pessimisticRead(@RequestParam id:Long):Person{
        return crudService.pessimisticRead(id)
    }

    @GetMapping("/get")
    fun getPerson(@RequestParam id:Long):Person{
        return crudService.getPerson(id)
    }

    @PostMapping("/update")
    fun updatePerson(@RequestParam id:Long):Person{
        return crudService.updatePerson(id)
    }


}