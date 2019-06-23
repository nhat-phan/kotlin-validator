package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.exception.IllegalOperatorException

abstract class Comparison<T>(
    private val operator: String,
    private val value: T
) where T : Number, T : Comparable<T> {
    val message: String
        get() {
            return when (operator) {
                OPERATOR_EQUAL -> formatMessage(messageEqual, value)
                OPERATOR_GREATER_THAN -> formatMessage(messageGreaterThan, value)
                OPERATOR_GREATER_THAN_OR_EQUAL -> formatMessage(messageGreaterThanOrEqual, value)
                OPERATOR_LESS_THAN -> formatMessage(messageLessThan, value)
                OPERATOR_LESS_THAN_OR_EQUAL -> formatMessage(messageLessThanOrEqual, value)
                else -> throw IllegalOperatorException()
            }
        }

    protected abstract val messageEqual: String
    protected abstract val messageGreaterThan: String
    protected abstract val messageGreaterThanOrEqual: String
    protected abstract val messageLessThan: String
    protected abstract val messageLessThanOrEqual: String

    fun compareTo(other: T): Boolean {
        return when (operator) {
            OPERATOR_EQUAL -> other == value
            OPERATOR_GREATER_THAN -> other > value
            OPERATOR_GREATER_THAN_OR_EQUAL -> other >= value
            OPERATOR_LESS_THAN -> other < value
            OPERATOR_LESS_THAN_OR_EQUAL -> other <= value
            else -> throw IllegalOperatorException()
        }
    }

    private fun formatMessage(message: String, value: T): String {
        return message.replace("{value}", value.toString())
    }
}