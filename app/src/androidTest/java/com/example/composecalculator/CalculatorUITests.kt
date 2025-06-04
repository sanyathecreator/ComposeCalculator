package com.example.composecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composecalculator.ui.theme.ComposeCalculatorTheme
import com.example.composecalculator.ui.theme.MediumGrey
import org.junit.Rule
import org.junit.Test

class CalculatorUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun add_two_numbers() {
        composeTestRule.setContent {
            ComposeCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGrey)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        val expectedResult = "7.0"
        composeTestRule.onNodeWithText(expectedResult)
            .assertExists("No node with this text was found.")
    }

    @Test
    fun subtract_two_double_numbers() {
        composeTestRule.setContent {
            ComposeCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGrey)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        val expectedResult = "2.7"
        composeTestRule.onNodeWithText(expectedResult)
            .assertExists("No node with this text was found.")
    }

    @Test
    fun divide_two_numbers() {
        composeTestRule.setContent {
            ComposeCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGrey)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("/").performClick()
        composeTestRule.onNodeWithText("4").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        val expectedResult = "3.0"
        composeTestRule.onNodeWithText(expectedResult)
            .assertExists("No node with this text was found.")
    }

    @Test
    fun multiply_two_double_numbers() {
        composeTestRule.setContent {
            ComposeCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGrey)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("*").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        val expectedResult = "5.0"
        composeTestRule.onNodeWithText(expectedResult)
            .assertExists("No node with this text was found.")
    }

    @Test
    fun division_by_zero() {
        composeTestRule.setContent {
            ComposeCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGrey)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("/").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        val expectedResult = "Infinity"
        composeTestRule.onNodeWithText(expectedResult)
            .assertExists("No node with this text was found.")
    }
}