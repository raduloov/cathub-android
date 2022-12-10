package com.example.cathub.ui

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.cathub.navigation.BottomNavGraph
import com.example.cathub.navigation.BottomNavBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val bottomBarNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(bottomBarNavController)
        }
    ) {
        BottomNavGraph(bottomBarNavController)
    }
}