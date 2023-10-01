package com.example.creditapplicationsystem.entity.customer

import java.math.BigDecimal

data class CustomerView(
    private val fisrtName: String,
    private val lastName: String,
    private val cpf: String,
    private val income: BigDecimal,
    private val email: String,
    private val zipCode: String,
    private val street: String
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
