package chris.han.firstspringboot.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Customer(
  var id: Int,
  var name: String,
  var telephone: Telephone? = null,
)

data class Telephone(
  var countryCode: String = "",
  var telephoneNumber: String = "",
)
