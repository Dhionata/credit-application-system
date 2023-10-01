package com.example.creditapplicationsystem.repository

import com.example.creditapplicationsystem.entity.customer.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long>
