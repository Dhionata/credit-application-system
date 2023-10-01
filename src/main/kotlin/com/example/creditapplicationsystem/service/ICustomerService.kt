package com.example.creditapplicationsystem.service

import com.example.creditapplicationsystem.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer
    fun findByID(id: Long): Customer
    fun delete(id: Long)
}
