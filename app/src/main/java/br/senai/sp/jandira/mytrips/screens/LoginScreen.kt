package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.gray
import br.senai.sp.jandira.mytrips.purple
import br.senai.sp.jandira.mytrips.repository.UserRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme
import br.senai.sp.jandira.mytrips.ui.theme.Poppins

@Composable
fun LoginScreen(navController: NavHostController) {

    val userRepository = UserRepository(LocalContext.current)

    var emailState = remember {
        mutableStateOf("")
    }
    var senhaState = remember {
        mutableStateOf("")
    }
    var isErrorState = remember {
        mutableStateOf(false)
    }
    var mensagemErroState = remember {
        mutableStateOf("")
    }

    var showPasswordState = remember {
        mutableStateOf(false)
    }

MyTripsTheme {
    Surface (
        modifier = Modifier
        .fillMaxSize(),
        color = Color.White
    ){
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
                Text(text = stringResource(id = R.string.sign_in_message),
                    color = Color(gray),
                    fontFamily = Poppins
                )
            }

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)){
                Text(text = mensagemErroState.value, color = Color.Red)
                OutlinedTextField(
                    value = emailState.value,
                    label = {
                        Text(text = stringResource(id = R.string.email),
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
                        focusedLeadingIconColor = Color(purple),
                        focusedBorderColor = Color(purple)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    onValueChange = {
                        emailState.value = it
                    },
                    isError = isErrorState.value,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )
                OutlinedTextField(
                    value = senhaState.value,
                    label = {
                        Text(text = stringResource(id = R.string.password),
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .background(Color.White),
                            fontFamily = Poppins,)
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Lock, contentDescription = stringResource(id = R.string.password), modifier = Modifier.size(35.dp))
                    },
                    trailingIcon = {
                                   Icon(Icons.Outlined.RemoveRedEye,
                                       contentDescription = "Open eye: Show password",
                                       modifier = Modifier.clickable {
                                           if(showPasswordState.value){
                                               showPasswordState.value = false
                                           }else{
                                               showPasswordState.value = true
                                           }
                                       }
                                   )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedLeadingIconColor = Color(purple),
                        unfocusedContainerColor = Color.White,
                        unfocusedBorderColor = Color(purple),
                        focusedLeadingIconColor = Color(purple),
                        focusedBorderColor = Color(purple)
                    ),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .fillMaxWidth(),
                    onValueChange = {
                        senhaState.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    isError = isErrorState.value,
                    visualTransformation = if(showPasswordState.value){
                        VisualTransformation.None
                    }else{
                        PasswordVisualTransformation()
                    }
                )

                Button(onClick =
                {
                    var usuario = userRepository.buscarUsuarioPeloLogin(emailState.value, senhaState.value)

                        if(usuario == null) {
                                isErrorState.value = true
                                mensagemErroState.value = "Incorrect email or password"
                            } else{
                            println(usuario)
                            navController.navigate("home")
                    }
                },
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
                    Text(text = stringResource(id = R.string.sign_in).uppercase(),
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp)
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Forward Arrow")
                }


                        Row (modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp), horizontalArrangement = Arrangement.End) {
                            Text(text = stringResource(id = R.string.dont_have_account), fontSize = 13.sp, color = Color(gray), fontFamily = Poppins)
                        Text(text = stringResource(id = R.string.sign_up), fontSize = 13.sp, color = Color(purple), fontFamily = Poppins, fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {
                                navController.navigate("sign up")
                            })
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
}

}

//@Preview (showSystemUi = true)
//@Composable
//fun LoginScreenPreview() {
//    Surface (
//        modifier = Modifier
//            .fillMaxSize(),
//        color = Color.White
//    ) {
////    LoginScreen()
//    }
//}
