package com.techevents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class CatalogItem(
    val title: String,
    val description: String,
    val image: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(onItemClick: (CatalogItem) -> Unit) {

    val items = listOf(
        CatalogItem("Gaming Fest", "Novedades del mundo gamer", R.drawable.ic_launcher_foreground),
        CatalogItem("VR Experience", "Explora la realidad virtual", R.drawable.ic_launcher_foreground),
        CatalogItem("Indie Dev Expo", "Juegos independientes y creativos", R.drawable.ic_launcher_foreground),
        CatalogItem("Retro Gaming Day", "Revive clásicos de los videojuegos", R.drawable.ic_launcher_foreground),
        CatalogItem("E-Sports Arena", "Competencias y torneos profesionales", R.drawable.ic_launcher_foreground),
        CatalogItem("Tech Builders", "Crea tu propio setup gamer", R.drawable.ic_launcher_foreground),
        CatalogItem("AI Gaming Talk", "Cómo la IA potencia los videojuegos", R.drawable.ic_launcher_foreground),
        CatalogItem("Next-Gen Consoles", "Explora la nueva generación de consolas", R.drawable.ic_launcher_foreground),
        CatalogItem("Unity Bootcamp", "Aprende a crear juegos desde cero", R.drawable.ic_launcher_foreground),
        CatalogItem("Digital Art Summit", "Arte, animación y diseño 3D", R.drawable.ic_launcher_foreground),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "TechEvents",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(items.size) { index ->
                val item = items[index]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(item) },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Imagen circular mejor presentada
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = item.title,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.LightGray.copy(alpha = 0.2f))
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = item.description,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}
