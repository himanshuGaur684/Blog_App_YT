package com.gaur.blogappyt.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gaur.blogappyt.screens.home.PostItem
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun DetailsScreen(detailsViewModel: DetailsViewModel = hiltViewModel()) {

    val res = detailsViewModel.details.value


    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error.toString(), modifier = Modifier.align(Alignment.Center))
        }
    }

    res.data?.let {
        Column(modifier = Modifier) {
            PostItem(it = it, l = {})
            Text(text = it.likes.toString() + " Likes", modifier = Modifier.padding(12.dp))
            FlowRow {
                it.tags.forEach {
                    TagItem(it = it)
                }
            }

        }


    }


}


@Composable
fun TagItem(it: String) {

    Card(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(8.dp), shape = RoundedCornerShape(
            40.dp
        ),
        border = BorderStroke(0.5.dp, color = Color.Gray)
    ) {
        Text(text = it, style = TextStyle(color = Color.Black), modifier = Modifier.padding(12.dp))
    }

}
