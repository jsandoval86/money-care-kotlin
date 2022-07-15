package com.moneycare.tracking.incomes.repository

import com.moneycare.shared.exceptions.TechnicalException
import com.moneycare.tracking.incomes.Income
import com.moneycare.tracking.incomes.IncomeRepository
import com.moneycare.tracking.incomes.entities.IncomeEntityMapper
import com.moneycare.tracking.tags.repository.TagRepositoryJPA
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open class IncomeRepositoryBD(
    private val incomeRepositoryJPA: IncomeRepositoryJPA,
    private val incomeEntityMapper: IncomeEntityMapper,
    private val tagRepositoryJPA: TagRepositoryJPA
): IncomeRepository{

    override fun save(income: Income) {
        val incomeEntity = incomeEntityMapper.mapToEntity(income)

        incomeEntity.tag = tagRepositoryJPA.findById(income.tagId)
            .orElseThrow{ TechnicalException("El tag con id ${income.tagId} no existe") }

        incomeRepositoryJPA.save(incomeEntity)
    }

    override fun findById(id: UUID): Optional<Income> {
        return incomeRepositoryJPA.findById(id)
            .map { incomeEntity ->
               Optional.of(incomeEntityMapper.mapToDomainObject(incomeEntity))
            }.orElseGet {
                Optional.empty()
            }
    }

}