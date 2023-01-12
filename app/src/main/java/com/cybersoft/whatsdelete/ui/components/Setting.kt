package com.cybersoft.whatsdelete.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


// Created by Shahid Iqbal on 1/10/2023.

@Composable
fun SettingScreen(
) {


    Column(modifier = Modifier.fillMaxSize()) {

        val buttonState = remember {
            mutableStateOf(true)
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)

        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxHeight()
            ) {

                Text(
                    text = "Clear All Notifications", modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                )
                TextButton({

                }) { Text(text = "Clear") }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxHeight()
            ) {

                Text(
                    text = "Dark Mode", modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium
                )
                Switch(checked = buttonState.value, onCheckedChange = {
                    buttonState.value = it
                }, colors = SwitchDefaults.colors(
                    Color.DarkGray
                ))
            }
        }

    }
}