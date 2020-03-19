package app.feature

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

private const val JSON = "application/json"
@RestController
class BookController {

    @Autowired
    private lateinit var service: BookService
    private val gson: Gson = Gson()

    @GetMapping("/getAll")
    fun getAll(): String {
        return gson.toJson(service.findAll())
    }
    @GetMapping("/hello")
    fun hello(): String {
        return "OK"
    }

    @PostMapping("/save", consumes = [JSON])
    fun saveBook(@RequestBody book: Book): String {
        service.save(book)
        return "OK"
    }

    @PutMapping("/update")
    fun updateBook(@RequestBody book: Book): String {
        service.update(book)
        return "OK"
    }
}