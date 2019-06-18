package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_OPTIONAL
import net.ntworld.kotlin.validator.Rule

internal class Optional : Rule<Any> {
    override val message: String = MESSAGE_OPTIONAL

    override fun passes(attribute: String, value: Any?): Boolean {
        return true
    }
}