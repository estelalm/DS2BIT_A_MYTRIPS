package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mytrips.screens.HomeScreen
import br.senai.sp.jandira.mytrips.screens.LoginScreen
import br.senai.sp.jandira.mytrips.screens.SignUpScreen
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

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
                   val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        enterTransition = { slideInHorizontally () },
                        exitTransition = { slideOutHorizontally() }
                    ){
                        composable(route = "login"){ LoginScreen(navController)}
                        composable(route = "sign up"){ SignUpScreen(navController)}
                        composable(route = "home"){ HomeScreen(navController) }
                    }
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



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginPreview() {
//    MyTripsTheme {
//        Login()
//    }
//}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SignUpPreview() {
//    MyTripsTheme {
//        SignUp()
//    }
//}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MyTripsPreview() {
//    MyTripsTheme {
//        MyTripsPage()
//    }
//}


