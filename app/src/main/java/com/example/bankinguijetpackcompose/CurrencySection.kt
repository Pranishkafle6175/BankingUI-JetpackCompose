package com.example.bankinguijetpackcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CurrencySection(){


    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){

        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
                ){

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .animateContentSize()
            ) {
                Box(modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(35.dp)
                    .background(color = MaterialTheme.colorScheme.secondary)
                    .align(Alignment.CenterVertically)

                ){

                    isVisible = !isVisible
                    if(isVisible){
                        iconState=Icons.Rounded.KeyboardArrowDown

                    }else{
                        Icons.Rounded.KeyboardArrowUp
                    }

                    Icon(imageVector = iconState,
                        contentDescription = "Icon",
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .size(35.dp)
                            .align(Alignment.Center)

                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Text(text = "Currencies",
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }

            CurrencyRate()
        }
    }
}


@Composable
fun CurrencyRate(){
    
}