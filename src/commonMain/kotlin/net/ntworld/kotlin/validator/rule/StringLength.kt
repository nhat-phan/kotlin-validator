package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*

internal class StringLength(
    operator: String,
    value: Int
) : Comparison<Int>(operator, value), Rule<String> {
    override val messageEqual: String = MESSAGE_STRING_LENGTH_EQUAL
    override val messageGreaterThan: String = MESSAGE_STRING_LENGTH_GREATER_THAN
    override val messageGreaterThanOrEqual: String = MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL
    override val messageLessThan: String = MESSAGE_STRING_LENGTH_LESS_THAN
    override val messageLessThanOrEqual: String = MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL

    override fun passes(attribute: String, value: String?): Boolean {
        return compareTo(if (null === value) 0 else value.length)
    }
}