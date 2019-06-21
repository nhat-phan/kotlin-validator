package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*
import kotlin.test.Test
import kotlin.test.assertEquals

class StringLengthTest {
    internal data class TestData(
        val operator: String,
        val params: Int,
        val input: String?,
        val valid: Boolean
    )

    private val dataset = listOf(
        TestData(operator = OPERATOR_EQUAL, params = 0, input = null, valid = true),
        TestData(operator = OPERATOR_EQUAL, params = 0, input = "", valid = true),
        TestData(operator = OPERATOR_EQUAL, params = 0, input = " ", valid = false),
        TestData(operator = OPERATOR_EQUAL, params = 0, input = " a ", valid = false),
        TestData(operator = OPERATOR_EQUAL, params = 0, input = "abcdef", valid = false),
        TestData(operator = OPERATOR_EQUAL, params = 3, input = null, valid = false),
        TestData(operator = OPERATOR_EQUAL, params = 3, input = "", valid = false),
        TestData(operator = OPERATOR_EQUAL, params = 3, input = " ", valid = false),
        TestData(operator = OPERATOR_EQUAL, params = 3, input = " a ", valid = true),
        TestData(operator = OPERATOR_EQUAL, params = 3, input = "abcdef", valid = false),

        TestData(operator = OPERATOR_LESS_THAN, params = 0, input = null, valid = false),
        TestData(operator = OPERATOR_LESS_THAN, params = 0, input = "", valid = false),
        TestData(operator = OPERATOR_LESS_THAN, params = 0, input = " ", valid = false),
        TestData(operator = OPERATOR_LESS_THAN, params = 0, input = " a ", valid = false),
        TestData(operator = OPERATOR_LESS_THAN, params = 0, input = "abcdef", valid = false),
        TestData(operator = OPERATOR_LESS_THAN, params = 3, input = null, valid = true),
        TestData(operator = OPERATOR_LESS_THAN, params = 3, input = "", valid = true),
        TestData(operator = OPERATOR_LESS_THAN, params = 3, input = " ", valid = true),
        TestData(operator = OPERATOR_LESS_THAN, params = 3, input = " a ", valid = false),
        TestData(operator = OPERATOR_LESS_THAN, params = 3, input = "abcdef", valid = false),

        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 0, input = null, valid = true),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 0, input = "", valid = true),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 0, input = " ", valid = false),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 0, input = " a ", valid = false),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 0, input = "abcdef", valid = false),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 3, input = null, valid = true),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 3, input = "", valid = true),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 3, input = " ", valid = true),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 3, input = " a ", valid = true),
        TestData(operator = OPERATOR_LESS_THAN_OR_EQUAL, params = 3, input = "abcdef", valid = false),

        TestData(operator = OPERATOR_GREATER_THAN, params = 0, input = null, valid = false),
        TestData(operator = OPERATOR_GREATER_THAN, params = 0, input = "", valid = false),
        TestData(operator = OPERATOR_GREATER_THAN, params = 0, input = " ", valid = true),
        TestData(operator = OPERATOR_GREATER_THAN, params = 0, input = " a ", valid = true),
        TestData(operator = OPERATOR_GREATER_THAN, params = 0, input = "abcdef", valid = true),
        TestData(operator = OPERATOR_GREATER_THAN, params = 3, input = null, valid = false),
        TestData(operator = OPERATOR_GREATER_THAN, params = 3, input = "", valid = false),
        TestData(operator = OPERATOR_GREATER_THAN, params = 3, input = " ", valid = false),
        TestData(operator = OPERATOR_GREATER_THAN, params = 3, input = " a ", valid = false),
        TestData(operator = OPERATOR_GREATER_THAN, params = 3, input = "abcdef", valid = true),

        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 0, input = null, valid = true),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 0, input = "", valid = true),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 0, input = " ", valid = true),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 0, input = " a ", valid = true),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 0, input = "abcdef", valid = true),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 3, input = null, valid = false),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 3, input = "", valid = false),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 3, input = " ", valid = false),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 3, input = " a ", valid = true),
        TestData(operator = OPERATOR_GREATER_THAN_OR_EQUAL, params = 3, input = "abcdef", valid = true)
    )

    @Test
    fun testPasses() {
        for (item in dataset) {
            val rule = StringLength(item.operator, item.params)
            assertEquals(item.valid, rule.passes("test", item.input), "Failed with case '$item'")
        }
    }
}