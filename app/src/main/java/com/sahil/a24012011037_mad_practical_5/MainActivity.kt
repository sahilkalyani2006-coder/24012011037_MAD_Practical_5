package com.sahil.a24012011037_mad_practical_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sahil.a24012011037_mad_practical_5.ui.theme._24012021005_practical_5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            _24012021005_practical_5Theme() {
                AppNavigation()
            }
        }
    }
}