package com.example.creditapplicationsystem.controller

import com.example.creditapplicationsystem.dto.CustomerDto
import com.example.creditapplicationsystem.dto.CustomerUpdateDto
import com.example.creditapplicationsystem.dto.CustomerView
import com.example.creditapplicationsystem.service.implement.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val customer = customerService.findByID(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long, @RequestBody customerUpdateDto:
        CustomerUpdateDto
    ):
            CustomerView {
        val customer = customerService.findByID(id)
        val customerToUpdate = customerUpdateDto.toEntity(customer)
        val customerUpdated = customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }
}