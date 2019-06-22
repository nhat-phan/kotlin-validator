package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.exception.IllegalOperatorException
import net.ntworld.kotlin.validator.internal.RulesWithOperatorMessageFactory

internal class StringLength(
    private val operator: String,
    private val value: Int
) : Rule<String> {
    override val message: String = RulesWithOperatorMessageFactory.getMessage(
        RulesWithOperatorMessageFactory.Type.StringLength,
        operator,
        value
    )

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
}