package com.example.cathub

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.navigation.compose.rememberNavController
import com.example.cathub.navigation.BottomNavGraph
import com.example.cathub.ui.theme.CatHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            
            CatHubTheme(scaffoldState = scaffoldState) {
                BottomNavGraph(navController = navController)
            }
        }
    }
}