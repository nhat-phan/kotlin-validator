package net.ntworld.kotlin.validator.rule

import kotlin.test.Test
import kotlin.test.assertEquals

class NotNullTest {
    data class TestData(
        val value: String?,
        val valid: Boolean
    )

    @Test
    fun testPasses() {
        val dataset = listOf(
            TestData(value = null, valid = false),
            TestData(value = "", valid = true),
            TestData(value = " ", valid = true),
            TestData(value = "a ", valid = true),
            TestData(value = "  a", valid = true),
            TestData(value = "123", valid = true)
        )
        val rule = NotNull()
        for (data in dataset) {
            assertEquals(data.valid, rule.passes("test", data.value), data.toString())
        }
    }
}