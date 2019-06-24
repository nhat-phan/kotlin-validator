package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_NOT_NULL
import net.ntworld.kotlin.validator.validator
import kotlin.test.Test
import kotlin.test.assertEquals

class NotNullTest {
    data class TestData(
        val value: String?,
        val valid: Boolean
    )

    private val dataset = listOf(
        TestData(value = null, valid = false),
        TestData(value = "", valid = true),
        TestData(value = " ", valid = true),
        TestData(value = "a ", valid = true),
        TestData(value = "  a", valid = true),
        TestData(value = "123", valid = true)
    )

    @Test
    fun testPasses() {
        val rule = NotNull()
        for (data in dataset) {
            assertEquals(data.valid, rule.passes("test", data.value), data.toString())
        }
    }

    @Test
    fun testIntegration() {
        data class Data(val value: Any?)

        val validator = validator<Data> {
            Data::value { rule = notNull }
        }
        for (data in dataset) {
            val result = validator.validate(Data(data.value))
            assertEquals(data.valid, result.isValid)
            if (!data.valid) {
                assertEquals(
                    setOf(MESSAGE_NOT_NULL.replace(":attribute", "value")),
                    result.errors.get("value")
                )
            }
        }
    }
}