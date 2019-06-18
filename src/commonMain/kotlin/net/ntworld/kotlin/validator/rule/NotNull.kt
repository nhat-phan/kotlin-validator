package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_NOT_NULL
import net.ntworld.kotlin.validator.Rule

internal class NotNull : Rule<Any> {
    override val message: String = MESSAGE_NOT_NULL

    override fun passes(attribute: String, value: Any?): Boolean {
        return null !== value
    }
}