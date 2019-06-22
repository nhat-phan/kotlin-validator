package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.exception.IllegalOperatorException
import net.ntworld.kotlin.validator.internal.RulesWithOperatorMessageFactory

internal class NumberComparison<T>(
    private val operator: String,
    private val value: T
) : Rule<T> where T : Number, T : Comparable<T> {
    override val message: String = RulesWithOperatorMessageFactory.getMessage(
        RulesWithOperatorMessageFactory.Type.StringLength,
        operator,
        value
    )

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
}