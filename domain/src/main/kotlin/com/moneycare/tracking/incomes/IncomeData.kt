package com.moneycare.tracking.incomes

import com.moneycare.tracking.shared.valueobjects.Concept
import com.moneycare.tracking.shared.valueobjects.Money
import java.time.LocalDateTime
import java.util.UUID

data class IncomeData (
    var id : UUID,
    var concept : Concept,
    var amount: Money,
    var date : LocalDateTime,
    var tagId : String
)