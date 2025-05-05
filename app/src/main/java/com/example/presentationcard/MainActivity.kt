package com.example.presentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentationcard.ui.theme.PresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresentationCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD8E3D9)
                ) {
                    PresentationCardData()
                }
            }
        }
    }
}

@Composable
fun PresentationCardData() {
    PresentationCardText(
        imagePainter = painterResource(R.drawable.androidlogo),
        name = stringResource(R.string.text_name),
        title = stringResource(R.string.text_title),
        phone = stringResource(R.string.text_phone),
        socialnet = stringResource(R.string.text_social_network),
        email = stringResource(R.string.text_email)
    )
}

@Composable
fun PresentationCardText(
    name: String,
    title: String,
    phone: String,
    socialnet: String,
    email: String,
    imagePainter: Painter
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD8E3D9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 120.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileImage(imagePainter)
            ProfileInfo(name = name, title = title)
        }

        ContactInfo(
            phone = phone,
            handle = socialnet,
            email = email,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}





@Composable
private fun ProfileImage(image: Painter) {
    Image(
        painter = image,
        contentDescription = "Android logo",
        modifier = Modifier
            .size(100.dp)
            .padding(bottom = 24.dp)
            .background(Color.DarkGray)
    )
}


@Composable
private fun ProfileInfo(name: String, title: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = name,
            fontSize = 36.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF316249),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}


@Composable
fun ContactInfo(phone: String, handle: String, email: String, modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(0.8f),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactRow(icon = Icons.Default.Call, content = phone)
        ContactRow(icon = Icons.Default.Share, content = handle)
        ContactRow(icon = Icons.Default.Email, content = email)
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, content: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = content,
            tint = Color(0xFF295F46),
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = content,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PresentationCardPreview() {
    PresentationCardTheme {
        PresentationCardData()
    }
}
