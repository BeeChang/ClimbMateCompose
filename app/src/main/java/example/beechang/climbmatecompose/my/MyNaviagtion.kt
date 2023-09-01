package example.beechang.climbmatecompose.my

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object MyRoute {
    const val my = "my"
}

fun NavGraphBuilder.myNavGraph() {
    composable(route = MyRoute.my) {

    }
}