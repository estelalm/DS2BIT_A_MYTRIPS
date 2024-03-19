package br.senai.sp.jandira.mytrips

import android.annotation.SuppressLint
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.BeachAccess
import androidx.compose.material.icons.filled.DownhillSkiing
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.outlined.Landscape
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme
import br.senai.sp.jandira.mytrips.ui.theme.Poppins

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
//                        .verticalScroll(ScrollState(1), enabled = true),
                    color = Color.White
                ) {
                    MyTripsPage()
                }
            }
        }
    }
}

val purple = 0xffCF06F0;
val gray = 0xffA09C9C;
val lightGray = 0xF6F6F6ff;
val lightPurple = 0xFFEAABF4;
val gradiente = Brush.horizontalGradient(listOf(Color(purple), Color.White));

@Composable
fun Login() {
    Column (modifier =  Modifier.fillMaxWidth()){
        Card (modifier = Modifier
            .width(150.dp)
            .height(65.dp)
            .offset(x = 260.dp, y = -20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(purple)
            ),
            shape = RoundedCornerShape(20.dp)
        ){}
        Spacer(modifier = Modifier.height(100.dp))

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)){
            Text(text = "Login",
                fontSize = 48.sp,
                color = Color(purple),
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.height(70.dp))
            Text(text = "Please sign in to continue.",
                color = Color(gray),
                fontFamily = Poppins)
        }

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)){
            OutlinedTextField(
                value = "teste@email.com",
                label = {
                        Text(text = "E-mail",
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .background(Color.White),
                            fontFamily = Poppins,)
                },
                leadingIcon = {
                      Icon(Icons.Filled.Email, contentDescription = "Email", modifier = Modifier.size(32.dp))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLeadingIconColor = Color(purple),
                    unfocusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(purple),
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                onValueChange = {}
            )
            OutlinedTextField(
                value = "**********",
                label = {
                    Text(text = "Password",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(Color.White),
                        fontFamily = Poppins,)
                },
                leadingIcon = {
                    Icon(Icons.Filled.Lock, contentDescription = "Password", modifier = Modifier.size(35.dp))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLeadingIconColor = Color(purple),
                    unfocusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(purple),
                ),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .fillMaxWidth(),
                onValueChange = {}
            )

            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(150.dp)
                    .height(75.dp)
                    .padding(12.dp)
                    .offset(215.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(purple)
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "SIGN IN",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp)
                Icon(Icons.Filled.ArrowForward, contentDescription = "Forward Arrow")
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp), horizontalArrangement = Arrangement.End) {
                Text(text = "Don't have an account? ", fontSize = 13.sp, color = Color(gray), fontFamily = Poppins)
                Text(text = "Sign up", fontSize = 13.sp, color = Color(purple), fontFamily = Poppins, fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
        Card (
            modifier = Modifier
                .width(150.dp)
                .height(80.dp)
                .offset(x = -20.dp, y = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(purple)
            ),
            shape = RoundedCornerShape(20.dp)
        ){
        }
    }
}



