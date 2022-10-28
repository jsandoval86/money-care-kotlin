package com.moneycare.setting.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.moneycare.shared.helpers.EnumHelperError
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConversionException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.validation.ConstraintViolationException

@ControllerAdvice
class HandlerExceptions{

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    private val log = LoggerFactory.getLogger(javaClass)


    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(ex: ConstraintViolationException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(status = HttpStatus.BAD_REQUEST, error = "fields errors")
        error.addValidationErrors(ex.constraintViolations)
        log.debug(objectMapper.writeValueAsString(error))
        return ResponseEntity(error, error.status)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(status = HttpStatus.INTERNAL_SERVER_ERROR, error = ex.message)
        return ResponseEntity(error, error.status)
    }

    @ExceptionHandler(HttpMessageConversionException::class)
    fun handleMessageNotReadableException(e: HttpMessageConversionException): ResponseEntity<ErrorResponse> {
        val cause = e.cause
        val error: ErrorResponse = if (cause is InvalidFormatException && cause.targetType.isEnum) {
            ErrorResponse(HttpStatus.BAD_REQUEST, EnumHelperError.getError(cause.targetType.name))
        } else{
            ErrorResponse(HttpStatus.BAD_REQUEST, "error" )
        }

        return ResponseEntity(error, error.status)
    }

}