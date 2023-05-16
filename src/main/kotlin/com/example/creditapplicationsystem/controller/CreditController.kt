package com.example.creditapplicationsystem.controller

import com.example.creditapplicationsystem.dto.*
import com.example.creditapplicationsystem.service.implement.CreditService
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/customers")
class CreditController(private val creditService: CreditService) {

    @PostMapping
    fun saveCustomer(@RequestBody creditDto: CreditDto): String {
        val savedCredit = creditService.save(creditDto.toEntity())
        return "Credit ${savedCredit.creditCode} - Customer ${savedCredit.customer?.firstName} saved!"
    }

    @GetMapping("/{id}")
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): List<CreditViewList> {
        return creditService.findAllByCustomer(customerId).stream().map { credit ->
            CreditViewList(credit)
        }.collect(Collectors.toList())

    }

    @GetMapping
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long, @PathVariable creditCode: UUID):
            CreditView {
        val credit = creditService.findByCreditCode(customerId, creditCode)
        return CreditView(credit)
    }
}