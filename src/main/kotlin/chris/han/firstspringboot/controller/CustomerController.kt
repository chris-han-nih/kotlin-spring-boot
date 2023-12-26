package chris.han.firstspringboot.controller

import chris.han.firstspringboot.`interface`.CustomerService
import chris.han.firstspringboot.model.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController {
  @Autowired
  private lateinit var customerService: CustomerService
  
  @GetMapping("/customers")
  fun searchCustomers(
    @RequestParam(required = false, defaultValue = "") name: String,
  ) = ResponseEntity(customerService.searchCustomers(name), HttpStatus.OK)
  
  @GetMapping("/customers/{id}")
  fun getCustomerById(
    @PathVariable id: Int
  ): ResponseEntity<Customer?> {
    val customer = customerService.getCustomer(id)
    
    return if (customer != null)
      ResponseEntity(customer, HttpStatus.OK)
    else
      ResponseEntity(null, HttpStatus.NOT_FOUND)
  }
  
  @PostMapping("/customers")
  fun createCustomer(
    @RequestBody customer: Customer,
  ): ResponseEntity<Unit> {
    customerService.createCustomer(customer)
    return ResponseEntity(Unit, HttpStatus.CREATED)
  }
  
  @PutMapping("/customers/{id}")
  fun updateCustomer(
    @PathVariable id: Int,
    @RequestBody customer: Customer,
  ): ResponseEntity<Unit> {
    var status = HttpStatus.NOT_FOUND
    if (customerService.getCustomer(id) != null) {
      customerService.updateCustomer(id, customer)
      status = HttpStatus.ACCEPTED
    }
    return ResponseEntity(Unit, status)
  }
  
  @DeleteMapping("/customers/{id}")
  fun deleteCustomer(
    @PathVariable id: Int,
  ): ResponseEntity<Unit>{
    var status = HttpStatus.NOT_FOUND
    if (customerService.getCustomer(id) != null) {
      customerService.deleteCustomer(id)
      status = HttpStatus.OK
    }
    return ResponseEntity(Unit, status)
  }
}
