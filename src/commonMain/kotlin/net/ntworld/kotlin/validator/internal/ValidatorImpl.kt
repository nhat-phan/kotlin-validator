package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.MESSAGE_NESTED_VALIDATOR
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

class ValidatorImpl<T>(block: ValidatorBuilder<T>.() -> Unit) : Rule<T>, Validator<T> {
    override val message: String = MESSAGE_NESTED_VALIDATOR

    override fun passes(attribute: String, value: T?): Boolean {
        if (null !== value) {
            return this.validate(value).isValid
        }
        return true
    }

    internal fun buildErrorMessages(errors: MessageBag, attribute: String, value: T?) {
        this.data.entries.forEach {
            it.value.buildErrorMessages(errors, "$attribute.${it.key}", it.key, value!!)
        }
    }

    private val data: MutableMap<String, ValidatorItem<in T, *>> = mutableMapOf()

    init {
        ValidatorBuilderImpl(this).apply(block)
    }

    internal fun <R> registerProperty(property: KProperty0<R?>, rules: RuleCollectionImpl<R>) {
        val key = property.name
        if (!data.containsKey(key)) {
            data[key] = ValidatorItem(property, null, mutableListOf(rules))
            return
        }

        @Suppress("UNCHECKED_CAST")
        val item = data[key] as ValidatorItem<T, R>
        item.list.add(rules)
    }

    internal fun <R> registerProperty(property: KProperty1<T, R?>, rules: RuleCollectionImpl<R>) {
        val key = property.name
        if (!data.containsKey(key)) {
            data[key] = ValidatorItem(null, property, mutableListOf(rules))
            return
        }

        @Suppress("UNCHECKED_CAST")
        val item = data[key] as ValidatorItem<T, R>
        item.list.add(rules)
    }

    override fun extend(validator: Validator<in T>): Validator<T> {
        if (validator is ValidatorImpl) {
            for (entry in validator.data.entries) {
                val key = entry.key
                val item = entry.value
                if (!this.data.containsKey(key)) {
                    this.data[key] = item
                    continue
                }

                (this.data[key] as ValidatorItem<in T, *>).merge(item)
            }
        }
        return this
    }

    override fun validate(input: T): ValidationResult {
        val errors = MessageBagImpl()
        val valid = this.data.entries.fold(true) { acc, entry ->
            entry.value.validate(entry.key, input, errors) && acc
        }

        return ValidationResultImpl(valid, errors)
    }
}
