package com.moneycare.tracking.incomes.rest

import com.moneycare.tracking.incomes.rest.mappers.CreateIncomeRequestMapper
import com.moneycare.tracking.incomes.rest.request.CreateIncomeRequest
import com.moneycare.tracking.incomes.CreateIncomeUseCase
import com.moneycare.tracking.incomes.Income
import com.moneycare.tracking.incomes.rest.mappers.IncomeResponseMapper
import com.moneycare.tracking.incomes.rest.response.IncomeResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(URLIncomes.URL, consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE] )
class IncomeController(
    private val createIncomeRequestMapper: CreateIncomeRequestMapper,
    private val createIncomeUseCase: CreateIncomeUseCase,
    private val incomeResponseMapper: IncomeResponseMapper
) {

    @PostMapping
    fun create(@RequestBody request : CreateIncomeRequest) : IncomeResponse {
        val command = this.createIncomeRequestMapper.mapToData(request)
        val income = this.createIncomeUseCase.create(command)
        return incomeResponseMapper.mapToIncomeResponse(income)
    }

}

