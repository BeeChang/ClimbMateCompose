package example.beechang.climbmatecompose.ui.component

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import example.beechang.climbmatecompose.R
import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme
import kotlinx.coroutines.delay
import timber.log.Timber


@OptIn(ExperimentalFoundationApi::class)
@Composable
        /**
         * @param imageUrlList = list type are only 2 kinds of int(drawble) ,  string(network link , file path)
         */
fun ImagesPager(
    imageUrlList: List<Any>,
    autoSlide: Boolean = true,
    delayTime: Long = 2000,
    aspectRatio: Float = 16f / 9f,
    modifier: Modifier = Modifier,
    pagerState: PagerState = remember { PagerState() },
    onImageClick: (Any) -> Unit = {},
    hasDotIndicator: Boolean,
    dotIndicator: @Composable (selectedIndex: Int, size: Int) -> Unit = { _, _ -> }
) {

    if (!imageUrlList.all { it is Int || it is String }) {
        Timber.tag("ImagesPager").d("The type of imageUrlList should be int or string")
        Timber.e("The type of imageUrlList should be int or string")
        return
    }

    val configuration = LocalConfiguration.current
    val height = configuration.screenWidthDp.dp / aspectRatio

    if (autoSlide) {
        LaunchedEffect(pagerState) {
            while (true) {
                delay(delayTime)
                val nextPage = (pagerState.currentPage + 1) % imageUrlList.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    Box(
        modifier
            .fillMaxWidth()
            .height(height)
    ) {
        HorizontalPager(
            pageCount = imageUrlList.size,
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            AsyncImage(
                model = imageUrlList[page],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        if (hasDotIndicator) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                dotIndicator(pagerState.currentPage, imageUrlList.size)
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ImagesPagerPreview() {
    val pagerState: PagerState = rememberPagerState()
    val configuration = LocalConfiguration.current
    val aspectRatio = 16f / 9f
    val height = configuration.screenWidthDp.dp / (aspectRatio)

    ClimbMateComposeTheme {
        Box(
            Modifier
                .fillMaxWidth()
                .height(height)
        ) {
            HorizontalPager(
                pageCount = 1,
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(aspectRatio)
            ) { page ->
                AsyncImage(
                    model = R.drawable.banner_a,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    placeholder = painterResource(R.drawable.banner_a),

                    )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                PagerDotsIndicator(
                    totalDots = 5,
                    selectedIndex = 0,
                )
            }
        }
    }
}

