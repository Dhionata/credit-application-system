package com.example.creditapplicationsystem.controller

import com.example.creditapplicationsystem.dto.CreditDto
import com.example.creditapplicationsystem.entity.credit.CreditView
import com.example.creditapplicationsystem.entity.credit.CreditViewList
import com.example.creditapplicationsystem.service.implement.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(private val creditService: CreditService) {

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
        val savedCredit = creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(
            "Credit ${savedCredit.creditCode} - Customer ${savedCredit.customer.firstName} saved!"
        )
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long):
            ResponseEntity<List<CreditViewList>> {
        val creditViewList = creditService.findAllByCustomer(customerId).stream().map { credit ->
            CreditViewList(credit)
        }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long, @PathVariable creditCode: UUID):
            ResponseEntity<CreditView> {
        val credit = creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }

}
