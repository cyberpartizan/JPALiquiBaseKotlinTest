package com.example.test.controllers

import com.example.test.models.TestEntity
import com.example.test.repositories.DictionaryValueRepository
import com.example.test.repositories.DocumentRepository
import com.example.test.repositories.TestRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController("/test")
class TestController(
    val testRepository: TestRepository,
    val documentRepository: DocumentRepository,
    val dictionaryValueRepository: DictionaryValueRepository
) {


    @GetMapping("{uuid}")
    fun getTest(@PathVariable(required = true) uuid: UUID): ResponseEntity<TestEntity> {
        val entityOptional = testRepository.findById(uuid)
        if (entityOptional.isPresent) return ResponseEntity(entityOptional.get(), HttpStatus.OK)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping
    fun createTest(@RequestBody testEntity: TestEntity): ResponseEntity<TestEntity> {
        val createdTest = createOrUpdate(testEntity)
        return ResponseEntity(createdTest, HttpStatus.CREATED)
    }

    @PatchMapping
    fun updateTest(@RequestBody testEntity: TestEntity): ResponseEntity<TestEntity> {
        val updatedTest = createOrUpdate(testEntity)
        return ResponseEntity(updatedTest, HttpStatus.OK)
    }

    @DeleteMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTest(@PathVariable(required = true) uuid: UUID) {
        testRepository.deleteById(uuid)
    }

    private fun createOrUpdate(testEntity: TestEntity): TestEntity {
        documentRepository.save(testEntity.document!!)
        dictionaryValueRepository.save(testEntity.dictionaryValue!!)
        return testRepository.save(testEntity)
    }

}