package net.ntworld.kotlin.validator

interface MessageBag {
    fun clear(): MessageBag

    fun keys(): Set<String>

    fun has(key: String): Boolean

    fun get(key: String): Set<String>

    fun add(key: String, message: String): MessageBag

    fun remove(key: String, message: String): MessageBag

    fun toMap(): Map<String, Collection<String>>

    fun isEmpty(): Boolean

    fun isNotEmpty(): Boolean

    operator fun plus(bag: MessageBag): MessageBag

    operator fun plusAssign(bag: MessageBag)
}