package com.example.btweek5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btweek5.ui.theme.BTweek5Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BTweek5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Hinh()
    }
}
@Composable
fun KhungXanhNhat(
    modifier: Modifier = Modifier,
    // content là một hàm Composable khác được truyền vào
    content: @Composable () -> Unit
) {
    Surface(
        // Các thuộc tính của khung
        modifier = modifier,
        color = Color(0xFFE0F7FA), // Màu xanh nhạt (Cyan 50)
        shape = RoundedCornerShape(12.dp), // Bo góc 12.dp
        tonalElevation = 2.dp // Tạo bóng đổ nhẹ
    ) {
        Hinh()
        content()
    }
}

@Composable
fun Hinh(){
        Image(painterResource(id = R.drawable.img), contentDescription = "hinh logo")

}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview() {
    HomeScreen()
}




