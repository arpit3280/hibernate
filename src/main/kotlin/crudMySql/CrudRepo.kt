package crudMySql

import org.springframework.data.jpa.repository.JpaRepository

interface CrudRepo:JpaRepository<Person,Long> {
}