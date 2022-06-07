package com.example.compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewMessage()
        }
    }
}

data class Message(
    val author: String,
    val body: String
)

@Composable
fun MyImage(){
    Image(
        painter= painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "image",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
    )
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        MyImage()
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = "Hello ${msg.author}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Hello ${msg.body}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessage() {
    MessageCard(msg = Message(author = "adf", body = "this is some text"))
}
