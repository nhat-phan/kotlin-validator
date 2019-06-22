package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.exception.IllegalOperatorException
import net.ntworld.kotlin.validator.internal.RulesWithOperatorMessageFactory

class ArraySize<T>(
    private val operator: String,
    private val value: Int
) : Rule<T> {
    override val message: String = RulesWithOperatorMessageFactory.getMessage(
        RulesWithOperatorMessageFactory.Type.ArraySize,
        operator,
        value
    )

    override fun passes(attribute: String, value: T?): Boolean {
        return when (value) {
            null -> runPasses(0)
            is String -> runPasses(value.length)
            is Collection<*> -> runPasses(value.size)
            is Map<*, *> -> runPasses(value.size)
            is Array<*> -> runPasses(value.size)
            is BooleanArray -> runPasses(value.size)
            is ByteArray -> runPasses(value.size)
            is ShortArray -> runPasses(value.size)
            is IntArray -> runPasses(value.size)
            is LongArray -> runPasses(value.size)
            is FloatArray -> runPasses(value.size)
            is DoubleArray -> runPasses(value.size)
            is CharArray -> runPasses(value.size)
            else -> throw IllegalOperatorException()
        }
    }

    private fun runPasses(size: Int): Boolean {
        return when (operator) {
            OPERATOR_EQUAL -> size == this.value
            OPERATOR_GREATER_THAN -> size > this.value
            OPERATOR_GREATER_THAN_OR_EQUAL -> size >= this.value
            OPERATOR_LESS_THAN -> size < this.value
            OPERATOR_LESS_THAN_OR_EQUAL -> size <= this.value
            else -> false
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