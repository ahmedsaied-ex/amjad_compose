import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.presentation.navigation.bottomNavGraph
import com.example.amjadcomposeapp.presentation.navigation.calenderGraph
import com.example.amjadcomposeapp.presentation.navigation.attachmentGraph
import com.example.amjadcomposeapp.presentation.navigation.libraryGraph
import com.example.amjadcomposeapp.presentation.navigation.requestsGraph
import com.example.amjadcomposeapp.presentation.navigation.secondaryGraph


@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.Home::class.qualifiedName!!,
        modifier = modifier
    ) {
        bottomNavGraph(navController)
        secondaryGraph(navController)
        requestsGraph(navController)
        attachmentGraph(navController)
        calenderGraph(navController)
        libraryGraph(navController)
    }
}
