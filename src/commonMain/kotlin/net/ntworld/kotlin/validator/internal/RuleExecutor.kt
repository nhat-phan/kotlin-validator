package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.MessageBag
import net.ntworld.kotlin.validator.Rule
import net.ntworld.kotlin.validator.Validator

internal class RuleExecutor<T>(private val rule: Rule<T>) : Rule<T> {
    internal var isValid: Boolean = false

    override val message: String = rule.message

    override fun passes(attribute: String, value: T?): Boolean {
        isValid = rule.passes(attribute, value)
        return isValid
    }

    fun buildErrorMessages(errors: MessageBag, attribute: String, value: T?) {
        if (this.isValid) {
            return
        }

        if (rule is ValidatorImpl) {
            rule.buildErrorMessages(errors, attribute, value)
        }

        addMessageToBagIfNeeded(errors, this.message, attribute, value)
    }

    companion object {
        internal fun formatMessage(message: String, attribute: String, value: Any?): String {
            return message
                .replace(":attribute", attribute)
                .replace("[attribute]", attribute)
                .replace("{attribute}", attribute)
                .replace(":value", value.toString())
                .replace("[value]", value.toString())
                .replace("{value}", value.toString())
        }

        fun addMessageToBagIfNeeded(bag: MessageBag, message: String, attribute: String, value: Any?) {
            val formattedMessage = formatMessage(message, attribute, value)
            if (formattedMessage.isNotEmpty()) {
                bag.add(attribute, formattedMessage)
            }
        }
    }
}