package com.example.bankinguijetpackcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankinguijetpackcompose.Model.CurrencyModel
import com.example.bankinguijetpackcompose.ui.theme.GreenStart


val currencydata = listOf(
    CurrencyModel(
        icon = Icons.Rounded.AttachMoney,
        currenytype = "USD",
        buyrate = 23.35f,
        sellrate = 23.25f
    ),
    CurrencyModel(
        icon = Icons.Rounded.Euro,
        currenytype = "EUR",
        buyrate = 13.35f,
        sellrate = 13.25f
    ),
    CurrencyModel(
        icon = Icons.Rounded.CurrencyYen,
        currenytype = "YEN",
        buyrate = 26.35f,
        sellrate = 26.25f
    ),
    CurrencyModel(
        icon = Icons.Rounded.AttachMoney,
        currenytype = "USD",
        buyrate = 23.35f,
        sellrate = 23.25f
    ),
    CurrencyModel(
        icon = Icons.Rounded.Euro,
        currenytype = "EUR",
        buyrate = 13.35f,
        sellrate = 13.25f
    ),
    CurrencyModel(
        icon = Icons.Rounded.CurrencyYen,
        currenytype = "YEN",
        buyrate = 26.35f,
        sellrate = 26.25f
    ),

)


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

//BoxWithConstraints is used so as to get the maximum width of the box
            BoxWithConstraints(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(MaterialTheme.colorScheme.background)
            ){
                val boxWithConstraintsScope = this
                val width = boxWithConstraintsScope.maxWidth/3

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                ) {

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Text(text = "Currency",
                            modifier = Modifier
                                .width(width),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                            )

                        Text(text = "Buy",
                            modifier = Modifier
                                .width(width),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center)

                        Text(text = "Sell",
                            modifier = Modifier
                                .width(width),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                            )

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn(){
                        items(currencydata.size){ data ->
                            CurrencyRate(index = data , width=width
                                )
                        }
                    }

                }

            }

        }
    }
}


@Composable
fun CurrencyRate(index:Int,width:Dp){

    var currentdata = currencydata[index]

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(GreenStart)
            .padding(4.dp)
        ){
            Icon(imageVector = currentdata.icon , contentDescription = "Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(18.dp)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = currentdata.currenytype,
            modifier = Modifier
                .width(width)
                .padding(start = 15.dp)
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(text =currentdata.buyrate.toString(),
            modifier = Modifier
                .width(width),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = currentdata.sellrate.toString(),
            modifier = Modifier
                .width(width),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

    }

}