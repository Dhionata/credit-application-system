package com.example.creditapplicationsystem.exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails> {
        val erros: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.forEach { erro: ObjectError ->
            val fieldName: String = (erro as FieldError).field
            val messageError: String? = erro.defaultMessage
            erros[fieldName] = messageError
        }
        return ResponseEntity(
            ExceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exceptiom = ex.javaClass.name,
                details = erros
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex: DataAccessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptionDetails(
                title = "Conflict! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.CONFLICT.value(),
                exceptiom = ex.javaClass.name,
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handlerValidException(ex: NoSuchElementException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ExceptionDetails(
                title = "Not found! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.NOT_FOUND.value(),
                exceptiom = ex.javaClass.name,
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }

    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(ex: BusinessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ExceptionDetails(
                title = "Not found! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.NOT_FOUND.value(),
                exceptiom = ex.javaClass.name,
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }

    @ExceptionHandler(IllegalAccessError::class)
    fun handlerValidException(ex: IllegalAccessError): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
            ExceptionDetails(
                title = "Acess denied! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.UNAUTHORIZED.value(),
                exceptiom = ex.javaClass.name,
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }

}