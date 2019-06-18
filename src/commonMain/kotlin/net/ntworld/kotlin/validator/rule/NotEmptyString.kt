package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_NOT_EMPTY_STRING
import net.ntworld.kotlin.validator.Rule

internal class NotEmptyString : Rule<String> {
    override val message: String = MESSAGE_NOT_EMPTY_STRING

    override fun passes(attribute: String, value: String?): Boolean {
        return !value.isNullOrBlank()
    }
}