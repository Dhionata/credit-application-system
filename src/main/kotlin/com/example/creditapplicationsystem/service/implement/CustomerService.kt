package com.example.creditapplicationsystem.service.implement

import com.example.creditapplicationsystem.entity.customer.Customer
import com.example.creditapplicationsystem.exception.BusinessException
import com.example.creditapplicationsystem.repository.CustomerRepository
import com.example.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {
    override fun save(customer: Customer): Customer = customerRepository.save(customer)

    override fun findByID(id: Long): Customer = customerRepository.findById(id).orElseThrow {
        throw BusinessException("Id $id not found")
    }

    override fun delete(id: Long) {
        customerRepository.delete(findByID(id))
    }
}
