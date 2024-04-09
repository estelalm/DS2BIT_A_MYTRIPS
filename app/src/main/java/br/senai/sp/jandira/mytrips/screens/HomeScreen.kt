package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.lightGray
import br.senai.sp.jandira.mytrips.lightPurple
import br.senai.sp.jandira.mytrips.purple
import br.senai.sp.jandira.mytrips.ui.theme.Poppins
import androidx.compose.material3.Card


data class Trip(
    val id: Int,
    val nome: String,
    val descricao: String,
    val ano: String,
    val periodo: String,
    val image : Int
)
val tripList = listOf(
    Trip(
        1,
        "London",
        "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.",
        "2019",
        "18 Feb - 21 Feb",
        R.drawable.london
    ),
    Trip(
        2,
        "Porto",
        "Porto is the second largest city in Portugal, the capital of the Porto District and one of the Iberian Peninsula's major urban areas.",
        "2022",
        "16 Jun - 26 Jun",
        R.drawable.porto
    )
)

data class Categorie(
    val id: Int,
    val nome: String,
    val image : Int
)
val categorieList = listOf(
    Categorie(
        1,
        "Mountain",
        R.drawable.mountain
    ),
    Categorie(
        2,
        "Snow",
        R.drawable.snow
    ),
    Categorie(
        3,
        "Beach",
        R.drawable.beach
    )
)






var count = 0
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {


    var searchState = remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(184.dp),
            shape = RectangleShape
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Image(painter = painterResource(id = R.drawable.paris),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 18.dp, end = 16.dp, top = 12.dp, bottom = 8.dp)
                ) {

                    Column (
                        modifier = Modifier.
                        fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ){

                        Card (
                            modifier = Modifier.size(60.dp),
                            shape = RoundedCornerShape(50.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.susanna),
                                modifier = Modifier.fillMaxSize(),
                                contentDescription = "")
                        }
                        Text(
                            text = "Susanna Hoffs",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                    Column (
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Row (modifier = Modifier.height(16.dp)){
                            Icon(
                                Icons.Filled.LocationOn,
                                contentDescription = "Ícone de localização",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(18.dp)
                                    .offset(y = 5.dp)
                            )
                            Text(
                                text = "You're in Paris",
                                color = Color.White,
                                fontFamily = Poppins,
                                letterSpacing = (-0.5).sp,
                                fontSize = 15.sp,
                                modifier = Modifier.offset(y = 4.dp)
                            )
                        }
                        Text(
                            text = "My Trips",
                            color = Color.White,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            letterSpacing = -1.sp,
                            modifier = Modifier
                                .height(32.dp)
                                .padding(start = 2.dp),
                        )
                    }
                }
            }
        } // fim do card

        Column (modifier = Modifier
            .background(Color(lightGray))
            .fillMaxSize()
            .padding(horizontal = 8.dp))
        {
            Text(
                text = "Categories",
                modifier = Modifier.padding(top = 12.dp, start = 12.dp, bottom = 2.dp),
                fontFamily = Poppins,
                color = Color.DarkGray
            )
            LazyRow(
                modifier = Modifier.padding(start = 12.dp),
                content = {
                    items(categorieList){ categorie ->
                        count++
                        var color = purple
                        if(count > 1){
                            color = lightPurple
                        }
                        CategorieCard(nome = categorie.nome, imagem = categorie.image, color)
                    }

                })

            SearchBar(query = searchState.value,
                onQueryChange = {
                    searchState.value = it
                }, onSearch = {} , active = false, onActiveChange = {},
                colors = SearchBarDefaults.colors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp),
                trailingIcon = {
                    Icon(Icons.Outlined.Search, contentDescription = "", tint = Color.Gray)
                },
                placeholder = {
                    Text(
                        text = "Search your destiny",
                        color = Color.Gray,
                        fontFamily = Poppins,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier
                    .padding(12.dp)
                    .height(50.dp)

            ) {}

            LazyColumn(modifier = Modifier
                .fillMaxWidth(),
                contentPadding = PaddingValues(12.dp, 6.dp)
            ){
                item {
                    Text(
                        text = "Past Trips",
                        modifier = Modifier.padding(top = 12.dp, bottom = 2.dp),
                        fontFamily = Poppins,
                        color = Color.DarkGray,
                        fontSize = 15.sp
                    )
                }
                items(tripList) { trip ->
                    PastTripCard(local = trip.nome, ano = trip.ano, descricao = trip.descricao, periodo = trip.periodo, imagem = trip.image)
                }
            }

        }
    }

    Row (
        modifier = Modifier
            .offset(320.dp, 640.dp)
    ) {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            containerColor = Color(purple),
            contentColor = Color.White,
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier
                .border(1.dp, Color.White, RoundedCornerShape(100.dp))
                .border(1.dp, Color.White, RoundedCornerShape(100.dp))

        ) {
            Icon(Icons.Default.Add, "Add")
        }
    }


}


//cards das lazy columns e rows
@Composable
fun PastTripCard(local: String, ano: String, descricao: String, periodo: String, imagem:Int){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .height(226.dp)
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
        ) {
            Card(modifier = Modifier
                .height(120.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )
            {
                Image(  painter = painterResource(id = imagem),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "")
            }
            Column(
                modifier = Modifier.padding(end = 10.dp)
            ){
                Text(   text = "$local, $ano",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    color = Color(purple),
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(   text = descricao,
                    fontSize = 10.5.sp,
                    lineHeight = 14.sp,
                    fontFamily = Poppins,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth()
                )
                Text(   text = periodo,
                    fontSize = 10.sp,
                    fontFamily = Poppins,
                    textAlign = TextAlign.End,
                    color = Color(purple),
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}
@Composable
fun CategorieCard(nome: String, imagem: Int, color: Long){
    Card (
        modifier = Modifier
            .height(66.dp)
            .width(130.dp)
            .padding(end = 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(color),
            disabledContainerColor =  Color(lightPurple)
        ),
        shape = RoundedCornerShape(10.dp)
    ){
        Column (
            modifier = Modifier
                .padding(16.dp, 12.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(id = imagem), contentDescription = "$nome Icon" )
            Text(text = nome, color = Color.White, fontFamily = Poppins, fontSize = 15.sp)
        }
    }
}