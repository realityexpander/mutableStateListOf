package com.realityexpander.mutablestatelistof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.realityexpander.mutablestatelistof.ui.theme.MutableStateListOfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MutableStateListOfTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val elements1 by homeViewModel.elements1
    val elements2 = homeViewModel.elements2

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        Button(
            onClick = {
                homeViewModel.addElement()
            }
        ) {
            Text(text = "Add Element1")
        }

        elements1.forEach {
            Text(
                text = "Number $it",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                homeViewModel.addElement2()
            }
        ) {
            Text(text = "Add Element2")
        }

        elements2.forEach {
            Text(
                text = "Number $it",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            )
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MutableStateListOfTheme {
//        Greeting("Android")
//    }
//}