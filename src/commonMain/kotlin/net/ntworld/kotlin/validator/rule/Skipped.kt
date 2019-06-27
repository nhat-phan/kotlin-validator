package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.AlwaysPremierRule
import net.ntworld.kotlin.validator.WhetherPremierRule
import net.ntworld.kotlin.validator.MESSAGE_SKIPPED

internal class Skipped : AlwaysPremierRule, WhetherPremierRule {
    override val message: String = MESSAGE_SKIPPED

    override fun passes(attribute: String, value: Any?): Boolean {
        return true
    }
}