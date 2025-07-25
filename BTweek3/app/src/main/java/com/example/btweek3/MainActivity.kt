package com.example.btweek3



import android.os.Bundle
import androidx.compose.material3.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btweek3.ui.theme.BTweek3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BTweek3Theme {
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
fun HomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        hinhlogo()
        Spacer(modifier = Modifier.padding(20.dp))
        text1()
        Spacer(modifier = Modifier.padding(80.dp))
        Bamvao()
    }

}
@Composable
fun hinhlogo(){
    Image(
        painterResource(id = R.drawable.hinhanh),
        contentDescription = "logo",
        modifier = Modifier.size(300.dp)
    )
}
@Composable
fun text1(){
    Text(text = stringResource(id = R.string.app_name),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
    Spacer(modifier = Modifier.padding(5.dp))
    Text(text = stringResource(id = R.string.text1),
        textAlign = TextAlign.Center)
}
@Composable
fun Bamvao() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF03A9F4)
        ),
        modifier = Modifier
            .padding(8.dp)
            .width(350.dp)
            .size(50.dp)
    ) {
        Text(text = "I'am Ready")
    }
}



@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview() {
    BTweek3Theme {
        HomeScreen()
    }
}