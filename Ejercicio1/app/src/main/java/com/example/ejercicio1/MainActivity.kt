package com.example.ejercicio1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejercicio1.R
import com.example.ejercicio1.ui.theme.Ejercicio1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppScreen()
                }
            }
        }
    }
}

@Composable
fun AppScreen() {
    val userData = User(
        nombre = "User 1",
        estado = "Activo",
        fotoResId = R.drawable.ic_launcher_background
    )

    UserCard(
        user = userData,
        onFollowClick = { isFollowing ->
            val action = if (isFollowing) "empezó a seguir" else "dejó de seguir"
            Log.i("USER_ACTION", "${userData.nombre} $action")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun UserCardPreview() {
    Ejercicio1Theme {
        AppScreen()
    }
}