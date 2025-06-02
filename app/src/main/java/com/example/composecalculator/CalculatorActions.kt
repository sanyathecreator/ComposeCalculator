package com.example.composecalculator

sealed class CalculatorActions {
    data class Number(val number: Int) : CalculatorActions()
    object Clear : CalculatorActions()
    object Delete : CalculatorActions()
    object Calculate : CalculatorActions()
    data class Operation(val operation: Operation) : CalculatorActions()
}