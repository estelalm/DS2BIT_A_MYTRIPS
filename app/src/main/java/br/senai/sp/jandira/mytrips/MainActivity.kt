package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MyTrips()
                }
            }
        }
    }
}

val purple = 0xffCF06F0
val gray = 0xffA09C9C

@Composable
fun MyTrips() {
    Column (modifier =  Modifier.fillMaxSize()){
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
                    .padding(12.dp),
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTripsPreview() {
    MyTripsTheme {
        MyTrips()
    }
}