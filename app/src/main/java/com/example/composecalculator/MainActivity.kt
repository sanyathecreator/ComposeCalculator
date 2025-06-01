package com.example.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecalculator.ui.theme.ComposeCalculatorTheme
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCalculatorTheme {
                Scaffold { paddingValues ->
                    Calculator(Modifier.padding(paddingValues))
                }
            }
        }
    }
}

sealed class CalculatorButton(val symbol: String) {
    class Digit(val number: Int) : CalculatorButton(number.toString())
    object Dot : CalculatorButton(".")
    object Equals : CalculatorButton("=")
    object Delete : CalculatorButton("⌫")

    sealed class Operation(symbol: String) : CalculatorButton(symbol) {
        object Add : Operation("+")
        object Subtract : Operation("−")
        object Multiply : Operation("×")
        object Divide : Operation("÷")
        object Sign : Operation("+-")
        object Inverse : Operation("1/x")
        object Percent : Operation("%")
        object Sqr : Operation("x²")
        object Sqrt : Operation("√x")
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    val buttons = listOf(
        CalculatorButton.Operation.Percent,
        CalculatorButton.Digit(7),
        CalculatorButton.Digit(8),
        CalculatorButton.Digit(9),
        CalculatorButton.Operation.Multiply,
        CalculatorButton.Operation.Inverse,
        CalculatorButton.Digit(4),
        CalculatorButton.Digit(5),
        CalculatorButton.Digit(6),
        CalculatorButton.Operation.Subtract,
        CalculatorButton.Operation.Sqrt,
        CalculatorButton.Digit(1),
        CalculatorButton.Digit(2),
        CalculatorButton.Digit(3),
        CalculatorButton.Operation.Add,
        CalculatorButton.Operation.Sqr,
        CalculatorButton.Operation.Sign,
        CalculatorButton.Digit(0),
        CalculatorButton.Dot,
        CalculatorButton.Operation.Divide,
        //CalculatorButton.Equals
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFCCCACC))
            .padding(8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = "0",
                onValueChange = {},
                modifier = Modifier
                    .background(Color.White),
                readOnly = true,
                singleLine = true,
            )
            CalculatorButtonView(
                CalculatorButton.Delete,
                modifier = Modifier
                    .size(80.dp)
                    .padding(start = 4.dp)
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(buttons.size) { index ->
                val button = buttons[index]
                CalculatorButtonView(button)
            }
        }
        CalculatorButtonView(
            CalculatorButton.Equals,
            modifier = Modifier.fillMaxWidth().padding(vertical =  8.dp)
        )
    }
}

@Composable
fun CalculatorButtonView(
    button: CalculatorButton,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = when (button) {
        is CalculatorButton.Digit -> Color(0xFFFCE684)
        CalculatorButton.Operation.Multiply, CalculatorButton.Operation.Subtract,
        CalculatorButton.Operation.Add, CalculatorButton.Operation.Divide,
            -> Color(0xFFCBB6B6)

        CalculatorButton.Operation.Percent, CalculatorButton.Operation.Inverse,
        CalculatorButton.Operation.Sqrt, CalculatorButton.Operation.Sqr,
            -> Color(0xFFADCBFA)

        CalculatorButton.Equals -> Color(0xFFC4EAAC)
        CalculatorButton.Delete -> Color(0xFFEF9694)
        CalculatorButton.Dot, CalculatorButton.Operation.Sign -> Color.White
    }

    Button(
        onClick = { /* handle click */ },
        modifier = when (button) {
            CalculatorButton.Equals -> modifier.height(60.dp)
            else -> modifier.aspectRatio(1f)
        },
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = button.symbol,
            fontSize = 24.sp,
            color = Color.Black
        )
    }
}