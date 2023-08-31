package example.beechang.climbmatecompose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


class NavigationActions(private val navController: NavHostController) {
    val shouldShowBottomBar: Boolean
        @Composable get() =
            navController.currentBackStackEntryAsState().value?.destination?.route in insideBottomTabScreen

    fun navigateTo(mainBottomTab: MainBottomTab) {
        val route = when (mainBottomTab){
            MainBottomTab.HOME -> MainBottomTab.HOME.route
            MainBottomTab.DRAWING -> MainBottomTab.DRAWING.route
            MainBottomTab.MY -> MainBottomTab.MY.route
        }
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
 fun rememberNavigationAction(
    navController: NavHostController ,
): NavigationActions = remember(navController) {
    NavigationActions(navController)
}