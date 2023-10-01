package com.example.creditapplicationsystem.service

import com.example.creditapplicationsystem.entity.credit.Credit
import java.util.*

interface ICreditService {

    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerID: Long): List<Credit>
    fun findByCreditCode(customerID: Long, creditCode: UUID): Credit
}
