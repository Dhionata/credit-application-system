package com.example.creditapplicationsystem.entity.credit

import java.math.BigDecimal
import java.util.*

data class CreditViewList(
    private val creditCode: UUID,
    private val creditValue: BigDecimal,
    private val numberOfInstallment: Int,
) {

    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallments
    )
}
