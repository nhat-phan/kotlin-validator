package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.MessageBag
import kotlin.test.*

class MessageBagImplTest {
    private fun makeMessageBag(): MessageBag {
        return MessageBagImpl()
    }

    @Test
    fun testClear() {
        val bag = this.makeMessageBag()
        bag.add("a", "1")
        bag.add("b", "2")
        bag.add("c", "3")
        assertEquals(3, bag.keys().size)
        assertSame(bag, bag.clear())
        assertEquals(0, bag.keys().size)
    }

    @Test
    fun testKeys() {
        val bag = this.makeMessageBag()
        bag.add("a", "1")
        bag.add("b", "2")
        bag.add("c", "3")
        assertEquals(setOf("a", "b", "c"), bag.keys())
    }

    @Test
    fun testHas() {
        val bag = this.makeMessageBag()
        bag.add("a", "1")
        bag.add("b", "2")
        assertTrue(bag.has("a"));
        assertTrue(bag.has("b"));
        assertFalse(bag.has("c"));
        assertFalse(bag.has("not-found"));
    }

    @Test
    fun testGet() {
        val bag = this.makeMessageBag()
        assertEquals(setOf(), bag.get("test"))
        bag.add("test", "any")
        assertEquals(setOf("any"), bag.get("test"))
    }

    @Test
    fun testAdd() {
        val bag = this.makeMessageBag()
        assertEquals(0, bag.get("test").size)
        assertEquals(0, bag.keys().size)

        assertSame(bag, bag.add("test", "required"))
        assertEquals(1, bag.get("test").size)
        assertEquals(1, bag.keys().size)

        bag.add("test", "not-empty")
        assertEquals(2, bag.get("test").size)
        assertEquals(1, bag.keys().size)

        bag.add("new-key", "required")
        assertEquals(1, bag.get("new-key").size)
        assertEquals(2, bag.keys().size)

        bag.add("new-key", "required")
        assertEquals(1, bag.get("new-key").size)
        assertEquals(2, bag.keys().size)

        assertEquals(setOf("required", "not-empty"), bag.get("test"))
        assertEquals(setOf("required"), bag.get("new-key"))
    }

    @Test
    fun testRemove() {
        val bag = this.makeMessageBag()
        assertEquals(0, bag.get("a").size)
        assertTrue(bag.isEmpty())

        assertSame(bag, bag.remove("test", "required"))

        bag.add("test", "required").add("test", "not-empty")
        assertEquals(2, bag.get("test").size)
        assertTrue(bag.isNotEmpty())
        assertEquals(setOf("required", "not-empty"), bag.get("test"))

        bag.remove("test", "not-empty")
        assertEquals(1, bag.get("test").size)
        assertTrue(bag.isNotEmpty())
        assertEquals(setOf("required"), bag.get("test"))

        bag.remove("test", "required")
        assertEquals(setOf(), bag.get("test"))
        assertEquals(0, bag.get("test").size)
        assertTrue(bag.isEmpty())

        bag.add("a", "required")
        assertEquals(1, bag.get("a").size)
        assertTrue(bag.isNotEmpty())

        bag.remove("a", "empty")
        assertEquals(1, bag.get("a").size)
        assertTrue(bag.isNotEmpty())

        bag.remove("a", "required")
        assertEquals(0, bag.get("a").size)
        assertTrue(bag.isEmpty())
    }

    @Test
    fun testToMap() {
        val bag = this.makeMessageBag()
        bag.add("a", "a1")
        bag.add("a", "a2")
        bag.add("b", "b1")
        assertNotSame(bag.toMap(), bag.toMap())
        assertEquals(
            mapOf("a" to setOf("a1", "a2"), "b" to setOf("b1")),
            bag.toMap()
        )
    }

    @Test
    fun testIsEmpty() {
        val bag = this.makeMessageBag()
        assertTrue(bag.isEmpty())

        bag.add("a", "test")
        assertFalse(bag.isEmpty())

        bag.remove("a", "another key")
        assertFalse(bag.isEmpty())

        bag.remove("a", "test")
        assertTrue(bag.isEmpty())
    }

    @Test
    fun testIsNotEmpty() {
        val bag = this.makeMessageBag()
        assertFalse(bag.isNotEmpty())

        bag.add("a", "test")
        assertTrue(bag.isNotEmpty())

        bag.remove("a", "another key")
        assertTrue(bag.isNotEmpty())

        bag.remove("a", "test")
        assertFalse(bag.isNotEmpty())
    }

    @Test
    fun testOperatorPlus() {
        val one = this.makeMessageBag()
        val two = this.makeMessageBag()

        one.add("a", "a1")
        one.add("a", "a2")
        two.add("a", "a2")
        two.add("a", "a3")
        two.add("b", "b1")

        val result = one + two
        assertNotSame(one, result)
        assertNotSame(two, result)
        assertEquals(
            mapOf("a" to setOf("a1", "a2", "a3"), "b" to setOf("b1")),
            result.toMap()
        )
    }

    @Test
    fun testOperatorPlusAssign() {
        val one = this.makeMessageBag()
        val two = this.makeMessageBag()

        one.add("a", "a1")
        one.add("a", "a2")
        two.add("a", "a2")
        two.add("a", "a3")
        two.add("b", "b1")

        one += two
        assertEquals(
            mapOf("a" to setOf("a1", "a2", "a3"), "b" to setOf("b1")),
            one.toMap()
        )
    }
}