package chris.han.firstspringboot.service

import chris.han.firstspringboot.`interface`.CustomerService
import chris.han.firstspringboot.model.Customer
import chris.han.firstspringboot.model.Telephone
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl: CustomerService {
  companion object {
    val initialCustomers = arrayOf(
      Customer(1, "Kotlin"),
      Customer(2, "Spring", Telephone("+86", "7123456789")),
      Customer(3, "Microservice", Telephone("+83", "7123456789")),
    )
  }
  
  val customers = ConcurrentHashMap(initialCustomers.associateBy(Customer::id))
  
  override fun getCustomer(id: Int) = customers[id]
  
  override fun createCustomer(customer: Customer) {
    customers[customer.id] = customer
  }
  
  override fun deleteCustomer(id: Int) {
    customers.remove(id)
  }
  
  override fun updateCustomer(id: Int, customer: Customer) {
    deleteCustomer(id)
    createCustomer(customer)
  }
  
  override fun searchCustomers(nameFilter: String): List<Customer> {
    return customers.filter {
      it.value.name.contains(nameFilter, true)
    }.map(Map.Entry<Int, Customer>::value).toList()
  }
}
