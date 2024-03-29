package com.example.creditapplicationsystem.service.implement

import com.example.creditapplicationsystem.entity.credit.Credit
import com.example.creditapplicationsystem.repository.CreditRepository
import com.example.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository, private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findByID(credit.customer.id)
        }
        return creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerID: Long): List<Credit> = creditRepository.findAllByCustomer(customerID)

    override fun findByCreditCode(customerID: Long, creditCode: UUID): Credit {
        val credit: Credit = creditRepository.findByCreditCode(creditCode)
        return if (credit.customer.id == customerID) credit else throw IllegalAccessError(
            "You do not have access to this information, contact admin"
        )
    }
}
