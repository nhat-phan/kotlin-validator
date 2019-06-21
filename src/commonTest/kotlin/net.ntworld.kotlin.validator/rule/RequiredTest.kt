package net.ntworld.kotlin.validator.rule

import kotlin.test.Test
import kotlin.test.assertEquals

class RequiredTest {
    data class TestData<T>(
        val type: String,
        val value: T,
        val valid: Boolean
    )

    data class Custom(val a: String)

    private val nullDataset = TestData(type = "null", value = null, valid = false)

    private val booleanDataset = listOf<TestData<Boolean?>>(
        TestData(type = "Boolean", value = null, valid = false),
        TestData(type = "Boolean", value = false, valid = true),
        TestData(type = "Boolean", value = true, valid = true)
    )

    private val byteDataset = listOf<TestData<Byte?>>(
        TestData(type = "Byte", value = null, valid = false),
        TestData(type = "Byte", value = 0, valid = true),
        TestData(type = "Byte", value = -1, valid = true),
        TestData(type = "Byte", value = 1, valid = true)
    )

    private val shortDataset = listOf<TestData<Short?>>(
        TestData(type = "Short", value = null, valid = false),
        TestData(type = "Short", value = 0, valid = true),
        TestData(type = "Short", value = -1, valid = true),
        TestData(type = "Short", value = 1, valid = true)
    )

    private val intDataset = listOf<TestData<Int?>>(
        TestData(type = "Int", value = null, valid = false),
        TestData(type = "Int", value = 0, valid = true),
        TestData(type = "Int", value = -1, valid = true),
        TestData(type = "Int", value = 1, valid = true)
    )

    private val longDataset = listOf<TestData<Long?>>(
        TestData(type = "Long", value = null, valid = false),
        TestData(type = "Long", value = 0, valid = true),
        TestData(type = "Long", value = -1, valid = true),
        TestData(type = "Long", value = 1, valid = true)
    )

    private val floatDataset = listOf<TestData<Float?>>(
        TestData(type = "Float", value = null, valid = false),
        TestData(type = "Float", value = 0.0f, valid = true),
        TestData(type = "Float", value = 0.1f, valid = true),
        TestData(type = "Float", value = -1.0f, valid = true),
        TestData(type = "Float", value = 1.0f, valid = true)
    )

    private val doubleDataset = listOf<TestData<Double?>>(
        TestData(type = "Double", value = null, valid = false),
        TestData(type = "Double", value = 0.0, valid = true),
        TestData(type = "Double", value = 0.1, valid = true),
        TestData(type = "Double", value = -1.0, valid = true),
        TestData(type = "Double", value = 1.0, valid = true)
    )

    private val charDataset = listOf<TestData<Char?>>(
        TestData(type = "Char", value = null, valid = false),
        TestData(type = "Char", value = ' ', valid = true),
        TestData(type = "Char", value = 'a', valid = true)
    )

    private val stringDataset = listOf<TestData<String?>>(
        TestData(type = "String", value = null, valid = false),
        TestData(type = "String", value = "", valid = false),
        TestData(type = "String", value = "abc", valid = true),
        TestData(type = "String", value = "   ", valid = true)
    )

    private val booleanArrayDataset = listOf<TestData<BooleanArray?>>(
        TestData(type = "BooleanArray", value = null, valid = false),
        TestData(type = "BooleanArray", value = booleanArrayOf(), valid = false),
        TestData(type = "BooleanArray", value = booleanArrayOf(true), valid = true)
    )

    private val byteArrayDataset = listOf<TestData<ByteArray?>>(
        TestData(type = "ByteArray", value = null, valid = false),
        TestData(type = "ByteArray", value = byteArrayOf(), valid = false),
        TestData(type = "ByteArray", value = byteArrayOf(0), valid = true)
    )

    private val shortArrayDataset = listOf<TestData<ShortArray?>>(
        TestData(type = "ShortArray", value = null, valid = false),
        TestData(type = "ShortArray", value = shortArrayOf(), valid = false),
        TestData(type = "ShortArray", value = shortArrayOf(0), valid = true)
    )

    private val intArrayDataset = listOf<TestData<IntArray?>>(
        TestData(type = "IntArray", value = null, valid = false),
        TestData(type = "IntArray", value = intArrayOf(), valid = false),
        TestData(type = "IntArray", value = intArrayOf(0), valid = true)
    )

