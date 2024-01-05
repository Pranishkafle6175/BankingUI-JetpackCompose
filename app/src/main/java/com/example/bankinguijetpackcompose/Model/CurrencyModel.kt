package com.example.bankinguijetpackcompose.Model

import androidx.compose.ui.graphics.vector.ImageVector

data class CurrencyModel (
    val icon:ImageVector,
    val currenytype:String,
    val buyrate:String,
    val sellrate:String
    )