package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.exception.IllegalTypeException

class ArraySize<T>(
    operator: String,
    value: Int
) : Comparison<Int>(operator, value), Rule<T> {
    override val messageEqual: String = MESSAGE_ARRAY_SIZE_EQUAL
    override val messageGreaterThan: String = MESSAGE_ARRAY_SIZE_GREATER_THAN
    override val messageGreaterThanOrEqual: String = MESSAGE_ARRAY_SIZE_GREATER_THAN_OR_EQUAL
    override val messageLessThan: String = MESSAGE_ARRAY_SIZE_LESS_THAN
    override val messageLessThanOrEqual: String = MESSAGE_ARRAY_SIZE_LESS_THAN_OR_EQUAL

    override fun passes(attribute: String, value: T?): Boolean {
        return when (value) {
            null -> compareTo(0)
            is String -> compareTo(value.length)
            is Collection<*> -> compareTo(value.size)
            is Map<*, *> -> compareTo(value.size)
            is Array<*> -> compareTo(value.size)
            is BooleanArray -> compareTo(value.size)
            is ByteArray -> compareTo(value.size)
            is ShortArray -> compareTo(value.size)
            is IntArray -> compareTo(value.size)
            is LongArray -> compareTo(value.size)
            is FloatArray -> compareTo(value.size)
            is DoubleArray -> compareTo(value.size)
            is CharArray -> compareTo(value.size)
            else -> throw IllegalTypeException(value.toString(), this)
        }
    }

    companion object {
        inline fun <reified T> eq(value: Int): Rule<T> {
            return ArraySize(OPERATOR_EQUAL, value)
        }

        inline fun <reified T> gt(value: Int): Rule<T> {
            return ArraySize(OPERATOR_GREATER_THAN, value)
        }

        inline fun <reified T> gte(value: Int): Rule<T> {
            return ArraySize(OPERATOR_GREATER_THAN_OR_EQUAL, value)
        }

        inline fun <reified T> lt(value: Int): Rule<T> {
            return ArraySize(OPERATOR_LESS_THAN, value)
        }

        inline fun <reified T> lte(value: Int): Rule<T> {
            return ArraySize(OPERATOR_LESS_THAN_OR_EQUAL, value)
        }
    }
}