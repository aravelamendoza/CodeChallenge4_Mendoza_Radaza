package com.example.codechallenge4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*      // For Column, Spacer, Row, etc.
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons    // For default icons
import androidx.compose.material.icons.filled.Visibility      // For password visibility icon
import androidx.compose.material.icons.filled.VisibilityOff   // For password visibility off icon
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codechallenge4.ui.theme.CodeChallenge4Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeChallenge4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormUI(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormUI(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    // Hobbies state variables
    var hobbyMountaineering by remember { mutableStateOf(false) }
    var hobbyPhotography by remember { mutableStateOf(false) }
    var hobbyCoding by remember { mutableStateOf(false) }
    var hobbyEating by remember { mutableStateOf(false) }

    // Experience level state
    var selectedExperienceLevel by remember { mutableStateOf("") }

    // Password state variables
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Simple Form Example",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Name field
        Text("Enter your name:")
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email field
        Text("Enter your Email:")
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Message field
        Text("Enter your Message:")
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Message") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 5,
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Hobbies Section
        Text("Select your hobbies", style = MaterialTheme.typography.titleMedium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = hobbyMountaineering, onCheckedChange = { hobbyMountaineering = it })
            Text("Mountaineering")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = hobbyPhotography, onCheckedChange = { hobbyPhotography = it })
            Text("Photography")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = hobbyCoding, onCheckedChange = { hobbyCoding = it })
            Text("Coding")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = hobbyEating, onCheckedChange = { hobbyEating = it })
            Text("Eating")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Experience Level
        Text("Select your experience level", fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = (selectedExperienceLevel == "Beginner"),
                onClick = { selectedExperienceLevel = "Beginner" }
            )
            Text(text = "Beginner")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = (selectedExperienceLevel == "Intermediate"),
                onClick = { selectedExperienceLevel = "Intermediate" }
            )
            Text(text = "Intermediate")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = (selectedExperienceLevel == "Advanced"),
                onClick = { selectedExperienceLevel = "Advanced" }
            )
            Text(text = "Advanced")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Password field
        Text("Enter your Password:")
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            }
        )
    }
}
