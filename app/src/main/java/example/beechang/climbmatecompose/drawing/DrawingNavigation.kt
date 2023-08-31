package example.beechang.climbmatecompose.drawing

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


object DrawRoute {
    const val draw = "draw"
}

fun NavGraphBuilder.drawingNavGraph() {
    composable(route = DrawRoute.draw) {

    }
}