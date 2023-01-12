package com.cybersoft.whatsdelete.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.cybersoft.whatsdelete.R


// Created by Shahid Iqbal on 1/7/2023.

@Composable
fun EmptyNotification() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.empty_notification))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.size(80.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewCat() = EmptyNotification()