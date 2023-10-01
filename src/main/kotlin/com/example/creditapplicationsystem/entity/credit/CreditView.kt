package com.example.creditapplicationsystem.entity.credit

import com.example.creditapplicationsystem.enummeration.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    private val creditCode: UUID,
    private val creditValue: BigDecimal,
    private val numberOfInstallment: Int,
    private val status: Status,
    private val emailCustomer: String,
    private val incomeCustomer: BigDecimal?,
) {

    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer.email,
        incomeCustomer = credit.customer.income
    )
}
