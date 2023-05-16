package com.example.creditapplicationsystem.dto

import com.example.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val fisrtName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
) {
    constructor(customer: Customer) : this(
        fisrtName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )
}