@SuppressLint("InvalidColorHexValue")
@Composable fun SignUp(){

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Card (modifier = Modifier
            .width(150.dp)
            .height(55.dp)
            .offset(x = 260.dp, y = -20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(purple)
            ),
            shape = RoundedCornerShape( 20.dp)
        ){}
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Sign Up",
                fontSize = 32.sp,
                color = Color(purple),
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
              modifier = Modifier.height(50.dp))
            Text(text = "Create a new account",
                color = Color(gray),
                fontFamily = Poppins,
                fontSize = 14.sp)
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Card (
                modifier = Modifier
                    .size(100.dp)
                    .offset(x = 10.dp),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(lightGray)
                ),
                border = BorderStroke(2.dp, gradiente)
            ){
                Image(
                    painter = painterResource(id = R.drawable.usuario),
                    contentDescription = "Ícone de usuário",
                    modifier = Modifier
                        .padding(16.dp)
                        ,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Inside

                )
            }

            Image(
                painter = painterResource(id = R.drawable.addphoto),
                contentDescription = "Ícone de adicionar foto",
                modifier = Modifier
                    .size(30.dp)
                    .offset((-15).dp, 72.dp)
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ){
            OutlinedTextField(
                value = "Susanna Hoffs",
                enabled = true,
                readOnly = false,
                label = {
                    Text(text = "Username",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(Color.White),
                        fontFamily = Poppins,)
                },
                leadingIcon = {
                    Image(painter = painterResource(id = R.drawable.usuariopreenchido), contentDescription = "Ícone de usuário", modifier = Modifier.size(32.dp))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLeadingIconColor = Color(purple),
                    unfocusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(purple),
                    unfocusedLabelColor = Color.Black,
                    focusedLeadingIconColor = Color(purple),
                    focusedContainerColor = Color.White,
                    focusedBorderColor = Color(purple),
                    focusedLabelColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                shape = RoundedCornerShape(14.dp),
                onValueChange = {}
            )
            OutlinedTextField(
                value = "99999-0987",
                label = {
                    Text(text = "Phone",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(Color.White),
                        fontFamily = Poppins,)
                },
                leadingIcon = {
                    Image(painter = painterResource(id = R.drawable.celular), contentDescription = "Celular", modifier = Modifier.size(32.dp))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLeadingIconColor = Color(purple),
                    unfocusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(purple),
                    unfocusedLabelColor = Color.Black,
                    focusedLeadingIconColor = Color(purple),
                    focusedContainerColor = Color.White,
                    focusedBorderColor = Color(purple),
                    focusedLabelColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                shape = RoundedCornerShape(14.dp),
                onValueChange = {}
            )
            OutlinedTextField(
                value = "susanna@email.com",
                label = {
                    Text(text = "E-mail",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(Color.White),
                        fontFamily = Poppins,)
                },
                leadingIcon = {
                    Icon(Icons.Filled.Email, contentDescription = "Email", modifier = Modifier.size(32.dp))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLeadingIconColor = Color(purple),
                    unfocusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(purple),
                    unfocusedLabelColor = Color.Black,
                    focusedLeadingIconColor = Color(purple),
                    focusedContainerColor = Color.White,
                    focusedBorderColor = Color(purple),
                    focusedLabelColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                shape = RoundedCornerShape(14.dp),
                onValueChange = {}
            )


            OutlinedTextField(
                value = "**********",
                enabled = true,
                label = {
                    Text(text = "Password",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(Color.White),
                        fontFamily = Poppins,)
                },
                leadingIcon = {
                    Icon(Icons.Filled.Lock, contentDescription = "Password", modifier = Modifier.size(35.dp))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLeadingIconColor = Color(purple),
                    unfocusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(purple),
                    unfocusedLabelColor = Color.Black,
                    focusedLeadingIconColor = Color(purple),
                    focusedContainerColor = Color.White,
                    focusedBorderColor = Color(purple),
                    focusedLabelColor = Color.Black
                ),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                onValueChange = {}
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Card (
                modifier = Modifier.size(30.dp),
                shape = RectangleShape,
                border = BorderStroke(1.dp, Color((purple))),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0x00000000)
                )
            ){
                Checkbox(checked = false, onCheckedChange = {/**/},
                    modifier = Modifier.size(30.dp),
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color.White,
                        checkedColor = Color.White,
                        checkmarkColor = Color(purple)
                    )
                )
            }
            Text(
                text = "Over 18?",
                fontFamily = Poppins,
                modifier = Modifier.padding(start = 12.dp)
            )
        }

        Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(horizontal = 20.dp, vertical = 6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(purple)
                ),
            shape = RoundedCornerShape(15.dp)
        ) {
          Text(
              text = "CREATE ACCOUNT",
              fontFamily = Poppins,
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp
          )
        }

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(end = 20.dp, top = 12.dp), horizontalArrangement = Arrangement.End) {
            Text(text = "Already have an account? ", fontSize = 12.sp, color = Color(gray), fontFamily = Poppins)
            Text(text = "Sign up", fontSize = 12.sp, color = Color(purple), fontFamily = Poppins, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(100.dp))
        Card (
            modifier = Modifier
                .width(150.dp)
                .height(60.dp)
                .offset(x = -20.dp, y = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(purple)
            ),
            shape = RoundedCornerShape(20.dp)
        ){
        }
    }


}

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
    val image : ImageVector
)
val categorieList = listOf(
    Categorie(
        1,
        "Mountain",
        Icons.Outlined.Landscape
    ),
    Categorie(
        1,
        "Snow",
        Icons.Default.DownhillSkiing
    ),
    Categorie(
        1,
        "Beach",
        Icons.Default.BeachAccess
)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun MyTripsPage(){

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
                        .padding(start = 16.dp, end= 16.dp, top = 12.dp, bottom = 8.dp)
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
                                modifier = Modifier.size(18.dp).offset(y = 5.dp)
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
                            modifier = Modifier.height(32.dp),
                        )
                    }
                }
            }
        } // fim do card

        Column (modifier = Modifier
            .background(Color(lightGray))
            .fillMaxSize()){
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
                    CategorieCard(nome = categorie.nome, imagem = categorie.image)
                }

            })

            SearchBar(query = "", onQueryChange = {}, onSearch = {} , active = false, onActiveChange = {},
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
            Text(
                text = "Past Trips",
                modifier = Modifier.padding(top = 12.dp, start = 12.dp, bottom = 2.dp),
                fontFamily = Poppins,
                color = Color.DarkGray,
                fontSize = 15.sp
            )
            LazyColumn(modifier = Modifier
                .fillMaxWidth(),
                contentPadding = PaddingValues(12.dp, 6.dp)
            ){

                items(tripList) { trip ->
                    PastTripCard(local = trip.nome, ano = trip.ano, descricao = trip.descricao, periodo = trip.periodo, imagem = trip.image)
                }
            }
      //      Column (modifier = Modifier
     //           .fillMaxWidth()
       //         .padding(8.dp)){
     //       }

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
            .padding(6.dp)) {
            Box(modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()){
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
fun CategorieCard(nome: String, imagem: ImageVector){
    Card (
        modifier = Modifier
            .height(70.dp)
            .width(130.dp)
            .padding(end = 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(purple),
            disabledContainerColor =  Color(lightPurple)
        ),
    ){
        Column (
            modifier = Modifier
                .padding(16.dp, 12.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(imagem, contentDescription = "$nome Icon", tint = Color.White)
            Text(text = nome, color = Color.White, fontFamily = Poppins, fontSize = 15.sp)
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    MyTripsTheme {
        Login()
    }
}

//não mostra a página inteira, precisa rolar a tela
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    MyTripsTheme {
        SignUp()
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTripsPreview() {
    MyTripsTheme {
        MyTripsPage()
    }
}









/*
                Card (
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .height(220.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)) {
                        Box(modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()){
                            Image(  painter = painterResource(id = R.drawable.london),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize(),
                                    contentDescription = "")
                        }
                        Column(
                            modifier = Modifier.padding(end = 10.dp)
                        ){
                            Text(   text = "London, 2019",
                                fontFamily = Poppins,
                                fontSize = 14.sp,
                                color = Color(purple),
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                            Text(   text = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.",
                                fontSize = 10.5.sp,
                                lineHeight = 12.sp,
                                fontFamily = Poppins,
                                color = Color.Gray,
                                modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
                            )
                            Text(   text = "18 Feb - 21 Feb",
                                fontSize = 10.sp,
                                fontFamily = Poppins,
                                textAlign = TextAlign.End,
                                color = Color(purple),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                    }
                }
*/
