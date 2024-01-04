package com.example.bankinguijetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankinguijetpackcompose.Model.Cards
import com.example.bankinguijetpackcompose.ui.theme.*

fun getGradient (startColor:Color, endColor:Color):Brush{
    return Brush.horizontalGradient(
        colors= listOf(startColor,endColor)
    )
}

@Composable
fun HomeScreen(){
    Row (horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 10.dp,
                horizontal = 10.dp
            )
            .fillMaxWidth()
        ){
        Column {
            Text(text = "Wallet",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
                )

            Text(text = "$ 34.346" ,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
                )
        }

        Box(modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center

        ){
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search",
                modifier = Modifier
                    .size(35.dp)
            )
        }
    }
}



@Composable
fun CardSection(){

    val cards = listOf(
        Cards(
            icon = painterResource(id = R.drawable.ic_visa),
            title = "Savings",
            money = "$ 3.467",
            idnumber = "0078 3467 3446 7899",
            color = getGradient(PurpleStart, PurpleEnd),
        ),
        Cards(
            icon = painterResource(id = R.drawable.ic_mastercard),
            title = "Business",
            money = "$ 14.0",
            idnumber = "8064 4530 2334",
            color = getGradient(BlueStart, BlueEnd)
        ),

        Cards(
            icon = painterResource(id = R.drawable.ic_visa),
            title = "School",
            money = "$ 6.37",
            idnumber = "2356 0293 8340 2458",
            color = getGradient(PurpleStart, BlueEnd)
        ),


        Cards(
            icon = painterResource(id = R.drawable.ic_mastercard),
            idnumber = "3567 7865 3786 3976",
            title = "Trips",
            money = "$ 26.47",
            color = getGradient(GreenStart, GreenEnd),
        ),
    )


    LazyRow(){
        items(cards.size) { card->
            Card(card,cards)

            if (card < cards.size - 1) {
                Spacer(modifier = Modifier.width(20.dp)) // Adjust the width as needed
            }

        }

    }
}

@Composable
fun Card( index : Int, cards: List<Cards>) {

    val carddata = cards[index]

    Box(modifier = Modifier
        .clip(RoundedCornerShape(25.dp))
        .background(Color.Cyan)
        .height(190.dp)
        .width(290.dp)
        .background(carddata.color)
    ){

        Column {
            Image(painter =carddata.icon, contentDescription ="Icon" ,Modifier.
                height(60.dp)
                .width(100.dp)
                .aspectRatio(1f)
                .padding(start = 20.dp, top = 10.dp)
            )

            Text(text = carddata.title,
                modifier = Modifier
                    .padding(start=20.dp, top=20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
                )

            Text(text = carddata.money,
                modifier = Modifier
                    .padding(start=20.dp, top=5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Text(text = carddata.idnumber,
                modifier = Modifier
                    .padding(start=20.dp, top=5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}