package com.example.jetpack_compose_lazycolumn

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_lazycolumn.data.PusatDataNotifFB
import com.example.jetpack_compose_lazycolumn.view.ViewDataNotif

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HalamanNotifikasi() {

    val itemNotif = remember { PusatDataNotifFB.recordDataNotifFacebook}

    Column(){

        HeaderPage()

        LazyColumn(){
            items(
                items = itemNotif,
                itemContent = {
                    ViewDataNotif(kolomNotifFB = it)
                }
            )
        }
    }

}


@Composable
fun MenuTabAtas() {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Beranda", "Pesan", "Market","Notif")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    icon = {
                        when (index) {
                            0 -> Image(
                                painter = painterResource(id = R.drawable.house),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            1 -> Image(
                                painter = painterResource(id = R.drawable.messenger),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            2 -> Image(
                                painter = painterResource(id = R.drawable.market),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            3 -> Image(
                                painter = painterResource(id = R.drawable.notif),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                    }
                )
            }
        }
//        when (tabIndex) {
//            0 -> HomeScreen()
//            1 -> AboutScreen()
//            2 -> SettingsScreen()
//        }
    }
}

// ----

@Composable
fun HeaderPage(){
    Column(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(android.graphics.Color.parseColor("#bb0909")))
        ){
            Branding("JAVASATU.COM")
        }

        MenuTabAtas()
        JudulHalaman("Notifikasi")

        Divider(thickness = Dp.Hairline,color = Color.LightGray)
    }
}

@Composable
fun JudulHalaman(notif: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ){
        Text(
            text= notif,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.lens),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .padding(end = 8.dp)
        )
    }
}

@Composable
fun Branding(branding: String) {
    Text(
        modifier = Modifier
            .padding(8.dp),
        text = branding,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}
