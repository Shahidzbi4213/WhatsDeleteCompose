package com.cybersoft.whatsdelete.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.cybersoft.whatsdelete.models.SingleNotification


// Created by Shahid Iqbal on 1/7/2023.

@Composable
fun NotificationItem(
    modifier: Modifier = Modifier, item: SingleNotification
) {

    Card(
        shape = MaterialTheme.shapes.small, colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ), modifier = modifier
            .height(80.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {


        ConstraintLayout(
        ) {

            val (appIcon, postTime, profileImage, title, description) = createRefs()

            Image(imageVector = Icons.Default.Settings,
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(appIcon) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .size(13.dp)
                    .padding(top = 3.dp, start = 3.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground))

            Text(
                text = item.postTime, textAlign = TextAlign.End,
                fontSize = 10.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(postTime) {
                        end.linkTo(parent.end)
                        top.linkTo(appIcon.top)
                    }
                    .padding(end = 5.dp),
                style = MaterialTheme.typography.bodySmall,
            )


            Image(painter = painterResource(id = com.cybersoft.whatsdelete.R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 5.dp, end = 5.dp)
                    .constrainAs(profileImage) {
                        start.linkTo(parent.start)
                        top.linkTo(appIcon.bottom)
                        bottom.linkTo(parent.bottom)

                    })


            Text(
                text = item.title ?: "Person Name",
                fontSize = 12.sp,
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(profileImage.end)
                    top.linkTo(profileImage.top)
                },
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold

            )

            Text(text = item.text ?: "Message Detail",
                fontSize = 12.sp,
                modifier = Modifier.constrainAs(description) {
                    start.linkTo(title.start)
                    top.linkTo(title.bottom)
                })

        }
    }
}


@Composable
fun NotificationList(modifier: Modifier = Modifier) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(5.dp),
    ) {
        items(10) {
            NotificationItem(
                item = SingleNotification(
                    "Shahid Iqbal",
                    "Hi How are you?",
                    postTime = "01/2/2023 09:21 pm",
                    appIcon = null,
                    profileImage = null,
                    stackMsg = null
                )
            )
        }
    }
}

@Preview
@Composable
fun ShowCard() = NotificationList()