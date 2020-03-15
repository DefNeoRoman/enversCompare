package app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {

    @GetMapping("/home")
    fun blog(): String {
        return "hello"
    }
}