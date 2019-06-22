package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.exception.IllegalOperatorException
import net.ntworld.kotlin.validator.internal.RulesWithOperatorMessageFactory.Type.*

internal object RulesWithOperatorMessageFactory {
    internal enum class Type {
        ArraySize,
        StringLength,
        Number
    }

    fun getMessage(type: Type, operator: String, value: Any): String {
        return when (operator) {
            OPERATOR_EQUAL -> messageEq(type, value)
            OPERATOR_GREATER_THAN -> messageGt(type, value)
            OPERATOR_GREATER_THAN_OR_EQUAL -> messageGte(type, value)
            OPERATOR_LESS_THAN -> messageLt(type, value)
            OPERATOR_LESS_THAN_OR_EQUAL -> messageLte(type, value)
            else -> throw IllegalOperatorException()
        }
    }

    private fun messageEq(type: Type, value: Any): String {
        return when (type) {
            ArraySize -> fillMessage(MESSAGE_ARRAY_SIZE_EQUAL, "{size}", value)
            StringLength -> fillMessage(MESSAGE_STRING_LENGTH_EQUAL, "{length}", value)
            Number -> fillMessage(MESSAGE_NUMBER_EQUAL, "{value}", value)
        }
    }

    private fun messageGt(type: Type, value: Any): String {
        return when (type) {
            ArraySize -> fillMessage(MESSAGE_ARRAY_SIZE_GREATER_THAN, "{size}", value)
            StringLength -> fillMessage(MESSAGE_STRING_LENGTH_GREATER_THAN, "{length}", value)
            Number -> fillMessage(MESSAGE_NUMBER_GREATER_THAN, "{value}", value)
        }
    }

    private fun messageGte(type: Type, value: Any): String {
        return when (type) {
            ArraySize -> fillMessage(MESSAGE_ARRAY_SIZE_GREATER_THAN_OR_EQUAL, "{size}", value)
            StringLength -> fillMessage(MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL, "{length}", value)
            Number -> fillMessage(MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL, "{value}", value)
        }
    }

    private fun messageLt(type: Type, value: Any): String {
        return when (type) {
            ArraySize -> fillMessage(MESSAGE_ARRAY_SIZE_LESS_THAN, "{size}", value)
            StringLength -> fillMessage(MESSAGE_STRING_LENGTH_LESS_THAN, "{length}", value)
            Number -> fillMessage(MESSAGE_NUMBER_LESS_THAN, "{value}", value)
        }
    }

    private fun messageLte(type: Type, value: Any): String {
        return when (type) {
            ArraySize -> fillMessage(MESSAGE_ARRAY_SIZE_LESS_THAN_OR_EQUAL, "{size}", value)
            StringLength -> fillMessage(MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL, "{length}", value)
            Number -> fillMessage(MESSAGE_NUMBER_LESS_THAN_OR_EQUAL, "{value}", value)
        }
    }

    private fun fillMessage(message: String, placeholder: String, value: Any): String {
        return message.replace(placeholder, value.toString())
    }
}