package net.ntworld.kotlin.validator.rule

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class PassTest {
    @Test
    fun testPasses() {
        fun failedFn(value: String?): Boolean {
            return false
        }

        fun successFn(value: String?): Boolean {
            return true
        }

        fun errorFn(value: String?): Boolean {
            throw Exception("Error")
        }

        assertEquals(false, Pass(::failedFn).passes("test", "any"))
        assertEquals(true, Pass(::successFn).passes("test", "any"))
        try {
            Pass(::errorFn).passes("test", "any")
        } catch (exception: Exception) {
            assertEquals("Error", exception.message)
            return
        }
        assertFalse(true, "Should not reach here")
    }
}