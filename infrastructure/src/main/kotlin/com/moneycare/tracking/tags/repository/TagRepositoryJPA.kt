package com.moneycare.tracking.tags.repository

import com.moneycare.tracking.tags.entities.TagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepositoryJPA : JpaRepository<TagEntity, String>