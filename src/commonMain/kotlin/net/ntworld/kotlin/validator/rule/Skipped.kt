package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_SKIPPED
import net.ntworld.kotlin.validator.PremierRule

internal class Skipped : PremierRule {
    override val message: String = MESSAGE_SKIPPED

    override fun passes(attribute: String, value: Any?): Boolean {
        return true
    }
}