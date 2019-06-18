package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.MessageBag
import net.ntworld.kotlin.validator.Rule
import net.ntworld.kotlin.validator.Validatable
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class ValidatorItem<T, R>(
    val property0: KProperty0<R?>?,
    val property1: KProperty1<T, R?>?,
    val list: MutableList<RuleCollectionImpl<R>>
) {
    internal fun validate(attribute: String, input: T, errors: MessageBag): Boolean {
        val value = this.getValue(attribute, input)
        return list.fold(true) { acc, rules ->
            val valid = rules.passes(attribute, value)
            if (!valid) {
                rules.buildErrorMessages(errors, attribute, value)
            }
            valid && acc
        }
    }

    internal fun buildErrorMessages(
        errors: MessageBag,
        attributeDisplayed: String,
        attribute: String,
        input: T
    ) {
        list.forEach {
            it.buildErrorMessages(
                errors, attributeDisplayed, this.getValue(attribute, input)
            )
        }
    }

    internal fun merge(item: ValidatorItem<*, *>) {
        this.list.addAll(item.list as List<RuleCollectionImpl<R>>)
    }

    private fun validateRules(rules: RuleCollectionImpl<R>, attribute: String, value: R?): Boolean {
        return rules.passes(attribute, value)
    }


    private fun getValue(attribute: String, input: T): R? {
        when (input) {
            is Validatable -> {
                if (input.containsKey(attribute)) {
                    return this.getValidationItemValue(input)
                }
                return null
            }
            else -> return this.getValidationItemValue(input)
        }
    }

    private fun getValidationItemValue(input: T): R? {
        if (null !== property0) {
            return property0.get()
        }
        return property1!!.get(input)
    }
}