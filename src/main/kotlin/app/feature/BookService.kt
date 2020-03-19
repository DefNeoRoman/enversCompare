@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package app.feature

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class BookService{
    @Autowired
    private lateinit var repository: BookRepository
    @PostConstruct
    fun init(){
        print("set test data")
        repository.save(Book(pages=900,name="book1"))
        repository.save(Book(pages=902,name="book2"))
        repository.save(Book(pages=903,name="book3"))
        repository.save(Book(pages=905,name="book4"))
        repository.save(Book(pages=907,name="book5"))
    }

    fun findAll(): Any? {
        return repository.findAll();
    }

    fun save(book: Book) {
       repository.save(book)
    }

    fun findById(id: Int?): Book {
       return repository.findById(id).get()
    }
    fun update(book:Book){
        val bookById = repository.findById(book.id).get()
        bookById.name = book.name
        bookById.pages = book.pages
        repository.save(bookById)
    }
}