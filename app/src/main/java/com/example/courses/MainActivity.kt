package com.example.courses

import android.os.Bundle
import android.util.Half
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.data.DataSource.topics
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseApp()
        }
    }
}

@Composable
fun CourseApp() {
    CoursesTheme() {
        TopicList(topicList = DataSource.topics)
    }
}

@Composable
private fun TopicList(topicList: List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(items = topicList){topic ->
            CourseCard(topic)
        }
    }
    
}

@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {

    Card() {
        Row() {
            Image(
                modifier = modifier
                    .height(68.dp)
                    .width(68.dp),
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.name)
            )
            Column() {
                Text(
                    modifier = modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.body2

                )
                Row(
                    modifier = modifier
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                        .wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = modifier
                            .height(14.dp),
                        tint = Color.Black,
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,

                        )

                    Text(
                        modifier = modifier.padding(start = 8.dp),
                        text = topic.points.toString(),
                        style = MaterialTheme.typography.caption

                    )
                }

            }


        }
    }
}

@Preview
@Composable
fun CourseCardPreview() {
    CourseCard(topic = DataSource.topics[12])
}