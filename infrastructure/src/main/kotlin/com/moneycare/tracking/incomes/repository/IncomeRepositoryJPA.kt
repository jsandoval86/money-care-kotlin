package com.moneycare.tracking.incomes.repository

import com.moneycare.tracking.incomes.entities.IncomeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface IncomeRepositoryJPA : JpaRepository<IncomeEntity, UUID>