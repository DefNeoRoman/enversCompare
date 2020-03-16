package app

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class BookController {

    @Autowired
    private lateinit var repository: BookRepository
    private val gson: Gson = Gson()

    @GetMapping("/getAll")
    fun hello(@RequestBody book: Book): String {
        return gson.toJson(repository.findAll())
    }

    @PostMapping("/save")
    fun saveBook(@RequestBody book: Book): String {
        repository.save(book)
        return "OK"
    }

    @PutMapping("/update")
    fun updateBook(@RequestBody book: Book): String {
        val bookById = repository.findById(book.id).get()
        bookById.name = book.name
        bookById.pages = book.pages
        repository.save(bookById)
        return "OK"
    }
}