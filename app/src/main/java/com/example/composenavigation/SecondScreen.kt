package com.example.composenavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.gson.Gson

@Composable
fun SecondScreen(
    navController: NavHostController,
    personAsString: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        val gson = Gson()
        val myPersonAsObject = gson.fromJson(personAsString, Person::class.java)
        Text(
            text = "name: ${myPersonAsObject.name}, family: ${myPersonAsObject.family}, age: ${myPersonAsObject.age}",
            color = Color.Magenta
        )

        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            /**First way:
            navController.popBackStack()
             */
            /**Second way:*/
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        }) {
            Text(text = "Go To Home Screen")
        }
    }
}

/**
 * popUpTo: put this page(Home screen) in stack exactly before the current page(second screen)
 * and when I click on "Back bottun", close it for me. ==> did not create a new screen and just transit them to gather*/