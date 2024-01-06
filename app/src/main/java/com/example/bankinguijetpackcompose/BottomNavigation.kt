package com.example.bankinguijetpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.bankinguijetpackcompose.Model.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),

    BottomNavigation(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),

    BottomNavigation(
        title = "Notifications",
        icon = Icons.Rounded.Notifications
    ),

    BottomNavigation(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)

@Composable
fun BottomNavigationBar(){

    var selecteditem by remember{
        mutableStateOf(0)
    }
    NavigationBar {
        items.forEachIndexed{ index,item ->
            NavigationBarItem(
                selected = index==selecteditem ,
                onClick = {selecteditem=index },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title)}
            )

        }
    }
}