package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Row(modifier = modifier.weight(1f,)) {
            TextCard("Text composable", "Displays text and follows the recommended Material Design guidelines.", Color(0xFFEADDFF), modifier = Modifier.weight(1f,))
            TextCard("Image composable", "Creates a composable that lays out and draws a given Painter class object.", Color(0xFFD0BCFF), modifier = Modifier.weight(1f,))
        }
        Row(modifier = modifier.weight(1f,)) {

            TextCard("Row composable", "A layout composable that places its children in a horizontal sequence.", Color(0xFFB69DF8), modifier = Modifier.weight(1f,))
            TextCard("Column composable", "A layout composable that places its children in a vertical sequence.", Color(0xFFF6EDFF), modifier = Modifier.weight(1f))

        }
    }
}

@Composable
fun TextCard(title: String, content: String,color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(color = color).fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center,
        content = {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = content,
                    textAlign = TextAlign.Justify
                )
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Greeting()
    }
}