package com.moneycare.tracking.incomes.controllers

import com.moneycare.tracking.incomes.mappers.CreateIncomeRequestMapper
import com.moneycare.tracking.incomes.models.Income
import com.moneycare.tracking.incomes.request.CreateIncomeRequest
import com.moneycare.tracking.incomes.usecase.CreateIncomeUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(URLIncomes.URL)
class IncomeController(
    private val createIncomeRequestMapper: CreateIncomeRequestMapper,
    private val createIncomeUseCase: CreateIncomeUseCase
) {

    @PostMapping()
    fun create(@RequestBody request : CreateIncomeRequest) : Income {
        val createIncomeData = this.createIncomeRequestMapper.mapToData(request)
        return this.createIncomeUseCase.create(createIncomeData)
    }

}
