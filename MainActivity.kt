package com.example.myfirstapplication

import android.app.Notification
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme

class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    Conversation(notifications = )
                }
            }
        }
    }
}

data class Message (val author: String, val body: String)
@Composable
fun MessageCard(msg: Message){
    Row (modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ted_2),
            contentDescription = "Imagen de tedy",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text (
                text = msg.author,
                color = androidx.compose.material.MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(6.dp))

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                
            }

            Text(
                text = msg.body,
                style = MaterialTheme.typography.body2
            )
        }
    }
}
@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark mode"
)
@Composable
fun PreviewMessageCard(){
    MyFirstApplicationTheme {
        Surface {
            MessageCard(
                msg = Message("Andrés Felipe Silva", "Analisis y desarrollo de software")
            )
        }
    }
}

@Composable
fun Conversation (notifications: List<Notification>){
    LazyColumn(content = {
        items(notifications) {
            Notification -> MessageCard(msg = Message("El pipe", "Que hizo manin"))
        }
    })
}


