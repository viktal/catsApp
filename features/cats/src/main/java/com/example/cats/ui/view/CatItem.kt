package com.example.cats.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cats.R
import com.example.cats.ui.model.CatUI
import com.example.cats.ui.viewModel.CatsMainViewModel

@Composable
internal fun CatItem(
    cat: CatUI,
    viewModel: CatsMainViewModel,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = cat.imageUrl,
            contentDescription = stringResource(id = R.string.contentDescription_cat_image),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
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
            }

            var isFavorite by rememberSaveable { mutableStateOf(cat.isFavorite) }

            Box(
                modifier = Modifier.align(Alignment.CenterVertically),
                contentAlignment = Alignment.CenterEnd,
            ) {
                IconButton(
                    onClick = {
                        isFavorite = isFavorite?.not()
                        viewModel.favoriteStateChanged(cat, isFavorite)
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = stringResource(
                            id = R.string.contentDescription_back_button
                        ),
                        tint = if (isFavorite == true) Color.Red else Color.Gray
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
    }
}
