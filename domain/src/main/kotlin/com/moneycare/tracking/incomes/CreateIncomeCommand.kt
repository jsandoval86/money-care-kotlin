package com.moneycare.tracking.incomes

data class CreateIncomeCommand constructor(
    private var concept : String,
    private var amount : Double,
    private var tagId : String?
){

    fun getConcept(): String = concept
    fun getAmount(): Double = amount
    fun getTagId(): String? = tagId

}