package com.moneycare.tracking.incomes.controllers

import com.moneycare.tracking.incomes.controllers.mappers.CreateIncomeRequestMapper
import com.moneycare.tracking.incomes.Income
import com.moneycare.tracking.incomes.request.CreateIncomeRequest
import com.moneycare.tracking.incomes.IncomeCreator
import com.moneycare.tracking.incomes.IncomeData
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(URLIncomes.URL)
class IncomeController(
    private val createIncomeRequestMapper: CreateIncomeRequestMapper,
    private val incomeCreator: IncomeCreator
) {

    @PostMapping()
    fun create(@RequestBody request : CreateIncomeRequest) : IncomeData {
        val createIncomeData = this.createIncomeRequestMapper.mapToData(request)
        return this.incomeCreator.create(createIncomeData)
    }

}
