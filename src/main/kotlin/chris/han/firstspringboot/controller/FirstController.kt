package chris.han.firstspringboot.controller

import chris.han.firstspringboot.service.ExampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FirstController(
  val exampleService: ExampleService,
) {
  @GetMapping("/hello/{name}")
  @ResponseBody
  fun hello(@PathVariable name: String) = exampleService.getHello(name)
}
