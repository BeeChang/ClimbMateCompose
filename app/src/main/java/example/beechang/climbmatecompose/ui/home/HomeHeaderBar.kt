package example.beechang.climbmatecompose.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import example.beechang.climbmatecompose.R
import example.beechang.climbmatecompose.ui.component.ClimbDivider
import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme

@Composable
fun HomeHeaderBar(
    onSearchClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(start = 16.dp),
    isDarkMode: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
) {
    Column(modifier = modifier.height(64.dp)) {

        Row(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(backgroundColor, shape = RoundedCornerShape(0.dp))
                .padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = if (isDarkMode) {
                    painterResource(R.drawable.logo_home_banner_white_font)
                } else {
                    painterResource(R.drawable.logo_home_banner_black_font)
                },
                contentDescription = null,
                modifier = Modifier.aspectRatio(1f)
            )

            Spacer(Modifier.weight(1f))

            IconButton(
                onClick = { onSearchClick() },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        ClimbDivider()
    }

}


@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeHeaderBar() {
    ClimbMateComposeTheme {
        HomeHeaderBar()
    }
}

