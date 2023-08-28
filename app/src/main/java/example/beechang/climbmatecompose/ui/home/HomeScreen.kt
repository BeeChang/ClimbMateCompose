package example.beechang.climbmatecompose.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import example.beechang.climbmatecompose.MainViewModel
import example.beechang.climbmatecompose.R
import example.beechang.climbmatecompose.ui.component.ImagesPager
import example.beechang.climbmatecompose.ui.component.PagerDotsIndicator
import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) {

    val pagerState = rememberPagerState()
    val scrollState = rememberScrollState()

    val viewModel = viewModel<MainViewModel>()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        HomeHeaderBar(isDarkMode = isDarkTheme)
        Column(
            modifier = modifier
                .padding(top = 72.dp)
                .padding(horizontal = 16.dp) //HomeHeaderBar height = 64 , add margin top = 8
                .verticalScroll(scrollState)

        ) {
            ImagesPager(
                pagerState = pagerState ,
                modifier = Modifier.clip(MaterialTheme.shapes.small),
                imageUrlList = listOf(
                    R.drawable.banner_a,
                    R.drawable.banner_b,
                    R.drawable.banner_c,
                    R.drawable.banner_d
                ),
                onImageClick = {},
                hasDotIndicator = true,
                dotIndicator = { selectedIndex, size ->
                    PagerDotsIndicator(
                        selectedIndex = selectedIndex,
                        totalDots = size,
                    )
                }
            )
        }
    }
}


@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    ClimbMateComposeTheme {
        HomeScreen(

        )
    }
}

