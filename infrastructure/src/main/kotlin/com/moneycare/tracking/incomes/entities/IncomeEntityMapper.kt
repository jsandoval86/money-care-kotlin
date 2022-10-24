package com.moneycare.tracking.incomes.entities

import com.moneycare.tracking.incomes.Income
import com.moneycare.tracking.shared.valueobjects.Concept
import com.moneycare.tracking.shared.valueobjects.Money
import org.springframework.stereotype.Component

@Component
class IncomeEntityMapper {

    fun mapToEntity(income: Income) : IncomeEntity {
        return IncomeEntity(income.id, income.concept.description, income.amount.amount, income.date)
    }

    fun mapToDomainObject(incomeEntity: IncomeEntity): Income {
        return Income.of(
            incomeEntity.id,
            Concept(incomeEntity.concept),
            Money(incomeEntity.amount),
            incomeEntity.date,
            incomeEntity.tag.id
        )
    }

}