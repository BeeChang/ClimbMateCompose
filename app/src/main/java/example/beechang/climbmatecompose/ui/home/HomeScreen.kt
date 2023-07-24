package example.beechang.climbmatecompose.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme
import kotlin.math.ln

@Composable
fun HomeScreen(
    modifier : Modifier = Modifier ,
    isDarkTheme : Boolean = isSystemInDarkTheme() ,
) {

    Box (
        modifier = modifier.fillMaxSize()
    ){
        HomeHeaderBar(isDarkMode = isDarkTheme)
    }
}


@Preview(name = "Light Mode" , uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    ClimbMateComposeTheme {
        HomeScreen( )
    }
}

