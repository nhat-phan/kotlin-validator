package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_REQUIRED
import net.ntworld.kotlin.validator.PremierRule

internal class Required : PremierRule {
    override val message: String = MESSAGE_REQUIRED

    override fun passes(attribute: String, value: Any?): Boolean {
        when (value) {
            null -> return false
            is String -> return value.isNotEmpty() && value.isNotBlank()
            is Collection<*> -> return value.isNotEmpty()
            is Map<*, *> -> return value.isNotEmpty()
            is Array<*> -> return value.isNotEmpty()
            is BooleanArray -> return value.isNotEmpty()
            is ByteArray -> return value.isNotEmpty()
            is ShortArray -> return value.isNotEmpty()
            is IntArray -> return value.isNotEmpty()
            is LongArray -> return value.isNotEmpty()
            is FloatArray -> return value.isNotEmpty()
            is DoubleArray -> return value.isNotEmpty()
            is CharArray -> return value.isNotEmpty()
        }
        return true
    }
}