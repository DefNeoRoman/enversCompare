package app

import org.hibernate.envers.Audited
import javax.persistence.GeneratedValue
import javax.persistence.Id
@Audited
data class Book(
    @Id
    @GeneratedValue
    val id: Int,
    val name: String,
    val pages: Int
) {


}