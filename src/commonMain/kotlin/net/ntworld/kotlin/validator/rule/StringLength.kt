package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.exception.IllegalOperatorException

internal class StringLength(
    private val operator: String,
    private val value: Int
) : Rule<String> {
    override val message: String
        get() {
            return when (operator) {
                OPERATOR_EQUAL -> fillMessage(MESSAGE_STRING_LENGTH_EQUAL, value)
                OPERATOR_GREATER_THAN -> fillMessage(MESSAGE_STRING_LENGTH_GREATER_THAN, value)
                OPERATOR_GREATER_THAN_OR_EQUAL -> fillMessage(MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL, value)
                OPERATOR_LESS_THAN -> fillMessage(MESSAGE_STRING_LENGTH_LESS_THAN, value)
                OPERATOR_LESS_THAN_OR_EQUAL -> fillMessage(MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL, value)
                else -> throw IllegalOperatorException()
            }
        }

    override fun passes(attribute: String, value: String?): Boolean {
        val length = if (null === value) 0 else value.length

        return when (operator) {
            OPERATOR_EQUAL -> length == this.value
            OPERATOR_GREATER_THAN -> length > this.value
            OPERATOR_GREATER_THAN_OR_EQUAL -> length >= this.value
            OPERATOR_LESS_THAN -> length < this.value
            OPERATOR_LESS_THAN_OR_EQUAL -> length <= this.value
            else -> throw IllegalOperatorException()
        }
    }

    private fun fillMessage(message: String, value: Int): String {
        return message.replace("{length}", value.toString())
    }
}