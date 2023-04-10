package com.febinrukfan.composecounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.lifecycle.LifecycleEventObserver

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.*
import androidx.lifecycle.LifecycleOwner
import com.febinrukfan.composecounterapp.ui.theme.ComposeCounterAppTheme



class MainActivity : ComponentActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ComposeCounterAppTheme {
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

    var count by remember { mutableStateOf(0) }
    val lifecycleOwner = LocalLifecycleOwner.current


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

        Text( text = count.toString(),
            color = Color(0xFFBE9CE4),
            fontSize = 120.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(50.dp))


        OutlinedButton(onClick = {
            count++
        },
            modifier= Modifier.size(150.dp),
            shape = CircleShape,
            border= BorderStroke(3.dp, Color(0xFFBE9CE4)),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Blue)
        ) {
            // Adding an Icon "Add" inside the Button
            Icon(Icons.Default.Add ,contentDescription = "content description", tint=Color(
                0xFFBE9CE4), modifier = Modifier.size(80.dp))
        }



    }

    LaunchedEffect(lifecycleOwner) {
        // Add a lifecycle event observer to show a toast for all the lifecycle events of the activity
        lifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when (event) {
                    ON_PAUSE -> count = 0
                    ON_STOP -> count = 0
                    ON_DESTROY -> count = 0
                    else -> {

                    }
                }

            }
        })
    }


}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCounterAppTheme {
        Counter()
    }
}