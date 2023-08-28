package example.beechang.climbmatecompose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import example.beechang.climbmatecompose.ui.component.ClimbBottomNavigationBar
import example.beechang.climbmatecompose.ui.component.ClimbNavigationActions
import example.beechang.climbmatecompose.ui.component.ClimbTopLevelRoute
import example.beechang.climbmatecompose.ui.home.HomeScreen
import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun ClimbMateApp(
    widthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {

    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        ClimbNavigationActions(navController)
    }
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination =
        navBackStackEntry?.destination?.route ?: ClimbTopLevelRoute.HOME

    ClimbMateComposeTheme {
        Scaffold(
            bottomBar = {
                ClimbBottomNavigationBar(
                    selectedDestination = selectedDestination,
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
            ClimbNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPaddingModifier),
                coroutineScope =  coroutineScope
            )
        }

    }
}

@Composable
private fun ClimbNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ClimbTopLevelRoute.HOME,
    ) {
        composable(ClimbTopLevelRoute.HOME) {
            HomeScreen(
                coroutineScope = coroutineScope ,
             )
        }

        composable(ClimbTopLevelRoute.DRAWING) {

        }

        composable(ClimbTopLevelRoute.MY) {

        }
    }
}