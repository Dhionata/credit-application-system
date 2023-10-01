package com.example.creditapplicationsystem.entity.credit

import com.example.creditapplicationsystem.entity.customer.Customer
import com.example.creditapplicationsystem.enummeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table
data class Credit(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private var id: Long? = null,
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) private val dayFirstIntallment: LocalDate,
    @Column(nullable = false) val numberOfInstallments: Int,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var customer: Customer = Customer(),
)
