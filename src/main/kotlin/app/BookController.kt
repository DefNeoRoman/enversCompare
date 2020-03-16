package app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {

    @Autowired
    private lateinit var repository : BookRepository

    @GetMapping("/home")
    fun hello(@RequestBody book: Book): String {
        return "OK"
    }
    @PostMapping("/save")
    fun saveBook(@RequestBody book: Book): String {
        repository.save(book)
        return "OK"
    }
    @PostMapping("/update")
    fun updateBook(@RequestBody book: Book): String {
        repository.findById(book.id)
        return "OK"
    }
}