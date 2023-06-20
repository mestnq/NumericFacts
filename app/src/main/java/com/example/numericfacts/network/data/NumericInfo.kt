package com.example.numericfacts.network.data

import com.example.numericfacts.network.models.NumericInfoRequest

sealed class NumericInfo (
    open val text: String = "",
    open val number: Int = 0,
    open val found: Boolean,
    open val type: String = ""
) {
    data class MathInfo (
        override val text: String = "",
        override val number: Int = 0,
        override val found: Boolean,
        override val type: String = "",
    ) : NumericInfo(text, number, found, type)

    data class TriviaInfo (
        override val text: String = "",
        override val number: Int = 0,
        override val found: Boolean,
        override val type: String = "",
    ) : NumericInfo(text, number, found, type)

    data class DateInfo (
        override val text: String = "",
        val year: Int = 0,
        override val number: Int = 0,
        override val found: Boolean,
        override val type: String = "",
    ) : NumericInfo(text, number, found, type)

    data class DefaultInfo (
        override val text: String = "",
        val year: Int = 0,
        override val number: Int = 0,
        override val found: Boolean,
        override val type: String = "",
    ) : NumericInfo(text, number, found, type)


    companion object Factory {
        public fun getTool(res: NumericInfoRequest): NumericInfo {
            return if (res.found && res.type == "math") {
                MathInfo(res.text, res.number, res.found, res.type)
            } else if (res.found && res.type == "trivia") {
                TriviaInfo(res.text, res.number, res.found, res.type)
            } else if (res.found && res.type == "date") {
                DateInfo(res.text, res.year, res.number, res.found, res.type)
            } else {
                DefaultInfo(res.text, res.year, res.number, res.found, res.type)
            }
        }
    }
}