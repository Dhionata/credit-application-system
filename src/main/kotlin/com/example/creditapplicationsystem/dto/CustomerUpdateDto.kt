package com.example.creditapplicationsystem.dto

import com.example.creditapplicationsystem.entity.customer.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.NumberFormat
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotBlank(message = "Invalid input {firstName}") val firstName: String,
    @field:NotBlank(message = "Invalid input {lastName}") val lastName: String,
    @field:NotBlank(message = "Invalid input {email}") @field:Email(message = "This's invalid Email") val email: String,
    @field:NotNull(message = "Invalid input {income}") @field:NumberFormat val income: BigDecimal,
    @field:NotBlank(message = "Invalid input {zipCode}") val zipCode: String,
    @field:NotBlank(message = "Invalid input {street}") val street: String,
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = firstName
        customer.lastName = lastName
        customer.email = email
        customer.income = income
        customer.address.street = street
        customer.address.zipCode = zipCode
        return customer
    }

}
