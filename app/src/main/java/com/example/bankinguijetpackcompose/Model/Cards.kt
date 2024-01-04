package com.example.bankinguijetpackcompose.Model

import android.media.Image
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter

data class Cards(
    val icon: Painter,
    val title:String,
    val money:String,
    val idnumber:String,
    val color:Brush
)