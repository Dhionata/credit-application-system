package com.example.creditapplicationsystem.dto

import com.example.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotBlank(message = "Invalid input") val firstName: String,
    @field:NotBlank(message = "Invalid input") @field:NotBlank(message = "Invalid input {firstName}") val lastName: String,
    @field:NotBlank(message = "Invalid input") val income: BigDecimal,
    @field:NotBlank(message = "Invalid input") val zipCode: String,
    @field:NotBlank(message = "Invalid input") val street: String,
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = firstName
        customer.lastName = lastName
        customer.income = income
        customer.address.street = street
        customer.address.zipCode = zipCode
        return customer
    }

}
