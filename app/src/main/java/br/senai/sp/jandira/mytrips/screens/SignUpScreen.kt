package br.senai.sp.jandira.mytrips.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.gradiente
import br.senai.sp.jandira.mytrips.gray
import br.senai.sp.jandira.mytrips.lightGray
import br.senai.sp.jandira.mytrips.purple
import br.senai.sp.jandira.mytrips.repository.UserRepository
import br.senai.sp.jandira.mytrips.ui.theme.Poppins

@Composable
fun SignUpScreen(navController: NavHostController) {

    var nameState = remember {
        mutableStateOf("")
    }
    var phoneState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var passwordState = remember {
        mutableStateOf("")
    }
    var over18State = remember{
        mutableStateOf(false)
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(ScrollState(1), enabled = true)
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
                value = nameState.value,
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
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                shape = RoundedCornerShape(14.dp),
                onValueChange = {
                    nameState.value = it
                }
            )
            OutlinedTextField(
                value = phoneState.value,
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                onValueChange = {
                    phoneState.value = it
                }
            )
            OutlinedTextField(
                value = emailState.value,
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                onValueChange = {
                    emailState.value = it
                }
            )


            OutlinedTextField(
                value = passwordState.value,
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
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = {
                    passwordState.value = it
                }
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
                Checkbox(checked = over18State.value,
                    onCheckedChange = {
                        over18State.value = it
                    },
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
            onClick = {
                if(nameState.value != "" && phoneState.value != "" && emailState.value != "" && passwordState.value != ""){
                    navController.navigate("login")
                }else{
                    Toast.makeText( null, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                }

                      },
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
            Text(text = "Sign in", fontSize = 12.sp, color = Color(purple), fontFamily = Poppins, fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { navController.navigate("login") })
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