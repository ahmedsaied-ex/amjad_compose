import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.domain.models.BannerImageModel
import com.example.amjadcomposeapp.helpers.UiState
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import kotlin.math.absoluteValue

@Composable
fun BannerPager(banners: UiState<List<BannerImageModel>>, navController: NavController) {
    when (banners) {
        is UiState.Loading -> {
            // Placeholder أثناء التحميل
            androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            )
        }
        is UiState.Error -> {
            // رسالة الخطأ
            androidx.compose.material3.Text(
                text = banners.message,
                color = androidx.compose.ui.graphics.Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .padding(16.dp)
            )
        }
        is UiState.Success -> {
            val list = banners.data
            if (list.isEmpty()) return

            val pagerState = rememberPagerState(
                initialPage = list.size / 2,
                pageCount = { list.size }
            )

            HorizontalPager(
                state = pagerState,
                pageSize = PageSize.Fill,
                contentPadding =PaddingValues(horizontal = 50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .clipToBounds()
            ) { page ->

                val pageOffset =
                    (pagerState.currentPage - page + pagerState.currentPageOffsetFraction).absoluteValue.coerceIn(
                        0f, 1.2f
                    )

                val scale = lerp(0.85f, 1.1f, 1f - pageOffset)

                BannerItem(
                    navController = navController,
                    banner = list[page],
                    modifier = Modifier
                        .width(320.dp)
                        .aspectRatio(320f / 170f)
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                        }
                )
            }
        }
    }
}

@Composable
fun BannerItem(
    banner: BannerImageModel, modifier: Modifier = Modifier, navController: NavController
) {
    Card(
        modifier = modifier, elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Image(
            painter = painterResource(id = banner.img),
            contentDescription = "banner",
            modifier = Modifier.fillMaxSize().clickable{
                navController.navigate(AppRoute.Attachment::class.qualifiedName!!)
            },
            contentScale = ContentScale.Crop // fills the card completely
        )
    }
}

// Custom lerp function
fun lerp(start: Float, stop: Float, fraction: Float): Float {
    return start + (stop - start) * fraction
}
