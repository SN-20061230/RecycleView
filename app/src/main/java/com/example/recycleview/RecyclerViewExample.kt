package com.example.recycleview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecyclerViewExample(list: List<Item>) {
    LazyVerticalGrid( modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(count = 2))
    {
        items(list) {
            Card(
                modifier = Modifier
                    .wrapContentWidth()

                    .padding(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = it.imageId),
                        contentDescription = null, // Provide a meaningful description
                        modifier = Modifier
                            .height(200.dp)
                            .width(200.dp),
                        contentScale = ContentScale.Crop // Adjust as needed


                    )





                }



                Text(  modifier = Modifier
                    .padding(8.dp)
                    , text = it.title)
                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(text = it.price_discount, fontWeight = FontWeight(600))
                    Spacer(modifier = Modifier.width(18.dp))
                    Text(text = it.price_real, fontWeight = FontWeight(600),
                        textDecoration = TextDecoration.LineThrough)
                    Spacer(modifier = Modifier.width(18.dp))

                    Text(text = it.percent + " OFF", fontWeight = FontWeight(600), color = Color.Red)
                }


                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null, // Provide a meaningful description
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        contentScale = ContentScale.Crop // Adjust as needed


                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = it.stars)

                }




            }
        }
    }
}


@Preview
@Composable
fun PreviewRecyclerView() {
    val itemList = listOf(
        Item(R.drawable.image1, "Calvin Clein", "$52", "$92.4", "20%","4.7 (86)"),
        Item(R.drawable.image2, "Shapaloq", "$12","$93.4", "13%", "4.8 (88)"),
        Item(R.drawable.image3, "Kamera","$13", "$94.5", "12%", "4.5 (89)"),
        // Add more items as needed
    )
    RecyclerViewExample(list = itemList)
}
