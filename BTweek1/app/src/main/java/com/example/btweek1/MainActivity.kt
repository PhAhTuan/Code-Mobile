package com.example.btweek1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btweek1.ui.theme.BTweek1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BTweek1Theme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
@Composable
fun HomeScreen (){
    Column (modifier = Modifier.padding(24.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Home()
        Chu1()
        Chu2()
    }
}
@Composable
fun Home (){
    Image(
        painterResource(id = R.drawable.asus),
        contentDescription = "hinh asus",
        contentScale = ContentScale.Crop, // Đảm bảo ảnh lấp đầy hình tròn mà không bị méo
        modifier = Modifier
            .size(150.dp) // Đặt kích thước cố định cho hình tròn
            .clip(CircleShape)

    )
}
@Composable
fun Chu1 (){
    Text(text = stringResource(id = R.string.app_name),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold

        )
}
@Composable
fun Chu2 (){
    Text(text = stringResource(id = R.string.chu1),
        fontSize = 18.sp,

    )
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}
