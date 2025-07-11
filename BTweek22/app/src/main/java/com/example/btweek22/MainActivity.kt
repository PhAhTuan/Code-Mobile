package com.example.btweek22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btweek22.ui.theme.BTweek22Theme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BTweek22Theme {
                Surface(
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
fun NhapThongTin() {
    val hoTen = remember { mutableStateOf("") }  //
    val tuoi = remember { mutableStateOf("") }
    val ketQua = remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally)  {
        Text(
            text = "THỰC HÀNH 01",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = hoTen.value,
            onValueChange = { hoTen.value = it },
            label = { Text("Họ và tên") }
        )

        OutlinedTextField(
            value = tuoi.value,
            onValueChange = { tuoi.value = it },
            label = { Text("Tuổi") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(top = 8.dp)
        )

        androidx.compose.material3.Button(
            onClick = {
                val tuoiSo = tuoi.value.toIntOrNull()

                ketQua.value = if (tuoiSo != null) {
                    when {
                        tuoiSo > 151 -> "Không còn sống"
                        tuoiSo in 66..150 -> "Người già"
                        tuoiSo in 7..65 -> "Người lớn"
                        tuoiSo in 3..6 -> "Trẻ em"
                        tuoiSo in 0..2 -> "Em bé"
                        else -> "Tuổi không hợp lệ"
                    }
                } else {
                    "Vui lòng nhập số tuổi hợp lệ"
                }
            },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Kiểm tra")
        }

        // Hiển thị kết quả
        if (ketQua.value.isNotEmpty()) {
            Text(
                text = "Chào ${hoTen.value}, bạn là: ${ketQua.value}",
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Blue
            )
        }
    }
}
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        NhapThongTin()
    }
}
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview() {
    BTweek22Theme {
        HomeScreen()
    }
}
