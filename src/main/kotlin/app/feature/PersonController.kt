package app.feature
import app.feature.service.UtilService
import app.feature.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

private const val JSON = "application/json"
@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    private lateinit var service: PersonService
    @Autowired
    private lateinit var gson: UtilService

    @GetMapping("/getAll")
    fun getAll(): String {
        return gson.toJson(service.findAll())
    }
    @GetMapping("/hello")
    fun hello(): String {
        return "OK"
    }

    @PostMapping("/save", consumes = [JSON])
    fun saveperson(@RequestBody person: Person): String {
        service.save(person)
        return "OK"
    }

    @PutMapping("/update")
    fun updateperson(@RequestBody person: Person): String {
        service.update(person)
        return "OK"
    }
}