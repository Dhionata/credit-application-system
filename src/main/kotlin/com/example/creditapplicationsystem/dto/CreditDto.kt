package com.example.creditapplicationsystem.dto

import com.example.creditapplicationsystem.entity.Credit
import com.example.creditapplicationsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberofInstallment: Int,
    val customerId: Long
) {
    fun toEntity(): Credit {
        return Credit(
            customer = Customer(id = customerId),
            creditValue = creditValue,
            dayFirstIntallment = dayFirstOfInstallment,
            numberOfInstallments = numberofInstallment,
        )
    }
}
