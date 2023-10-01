package com.example.creditapplicationsystem.service

import com.example.creditapplicationsystem.entity.Address
import com.example.creditapplicationsystem.entity.Customer
import com.example.creditapplicationsystem.exception.BusinessException
import com.example.creditapplicationsystem.repository.CustomerRepository
import com.example.creditapplicationsystem.service.implement.CustomerService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.function.Executable
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {
    @MockK
    lateinit var customerRepository: CustomerRepository

    @InjectMockKs
    lateinit var customerService: CustomerService
    private val fakeCustomer = buildCustomer()

    @Test
    fun `should create customer`() {
        //given
        every { customerRepository.save(any()) } returns fakeCustomer
        //when
        val actual = customerService.save(fakeCustomer)
        //then
        Assertions.assertNotNull(actual)
        Assertions.assertEquals(actual, fakeCustomer)
        verify(exactly = 1) { customerRepository.save(fakeCustomer) }
    }

    @Test
    fun `should find customer by id`() {
        //given
        every { customerRepository.findById(fakeCustomer.id) } returns Optional.of(fakeCustomer)
        //when
        val actual = customerService.findByID(fakeCustomer.id)
        //then
        Assertions.assertNotNull(actual)
        Assertions.assertEquals(actual, fakeCustomer)
        Assertions.assertEquals(actual::class, Customer::class)
        verify(exactly = 1) { customerRepository.findById(fakeCustomer.id) }
    }

    @Test
    fun `should't find customer by in and throw BusinessException`() {
        //given
        every { customerRepository.findById(fakeCustomer.id) } returns Optional.empty()
        //when
        //then
        Assertions.assertThrowsExactly(
            BusinessException::class.java, (Executable { customerService.findByID(fakeCustomer.id) })
        ) { "Id ${fakeCustomer.id} not found" }
        verify(exactly = 1) { customerRepository.findById(fakeCustomer.id) }
    }

    @Test
    fun `should delete customer by id`() {
        //given
        every { customerRepository.findById(fakeCustomer.id) } returns Optional.of(fakeCustomer)
        every { customerRepository.delete(fakeCustomer) } just runs
        //when
        customerService.delete(fakeCustomer.id)

        //then
        verify(exactly = 1) { customerRepository.findById(fakeCustomer.id) }
        verify(exactly = 1) { customerRepository.delete(fakeCustomer) }
    }

    private fun buildCustomer(
        firstName: String = "Dhionatã",
        lastName: String = "Carlos Vieira",
        cpf: String = "28475934625",
        email: String = "test@gmail.com",
        password: String = "123456",
        zipCode: String = "09876",
        street: String = "Rua do Dhionatã",
        income: BigDecimal = BigDecimal(1000.0),
        id: Long = 1L
    ) = Customer(
        firstName = firstName, lastName = lastName, cpf = cpf, email = email, password = password, address = Address(
            zipCode = zipCode, street = street
        ), income = income, id = id
    )
}
