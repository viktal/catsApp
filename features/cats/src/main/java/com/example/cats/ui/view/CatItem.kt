package com.example.cats.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cats.R
import com.example.cats.ui.model.CatUI

@Composable
fun CatItem(cat: CatUI, onClick: () -> Unit) {
    Column(modifier = Modifier.clickable { onClick() }) {
        AsyncImage(
            model = cat.imageUrl,
            contentDescription = stringResource(id = R.string.contentDescription_cat_image),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth
        )

        if (cat.breed?.isNotEmpty() == true) {
            val text = stringResource(id = R.string.breed_subtitle) + " ${cat.breed}"
            Text(
                text = text,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        if (cat.country?.isNotEmpty() == true) {
            val text = stringResource(id = R.string.country_subtitle) + " ${cat.country}"
            Text(
                text = text,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
    }
}