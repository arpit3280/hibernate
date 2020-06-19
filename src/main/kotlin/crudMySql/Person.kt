package crudMySql

import javax.persistence.*
import javax.persistence.Id

@Entity
@Table(name = "person")
class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long,
        var name:String,
        var roll:Int
) {
        override fun toString(): String {
                return "Person(id=$id, name='$name', roll=$roll)"
        }
}
