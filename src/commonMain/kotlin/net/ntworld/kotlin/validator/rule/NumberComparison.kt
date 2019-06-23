package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*

internal class NumberComparison<T>(
    operator: String,
    value: T
) : Comparison<T>(operator, value), Rule<T> where T : Number, T : Comparable<T> {
    override val messageEqual: String = MESSAGE_NUMBER_EQUAL
    override val messageGreaterThan: String = MESSAGE_NUMBER_GREATER_THAN
    override val messageGreaterThanOrEqual: String = MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL
    override val messageLessThan: String = MESSAGE_NUMBER_LESS_THAN
    override val messageLessThanOrEqual: String = MESSAGE_NUMBER_LESS_THAN_OR_EQUAL

    override fun passes(attribute: String, value: T?): Boolean {
        return if (null === value) false else compareTo(value)
    }
}