    private val longArrayDataset = listOf<TestData<LongArray?>>(
        TestData(type = "LongArray", value = null, valid = false),
        TestData(type = "LongArray", value = longArrayOf(), valid = false),
        TestData(type = "LongArray", value = longArrayOf(0), valid = true)
    )

    private val floatArrayDataset = listOf<TestData<FloatArray?>>(
        TestData(type = "FloatArray", value = null, valid = false),
        TestData(type = "FloatArray", value = floatArrayOf(), valid = false),
        TestData(type = "FloatArray", value = floatArrayOf(0.0f), valid = true)
    )

    private val doubleArrayDataset = listOf<TestData<DoubleArray?>>(
        TestData(type = "DoubleArray", value = null, valid = false),
        TestData(type = "DoubleArray", value = doubleArrayOf(), valid = false),
        TestData(type = "DoubleArray", value = doubleArrayOf(0.0), valid = true)
    )

    private val charArrayDataset = listOf<TestData<CharArray?>>(
        TestData(type = "CharArray", value = null, valid = false),
        TestData(type = "CharArray", value = charArrayOf(), valid = false),
        TestData(type = "CharArray", value = charArrayOf(' '), valid = true)
    )

    private val arrayStringDataset = listOf<TestData<Array<String>?>>(
        TestData(type = "Array<String>", value = null, valid = false),
        TestData(type = "Array<String>", value = arrayOf(), valid = false),
        TestData(type = "Array<String>", value = arrayOf(""), valid = true)
    )

    private val arrayIntDataset = listOf<TestData<Array<Int>?>>(
        TestData(type = "Array<Int>", value = null, valid = false),
        TestData(type = "Array<Int>", value = arrayOf(), valid = false),
        TestData(type = "Array<Int>", value = arrayOf(0), valid = true)
    )

    private val listDataset = listOf<TestData<List<Int>?>>(
        TestData(type = "List<Int>", value = null, valid = false),
        TestData(type = "List<Int>", value = listOf(), valid = false),
        TestData(type = "List<Int>", value = listOf(0), valid = true)
    )

    private val setDataset = listOf<TestData<Set<Int>?>>(
        TestData(type = "Set<Int>", value = null, valid = false),
        TestData(type = "Set<Int>", value = setOf(), valid = false),
        TestData(type = "Set<Int>", value = setOf(0), valid = true)
    )

    private val mapDataset = listOf<TestData<Map<String, Int>?>>(
        TestData(type = "Map<String,Int>", value = null, valid = false),
        TestData(type = "Map<String,Int>", value = mapOf(), valid = false),
        TestData(type = "Map<String,Int>", value = mapOf("a" to 0), valid = true)
    )

    private val arrayListDataset = listOf<TestData<ArrayList<Int>?>>(
        TestData(type = "ArrayList<Int>", value = null, valid = false),
        TestData(type = "ArrayList<Int>", value = arrayListOf(), valid = false),
        TestData(type = "ArrayList<Int>", value = arrayListOf(0), valid = true)
    )

    private val arrayCustomDataset = listOf<TestData<Array<Custom>?>>(
        TestData(type = "List<Int>", value = null, valid = false),
        TestData(type = "List<Int>", value = arrayOf(), valid = false),
        TestData(type = "List<Int>", value = arrayOf(Custom("any")), valid = true)
    )

    @Test
    fun testPasses() {
        val dataset = listOf<TestData<*>>() +
            nullDataset +
            booleanDataset +
            byteDataset +
            shortDataset +
            intDataset +
            longDataset +
            floatDataset +
            doubleDataset +
            charDataset +
            stringDataset +
            booleanArrayDataset +
            byteArrayDataset +
            shortArrayDataset +
            intArrayDataset +
            longArrayDataset +
            floatArrayDataset +
            doubleArrayDataset +
            charArrayDataset +
            arrayStringDataset +
            arrayIntDataset +
            listDataset +
            setDataset +
            mapDataset +
            arrayListDataset +
            arrayCustomDataset

        val rule = Required()
        for (item in dataset) {
            assertEquals(item.valid, rule.passes("test", item.value), "Failed with case '$item'")
        }
    }
}