package com.febinrukfan.composecounterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.febinrukfan.composecounterapp.ui.theme.ComposeCounterAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter() {

    Column(
        // we are using column to align our
        // button to center of the screen.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

        // below line is used for specifying
        // vertical arrangement.
        verticalArrangement = Arrangement.Center,

        // below line is used for specifying
        // horizontal arrangement.
        horizontalAlignment = Alignment.CenterHorizontally,


    ) {
//        val context = ContextAmn.current

        Text( text = "ONE",
            color = Color.DarkGray,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)

        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

        val mContext = LocalContext.current


        OutlinedButton(onClick = { Toast.makeText(mContext, "This is a Circular Button with a + Icon", Toast.LENGTH_LONG).show()},
            modifier= Modifier.size(150.dp),
            shape = CircleShape,
            border= BorderStroke(3.dp, Color(0xFFBE9CE4)),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Blue)
        ) {
            // Adding an Icon "Add" inside the Button
            Icon(Icons.Default.Add ,contentDescription = "content description", tint=Color(
                0xFFBE9CE4
            )
            )
        }

//        Button(
//            onClick = {
//            },
//
//            // Uses ButtonDefaults.ContentPadding by default
//            contentPadding = PaddingValues(
//                start = 20.dp,
//                top = 14.dp,
//                end = 20.dp,
//                bottom = 14.dp
//            ),
//            modifier = Modifier
//                .size(64.dp)
//                .padding(16.dp)
//                .shape(CircleShape)
//
//        ) {
//            // Inner content including an icon and a text label
//            Icon(
//                Icons.Filled.Add,
//                contentDescription = "Favorite",
//                modifier = Modifier.size(ButtonDefaults.IconSize)
//            )
//            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
//            Text("CLICK")
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCounterAppTheme {
        Counter()
    }
}