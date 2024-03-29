package com.example.creditapplicationsystem.entity.customer

import com.example.creditapplicationsystem.entity.Address
import com.example.creditapplicationsystem.entity.credit.Credit
import jakarta.persistence.*
import java.math.BigDecimal
import kotlin.random.Random

@Entity
@Table
data class Customer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = Random.nextLong(),
    @Column(nullable = false) var firstName: String = "",
    @Column(nullable = false) var lastName: String = "",
    @Column(nullable = false, unique = true) var cpf: String = "",
    @Column(nullable = false, unique = true) var email: String = "",
    @Column(nullable = false) var income: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) private var password: String = "",
    @Column(nullable = false) @Embedded var address: Address = Address(),

    @Column(nullable = false) @OneToMany(
        fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE, CascadeType.PERSIST], mappedBy = "customer"
    ) var credits: List<Credit> = mutableListOf(),
)
