package com.example.btweek2


import android.R.attr.contentDescription
import android.os.Bundle
import androidx.compose.ui.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btweek2.ui.theme.BTweek2Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BTweek2Theme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ){
                    HomeScreen()
                }
            }
        }
    }
}
@Composable
fun HomeScreen (){
    var keyboard by remember { mutableStateOf("") } // dùng để lưu trữ khi nhập chữ
    var validationMessage by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.padding(24.dp).fillMaxSize(), // modifier để áp dụng thuộc tính cho column, padding tạo đệm, fillmaxsize để chiểm toàn bộ diện tích
        horizontalAlignment = Alignment.CenterHorizontally, //căn chiều ngang cho các phần tử con bên trong column
        verticalArrangement = Arrangement.Center //căn chiều dọc cho các phần từ con trong column
    ){
        Chu1()
        NhapChu(emailValue = keyboard,
            onEmailChange = { newEmail ->
                keyboard = newEmail
            }
        )
        Text(
            text = validationMessage,
            color = if (validationMessage == "Bạn đã nhập email hợp lệ") Color(0xFF006400) else Color.Red
        )
        SimpleButton(

            onClick = {
                if (keyboard.isBlank()) { // isBlank() kiểm tra cả null, rỗng và chỉ có khoảng trắng
                    validationMessage = "Email không hợp lệ"
                } else if (!keyboard.contains("@")) {
                    validationMessage = "Email không đúng định dạng"
                } else {
                    validationMessage = "Bạn đã nhập email hợp lệ"
                }
            }
        )
    }
}


@Composable
fun Chu1(){
    Text(text = stringResource(id = R.string.text1),
        fontWeight = FontWeight.Bold,
        )
}

@Composable
fun NhapChu(emailValue: String, onEmailChange: (String) -> Unit){
    TextField(
        value = emailValue,
        onValueChange = onEmailChange, // Gọi hàm được truyền từ cha
        label = { Text("Email") },
        placeholder = { Text(text = "Input Email") },
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = {
                onEmailChange("") // Xóa text bằng cách gọi hàm với chuỗi rỗng
            }) {
                Icon(Icons.Default.Close, contentDescription = "Clear text")
            }
        }
    )
}


@Composable
fun SimpleButton(onClick: () -> Unit){
    Button(onClick = onClick,
        modifier = Modifier.width(400.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White,
            )
    ) {
        Text("Kiem tra")
    }

}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview(){
    BTweek2Theme {
        HomeScreen()
    }
}