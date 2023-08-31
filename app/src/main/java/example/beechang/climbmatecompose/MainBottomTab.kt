package example.beechang.climbmatecompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import example.beechang.climbmatecompose.drawing.DrawRoute
import example.beechang.climbmatecompose.my.MyRoute
import example.beechang.climbmatecompose.ui.home.HomeRoute


enum class MainBottomTab (
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
) {
    HOME(
        route = HomeRoute.home,
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        iconTextId = R.string.tab_home
    ),
    DRAWING(
        route = DrawRoute.draw,
        selectedIcon = Icons.Default.DesignServices,
        unselectedIcon = Icons.Default.DesignServices,
        iconTextId = R.string.tab_drawing
    ),
    MY(
        route = MyRoute.my,
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        iconTextId = R.string.tab_my
    )
}

val insideBottomTabScreen = mapOf(
    HomeRoute.home to HomeRoute.home ,
    DrawRoute.draw to DrawRoute.draw ,
    MyRoute.my to MyRoute.my ,
)