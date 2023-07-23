package example.beechang.climbmatecompose.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import example.beechang.climbmatecompose.R


import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme

object ClimbTopLevelRoute {
    const val HOME = "Home"
    const val DRAWING = "Drawing"
    const val MY = "My"
}

data class ClimbTopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)
class ClimbNavigationActions(private val navController: NavHostController) {

    fun navigateTo(destination: ClimbTopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

val TOP_LEVEL_DESTINATIONS = listOf(
    ClimbTopLevelDestination(
        route = ClimbTopLevelRoute.HOME,
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        iconTextId = R.string.tab_home
    ),

    ClimbTopLevelDestination(
        route = ClimbTopLevelRoute.DRAWING,
        selectedIcon = Icons.Default.DesignServices ,
        unselectedIcon = Icons.Default.DesignServices ,
        iconTextId = R.string.tab_drawing
    ),
    ClimbTopLevelDestination(
        route = ClimbTopLevelRoute.MY,
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        iconTextId = R.string.tab_my
    )

)
@Composable
fun ClimbBottomNavigationBar(
    selectedDestination: String = ClimbTopLevelRoute.HOME,
    navigateToTopLevelDestination: (ClimbTopLevelDestination) -> Unit = {}
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
//        tonalElevation = 0.dp , 배경색 없앨시 사용
    ) {
        TOP_LEVEL_DESTINATIONS.forEach { replyDestination ->
            NavigationBarItem(
                selected = selectedDestination == replyDestination.route,
                onClick = { navigateToTopLevelDestination(replyDestination) },
                icon = {
                    Icon(
                        imageVector = replyDestination.selectedIcon,
                        contentDescription = stringResource(id = replyDestination.iconTextId)
                    )
                } ,
                label = { Text(text = stringResource(replyDestination.iconTextId)) }
            )
        }
    }
}

@Preview
@Composable
private fun ClimbBottomNavigationBarPreview() {
    ClimbMateComposeTheme {
        ClimbBottomNavigationBar()
    }
}