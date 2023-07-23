package example.beechang.climbmatecompose

import androidx.compose.animation.AnimatedVisibility
 import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
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
import example.beechang.climbmatecompose.navigation.ClimbBottomNavigationBar
import example.beechang.climbmatecompose.navigation.ClimbNavigationActions
import example.beechang.climbmatecompose.navigation.ClimbTopLevelRoute
import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme

@Composable
fun ClimbMateApp(
    modifier: Modifier = Modifier,
    closeDetailScreen: () -> Unit = {},
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
           }
       ){ innerPaddingModifier ->
           ReplyNavHost(
               navController = navController,
               closeDetailScreen = closeDetailScreen,
               modifier = Modifier.padding(innerPaddingModifier),
           )
       }

    }
}

@Composable
private fun ReplyNavHost(
    navController: NavHostController,
    closeDetailScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ClimbTopLevelRoute.HOME,
    ) {
        composable(ClimbTopLevelRoute.HOME) {

        }

        composable(ClimbTopLevelRoute.DRAWING) {

        }
        composable(ClimbTopLevelRoute.MY) {

        }
    }
}