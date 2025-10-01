package com.example.composetry

class EvenOdd(private val upperCase: Boolean) {
    fun check(value: Int): String {
        var result = if (value % 2 == 0) "Even" else "Odd"
        if (upperCase) result = result.uppercase()
        return  result
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun toString(): String {
        return "EvenOdd(uppercase = $upperCase, hashcode = ${hashCode().toHexString()})"
    }
}