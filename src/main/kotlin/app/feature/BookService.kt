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
        repository.save(Book(pages=900,name="qwe"))
        repository.save(Book(pages=902,name="qwet"))
        repository.save(Book(pages=903,name="qwee"))
        repository.save(Book(pages=905,name="qwwe"))
        repository.save(Book(pages=907,name="wqwe"))
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
}