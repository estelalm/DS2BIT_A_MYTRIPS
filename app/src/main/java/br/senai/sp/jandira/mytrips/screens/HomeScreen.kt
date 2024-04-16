package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import br.senai.sp.jandira.mytrips.repository.CategorieRepository
import br.senai.sp.jandira.mytrips.repository.TripRepository
import br.senai.sp.jandira.mytrips.utility.simplificarData
import java.time.LocalDate




var count = 0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {


    var searchState = remember {
        mutableStateOf("")
    }
    var categorieColorState = remember{
        mutableStateOf("Mountain")
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
                    items(CategorieRepository().listAllCategories()){
                        var color = purple

                        if(categorieColorState.value != it.local){
                            color = lightPurple
                        }

                        Card (
                            modifier = Modifier
                                .height(66.dp)
                                .width(130.dp)
                                .padding(end = 10.dp)
                                .clickable { categorieColorState.value = it.local },
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
                                Image(painter = painterResource(id = it.image!!), contentDescription = "${it.local} Icon" )
                                Text(text = it.local, color = Color.White, fontFamily = Poppins, fontSize = 15.sp)
                            }
                        }
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
                items(TripRepository().listAllTrips()) { trip ->
                    if(searchState.value == "" || trip.destino.contains(searchState.value)){
                        PastTripCard(
                            local = trip.destino,
                            data_chegada = trip.data_chegada,
                            data_partida = trip.data_partida,
                            descricao = trip.descricao,
                            imagem = trip.imagem!!)
                    }

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
fun PastTripCard(local: String, data_chegada: LocalDate, data_partida: LocalDate, descricao: String,  imagem: Int){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier

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
                .height(116.dp)
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
                Text(   text = "$local, ${data_chegada.year}",
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
                Text(  text = "${simplificarData(data_chegada)} - ${simplificarData(data_partida)}",
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
fun CategorieCard(local: String, imagem: Int, color: Long, state : String){
    Card (
        modifier = Modifier
            .height(66.dp)
            .width(130.dp)
            .padding(end = 10.dp)
            .clickable { local },
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
            Image(painter = painterResource(id = imagem), contentDescription = "$local Icon" )
            Text(text = local, color = Color.White, fontFamily = Poppins, fontSize = 15.sp)
        }
    }
}