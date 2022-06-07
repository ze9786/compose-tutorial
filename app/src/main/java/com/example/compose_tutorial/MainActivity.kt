package com.example.compose_tutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_tutorial.ui.theme.Compose_tutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_tutorialTheme {
                PreviewMessage()
            }
        }
    }
}

data class Message(
    val author: String,
    val body: String
)

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "image",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
    )
}

@Composable
fun Conversation(messages:List<Message>){
    LazyColumn{
        items(messages){
            message->
            MessageCard(msg = message)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)
        .clickable { println("HI")  }) {
        MyImage()
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = "Hello ${msg.author}")
            Spacer(modifier = Modifier.height(8.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 4.dp) {
                Text(text = "Hell ${msg.body}",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(all = 4.dp))
            }
        }
    }
}

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewMessage() {
    Compose_tutorialTheme {
        Conversation(messages = listOf(
            Message(author = "adf", body = "this is some text"),
            Message(author = "adf", body = "this is some text"),
            Message(author = "adf", body = "this is some text"),
            Message(author = "adf", body = "this is some text"),
        ))
    }
}
