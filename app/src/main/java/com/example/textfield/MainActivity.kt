package com.example.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.textfield.ui.theme.TextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextFieldScreen()
                }
            }
        }
    }
}
@Composable
fun TextFieldScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyAlertDialog()
        MyTextField()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    val textValue = remember { mutableStateOf("") }
    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = {}
    )
}

@Composable
fun MyAlertDialog() {
    val shouldShowDialog = remember { mutableStateOf(true) } // 1
    if (shouldShowDialog.value) { // 2
        AlertDialog( // 3
            onDismissRequest = { // 4
                shouldShowDialog.value = false
                //JetFundamentalsRouter.navigateTo(Screen.Navigation)
            },
            // 5
            title = { Text(text = stringResource(id =
            R.string.alert_dialog_title)) },
            text = { Text(text = stringResource(id =
            R.string.alert_dialog_text)) },
            confirmButton = { // 6
                Button(

                    onClick = {
                        shouldShowDialog.value = false
                        //JetFundamentalsRouter.navigateTo(Screen.Navigation)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.confirm),
                        color = Color.White
                    )
                }
            }
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextFieldTheme {
        TextFieldScreen()
    }
}