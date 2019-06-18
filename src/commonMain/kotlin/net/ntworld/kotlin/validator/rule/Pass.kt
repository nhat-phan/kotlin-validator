package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_PASS
import net.ntworld.kotlin.validator.Rule

internal class Pass<T>(private val fn: (T?) -> Boolean) : Rule<T> {
    override val message: String = MESSAGE_PASS

    override fun passes(attribute: String, value: T?): Boolean {
        return fn(value)
    }
}