package chris.han.firstspringboot.service

import org.springframework.stereotype.Service

@Service
class ExampleService {
  fun getHello(name: String) = "hello $name!"
}
