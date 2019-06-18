package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_EACH
import net.ntworld.kotlin.validator.Rule

internal class Each<E, T : Collection<E?>>(private val rule: Rule<E>) : Rule<T> {
    override val message: String = MESSAGE_EACH

    override fun passes(attribute: String, value: T?): Boolean {
        if (null !== value) {
            return value.fold(true) { acc, item ->
                return acc && rule.passes(attribute, item)
            }
        }
        return true
    }

}