package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.exception.IllegalOperatorException

internal class NumberComparison<T>(
    private val operator: String,
    private val value: T
) : Rule<T> where T : Number, T : Comparable<T> {
    override val message: String
        get() {
            return when (operator) {
                OPERATOR_EQUAL -> fillMessage(MESSAGE_NUMBER_EQUAL, value)
                OPERATOR_GREATER_THAN -> fillMessage(MESSAGE_NUMBER_GREATER_THAN, value)
                OPERATOR_GREATER_THAN_OR_EQUAL -> fillMessage(MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL, value)
                OPERATOR_LESS_THAN -> fillMessage(MESSAGE_NUMBER_LESS_THAN, value)
                OPERATOR_LESS_THAN_OR_EQUAL -> fillMessage(MESSAGE_NUMBER_LESS_THAN_OR_EQUAL, value)
                else -> throw IllegalOperatorException()
            }
        }

    override fun passes(attribute: String, value: T?): Boolean {
        if (null !== value) {
            return when (operator) {
                OPERATOR_EQUAL -> value == this.value
                OPERATOR_GREATER_THAN -> value > this.value
                OPERATOR_GREATER_THAN_OR_EQUAL -> value >= this.value
                OPERATOR_LESS_THAN -> value < this.value
                OPERATOR_LESS_THAN_OR_EQUAL -> value <= this.value
                else -> throw IllegalOperatorException()
            }
        }
        return false
    }

    private fun fillMessage(message: String, value: T): String {
        return message.replace("{value}", value.toString())
    }
}