package com.moneycare.tracking.incomes.controllers

import com.moneycare.tracking.incomes.handlers.commands.CreateIncomeCommandHandler
import com.moneycare.tracking.incomes.mappers.CreateIncomeRequestMapper
import com.moneycare.tracking.incomes.request.CreateIncomeRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/incomes")
class IncomeController(
    private val createIncomeCommandHandler: CreateIncomeCommandHandler,
    private val createIncomeRequestMapper: CreateIncomeRequestMapper
) {

    @PostMapping()
    fun create(@RequestBody request : CreateIncomeRequest){
        val command = this.createIncomeRequestMapper.mapToCommand(request)
        this.createIncomeCommandHandler.handle(command)
    }

}
