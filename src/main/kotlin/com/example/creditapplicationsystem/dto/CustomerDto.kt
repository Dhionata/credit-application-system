package com.example.creditapplicationsystem.dto

import com.example.creditapplicationsystem.entity.Address
import com.example.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import org.springframework.format.annotation.NumberFormat
import java.math.BigDecimal

data class CustomerDto(
    @field:NotBlank(message = "Invalid input") val firstName: String,
    @field:NotBlank(message = "Invalid input") val lastName: String,
    @field:NotBlank(message = "Invalid input") @field:CPF(message = "this's invalid CPF") val cpf: String,
    @field:NotNull(message = "Invalid input") @field:NumberFormat val income: BigDecimal,
    @field:NotBlank(message = "Invalid input") @field:Email val email: String,
    @field:NotBlank(message = "Invalid input") val password: String,
    @field:NotBlank(message = "Invalid input") val zipCode: String,
    @field:NotBlank(message = "Invalid input") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = lastName,
        cpf = cpf,
        income = income,
        email = email,
        password = password,
        address = Address(
            zipCode = zipCode,
            street = street
        )
    )
}
