package com.example.bankinguijetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankinguijetpackcompose.Model.Finance
import com.example.bankinguijetpackcompose.ui.theme.BlueStart
import com.example.bankinguijetpackcompose.ui.theme.GreenStart
import com.example.bankinguijetpackcompose.ui.theme.OrangeStart
import com.example.bankinguijetpackcompose.ui.theme.PurpleStart


val financedata = listOf(
    Finance(
        icon = Icons.AutoMirrored.Rounded.StarHalf,
        title = "MY\nBusiness",
        color = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        title = "My\nWallet",
        color = BlueStart
    ),

    Finance(
        icon = Icons.Rounded.StarHalf,
        title = "Finance\nAnalytics",
        color = PurpleStart
    ),

    Finance(
        icon = Icons.Rounded.MonetizationOn,
        title = "My\nTransactions",
        color = GreenStart
    ),
)

@Composable
fun FinanceSection(){

    Column (modifier = Modifier
        .padding(horizontal = 10.dp)
    ){

        Text(text = "Finance",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
            )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(){
            items(financedata.size){
                item ->
//One item is displayed without extra padding then it serves padding for other items
                FinanceUi(item)
                
                if(item < financedata.size -1 ){
                    Spacer(modifier = Modifier.width(15.dp))
                }

            }

        }
    }

}

@Composable
fun FinanceUi(index: Int) {

    val data = financedata[index]

    Box(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .height(140.dp)
        .width(170.dp)
        .background(MaterialTheme.colorScheme.secondaryContainer)
    ){
            Column(modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
            ) {

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(data.color)
                        .height(55.dp)
                        .width(60.dp)
                ){
                    Icon(imageVector = data.icon, contentDescription = "Icon",
                        modifier = Modifier
                            .height(40.dp)
                            .width(45.dp)
                            .align(Alignment.Center),
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = data.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )


            }
    }
}

