package com.example.test.repositories

import com.example.test.models.TestEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
public interface TestRepository : JpaRepository<TestEntity, UUID> {

}