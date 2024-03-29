package com.example.creditapplicationsystem.repository

import com.example.creditapplicationsystem.entity.credit.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository : JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit

    @Query(value = "Select * From credit Where customer_id = ?1", nativeQuery = true)
    fun findAllByCustomer(customerId: Long): List<Credit>
}
