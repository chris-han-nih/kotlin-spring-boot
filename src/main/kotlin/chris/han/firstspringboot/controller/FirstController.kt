package chris.han.firstspringboot.controller

import chris.han.firstspringboot.`interface`.ServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FirstController {
  @Autowired
  lateinit var service: ServiceInterface
  
  @GetMapping("/hello/{name}")
  @ResponseBody
  fun hello(@PathVariable name: String) = service.getHello(name)
}
