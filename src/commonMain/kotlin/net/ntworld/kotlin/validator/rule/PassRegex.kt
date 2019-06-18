package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_REGEX
import net.ntworld.kotlin.validator.Rule
import kotlin.text.Regex

internal class PassRegex<T : CharSequence>(private val regex: Regex) : Rule<T> {
    override val message: String = MESSAGE_REGEX

    override fun passes(attribute: String, value: T?): Boolean {
        if (value !== null) {
            return regex.matches(value)
        }
        return false
    }
}