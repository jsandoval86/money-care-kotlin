package com.moneycare.tracking.incomes.rest.response

import java.time.LocalDateTime
import java.util.UUID

data class IncomeResponse(
    var id: UUID,
    var concept: String,
    var amount: Double,
    var currency: String,
    var date: LocalDateTime,
    var tagId: String
)