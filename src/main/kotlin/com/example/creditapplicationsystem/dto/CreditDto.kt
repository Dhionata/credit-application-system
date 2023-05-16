package com.example.creditapplicationsystem.dto

import com.example.creditapplicationsystem.entity.Credit
import com.example.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.springframework.format.annotation.NumberFormat
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid input") @field:NumberFormat val creditValue: BigDecimal,
    @field:FutureOrPresent(message = "You cannot pay in the past!") val dayFirstOfInstallment: LocalDate,
    @field:DecimalMin(value = "1") val numberOfInstallment: Int,
    @field:Positive(message = "Invalid input") val customerId: Long
) {
    fun toEntity(): Credit {
        return Credit(
            customer = Customer(id = customerId),
            creditValue = creditValue,
            dayFirstIntallment = dayFirstOfInstallment,
            numberOfInstallments = numberOfInstallment,
        )
    }
}
