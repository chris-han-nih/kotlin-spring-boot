package chris.han.firstspringboot.service

import chris.han.firstspringboot.`interface`.ServiceInterface
import org.springframework.stereotype.Service

@Service
class ExampleService: ServiceInterface {
  override fun getHello(name: String) = "hello $name!"
}
