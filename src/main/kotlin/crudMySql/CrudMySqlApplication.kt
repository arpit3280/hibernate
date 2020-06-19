package crudMySql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrudMySqlApplication

fun main(args: Array<String>) {
	runApplication<CrudMySqlApplication>(*args)
}
