package example.beechang.climbmatecompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import example.beechang.climbmatecompose.drawing.drawingNavGraph
import example.beechang.climbmatecompose.my.myNavGraph
import example.beechang.climbmatecompose.ui.home.HomeRoute
import example.beechang.climbmatecompose.ui.home.homeNavGraph
import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme

@Composable
fun ClimbMateApp(
    widthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {

    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navigationActions: NavigationActions = rememberNavigationAction(navController)
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val navBackStackEntry by navController.currentBackStackEntryAsState()


    ClimbMateComposeTheme {
        Scaffold(
            bottomBar = {
                MainBottomNavigationBar(
                    navigationActions = navigationActions ,
                    navigateToTopLevelDestination = navigationActions::navigateTo
                )
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState,
                    modifier = Modifier.systemBarsPadding(),
                )
            }
        ) { innerPaddingModifier ->
            NavHost(
                modifier = modifier,
                navController = navController,
                startDestination = HomeRoute.home,
            ) {
                homeNavGraph(
                    onDetailClick = {},//TODO ADD FUNCTION
                    coroutineScope = coroutineScope
                )

                drawingNavGraph()

                myNavGraph()
            }
        }

    }
}

@Composable
fun MainBottomNavigationBar(
    navigationActions: NavigationActions,
    selectedDestination: String = MainBottomTab.HOME.route,
    navigateToTopLevelDestination: (MainBottomTab) -> Unit = {},
) {

    if (navigationActions.shouldShowBottomBar) {

        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
//        tonalElevation = 0.dp , 배경색 없앨시 사용
        ) {
            MainBottomTab.values().forEach { replyDestination ->
                NavigationBarItem(
                    selected = selectedDestination == replyDestination.route,
                    onClick = { navigateToTopLevelDestination(replyDestination) },
                    icon = {
                        Icon(
                            imageVector = replyDestination.selectedIcon,
                            contentDescription = stringResource(id = replyDestination.iconTextId)
                        )
                    },
                    label = { Text(text = stringResource(replyDestination.iconTextId)) }
                )
            }
        }
    }
}

