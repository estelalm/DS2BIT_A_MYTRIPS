package br.senai.sp.jandira.mytrips

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
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
                        .fillMaxSize()
                        .verticalScroll(ScrollState(1), enabled = true),
                    color = Color.White
                ) {
                    SignUp()
                }
            }
        }
    }
}

val purple = 0xffCF06F0
val gray = 0xffA09C9C
val lightGray = 0xF6F6F6ff;


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

val gradiente = Brush.horizontalGradient(listOf(Color(purple), Color.White))
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
            shape = RoundedCornerShape(20.dp)
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
                        .size(65.dp)
                        .offset(17.dp, 14.dp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.addphoto),
                contentDescription = "Ícone de adicionar foto",
                modifier = Modifier
                    .size(30.dp)
                    .offset(-15.dp, 72.dp)
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ){
            OutlinedTextField(
                value = "Susanna Hoffs",
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
                    containerColor = Color(0x0000000)
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

@Composable fun MyTrips(){

    Column (
        modifier = Modifier.fillMaxSize()
    ) {

        Card () {
            Column {
                Column ( ){
                    Card () {

                    }
                    Text(text = "Susanna Hoffs")
                }
                Column {
                    Row {
                        Icon(Icons.Filled.LocationOn, contentDescription = "Ícone de localização")
                        Text(text = "You're in Paris")
                    }
                }
            }
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

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTripsPreview() {
    MyTripsTheme {
        MyTrips()
    }
}
*/