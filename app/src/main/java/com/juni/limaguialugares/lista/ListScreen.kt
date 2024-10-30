package com.juni.limaguialugares.lista

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.juni.limaguialugares.Places

@Composable
fun ListScreen(viewModel: ListViewModel, showImage: PlacesInterface) {
    val data by viewModel.placeList.observeAsState(emptyList())

    LazyColumn(Modifier.fillMaxSize()) {
        items(data) {
            ListItem(places = it, showImage = showImage)
        }
    }

}


@Composable
fun ListItem(places: Places, showImage: PlacesInterface, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier
        .clickable {
            showImage.placeSelect(places)
        }
        .padding(16.dp)) {
        Icon(
            painter = painterResource(android.R.drawable.ic_menu_send),
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
        Column(modifier.fillMaxWidth()) {
            Text(
                text = places.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth()
            )
            Text(
                text = places.district,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .height(25.dp)
                    .fillMaxWidth()
            )

        }
    }

}