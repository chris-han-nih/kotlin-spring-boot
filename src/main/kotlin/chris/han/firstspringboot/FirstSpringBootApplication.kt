package chris.han.firstspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FirstSpringBootApplication

fun main(args: Array<String>) {
  runApplication<FirstSpringBootApplication>(*args)
}
