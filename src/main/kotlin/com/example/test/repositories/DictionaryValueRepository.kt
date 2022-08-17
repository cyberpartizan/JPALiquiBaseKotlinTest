package com.example.test.repositories

import com.example.test.models.DictionaryValue
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DictionaryValueRepository : JpaRepository<DictionaryValue, UUID> {
}