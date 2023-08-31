package example.beechang.climbmatecompose.ui.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.coroutines.CoroutineScope

fun NavGraphBuilder.homeNavGraph(
    onDetailClick: () -> Unit,
    coroutineScope: CoroutineScope ,
) {
    composable(route = HomeRoute.home) {
        homeRouter(
            onDetailClick = onDetailClick,
            coroutineScope = coroutineScope,
        )
    }
}

object HomeRoute {
    const val home = "home"

}
