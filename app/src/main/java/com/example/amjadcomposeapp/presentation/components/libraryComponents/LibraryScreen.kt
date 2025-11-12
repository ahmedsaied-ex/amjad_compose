package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.models.MediaType
import com.example.amjadcomposeapp.presentation.viewModel.MediaFilter
import com.example.amjadcomposeapp.presentation.viewModel.MediaViewModel
import com.example.amjadcomposeapp.ui.theme.Alexandria

@Composable
fun LibraryScreen(
    navController: NavController, viewModel: MediaViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
          ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyLibraryHeader(
            navController = navController,
            selectedFilter = state.selectedFilter,
            onFilterChange = { viewModel.onFilterSelected(it) },
        )
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            itemsIndexed(state.filteredMedia, key = { _, item -> item.id }) { index, item ->
                if (index == 0) {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                LibraryRequestRow(item = item)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }

}


@Composable
fun LibraryScreenPreviewer() {
    // Dummy data for preview
    val dummyMedia = remember {
        listOf(
            MediaRequest(
                id = "1",
                name = "أحمد ديردري",
                title = "مقدمة في Compose",
                description = "تعلم أساسيات Jetpack Compose وكيفية بناء واجهات مستخدم حديثة لأندرويد.",
                type = MediaType.ARTICLES,
                url = "https://example.com/articles/compose-intro",
                thumbnailUrl = R.drawable.jarir
            ),
            MediaRequest(
                id = "2",
                name = "سارة علي",
                title = "Compose للمبتدئين",
                description = "دليل فيديو خطوة بخطوة لمساعدة المبتدئين على فهم أساسيات Compose.",
                type = MediaType.VIDEO,
                url = "https://example.com/videos/compose-beginners",
                thumbnailUrl = null
            ),
            MediaRequest(
                id = "3",
                name = "محمد خالد",
                title = "شرح Kotlin Coroutines",
                description = "درس صوتي يشرح الكوروتينات والتزامن المهيكل في Kotlin.",
                type = MediaType.AUDIO,
                url = "https://example.com/audio/kotlin-coroutines",
                thumbnailUrl = R.drawable.jarir
            ),
            MediaRequest(
                id = "4",
                name = "ليلى حسن",
                title = "بناء واجهات مرنة",
                description = "تعلم كيفية بناء واجهات مستخدم مرنة وقابلة للتكيف في Compose.",
                type = MediaType.ARTICLES,
                url = "https://example.com/articles/responsive-layouts",
                thumbnailUrl = null
            ),
            MediaRequest(
                id = "5",
                name = "عمر يوسف",
                title = "إتقان الرسوم المتحركة في Compose",
                description = "شرح مفصل لواجهات برمجة التطبيقات الخاصة بالرسوم المتحركة في Jetpack Compose.",
                type = MediaType.VIDEO,
                url = "https://example.com/videos/compose-animations",
                thumbnailUrl = R.drawable.jarir
            ),
            MediaRequest(
                id = "6",
                name = "نور الدين",
                title = "إدارة الحالة في Compose",
                description = "مقالة واضحة حول إدارة حالة واجهة المستخدم ودمج ViewModel.",
                type = MediaType.ARTICLES,
                url = "https://example.com/articles/compose-state",
                thumbnailUrl = R.drawable.jarir
            ),
            MediaRequest(
                id = "7",
                name = "فاطمة عادل",
                title = "العمل مع Flows",
                description = "فهم Kotlin Flow وكيفية استخدامه بشكل فعال في تطبيقات أندرويد.",
                type = MediaType.AUDIO,
                url = "https://example.com/audio/kotlin-flow",
                thumbnailUrl = null
            ),
            MediaRequest(
                id = "8",
                name = "حسن محمود",
                title = "التنقل في Compose",
                description = "دليل كامل للتنقل في Jetpack Compose مع أمثلة عملية.",
                type = MediaType.VIDEO,
                url = "https://example.com/videos/compose-navigation",
                thumbnailUrl = null
            ),
            MediaRequest(
                id = "9",
                name = "ريم طه",
                title = "حقن التبعيات باستخدام Hilt",
                description = "استكشف Hilt وكيفية دمج حقن التبعيات في مشاريع Compose.",
                type = MediaType.ARTICLES,
                url = "https://example.com/articles/hilt-compose",
                thumbnailUrl = R.drawable.jarir
            ),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(dummyMedia, key = { _, item -> item.id }) { index, item ->
                if (index == 0) Spacer(modifier = Modifier.height(24.dp))
                LibraryRequestRow(item = item) // navController null for preview
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true, locale = "ar")
@Composable
fun LibraryScreenPreview() {
    LibraryScreenPreviewer()
}

@Composable
fun LibraryRequestRow(item: MediaRequest) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp), // optional spacing between rows
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Media Icon
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(R.color.filter_background)),
                contentAlignment = Alignment.Center
            ) {
                when (item.type) {
                    MediaType.ARTICLES -> Image(
                        painter = painterResource(item.thumbnailUrl?: R.drawable.ic_article),
                        contentDescription = "Article Icon"
                    )
                    MediaType.AUDIO -> Image(
                        painter = painterResource(item.thumbnailUrl?:R.drawable.ic_audio),
                        contentDescription = "Audio Icon"
                    )
                    MediaType.VIDEO -> Image(
                        painter = painterResource(item.thumbnailUrl?:R.drawable.ic_video),
                        contentDescription = "Video Icon"
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Text content
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontFamily = Alexandria,
                        color = colorResource(R.color.main_color_yankies),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = item.description,
                    style = TextStyle(
                        fontFamily = Alexandria,
                        color = colorResource(R.color.date_color),
                        fontSize = 11.sp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        text = "متوفر حتى:",
                        style = TextStyle(
                            fontFamily = Alexandria,
                            color = colorResource(R.color.date_color),
                            fontSize = 11.sp
                        )
                    )
                    Text(
                        text = " 5 ابريل 2025 ",
                        style = TextStyle(
                            fontFamily = Alexandria,
                            color = colorResource(R.color.main_color_yankies),
                            fontSize = 11.sp
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))

            when (item.type) {
                MediaType.ARTICLES -> return@Card
                else -> {
                    Box(
                        modifier = Modifier.size(28.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_play),
                            contentDescription = "Play Icon"
                        )
                    }
                }
            }
        }
    }
}

@Preview(locale = "ar")
@Composable
fun LibraryRequestRowPreview() {
    val sampleItem = MediaRequest(
        id = "8",
        name = "حسن محمود",
        title = "التنقل في Compose",
        description = "دليل كامل للتنقل في Jetpack Compose مع أمثلة عملية.",
        type = MediaType.VIDEO,
        url = "https://example.com/videos/compose-navigation",
        thumbnailUrl = null
    )
    LibraryRequestRow(item = sampleItem)
}

@Composable
fun MyLibraryHeader(
    navController: NavController,
    selectedFilter: MediaFilter,
    onFilterChange: (MediaFilter) -> Unit,
    onBackClick: (() -> Unit)? = null,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .padding(top = 13.dp)
    ) {

        HeaderWithBackButton(
            title = stringResource(R.string.requests_that_sended_to_you),
            onBackClick = { navController.popBackStack() },

        )
        LibraryFilterBar(
            selected = selectedFilter, onSelectedChange = onFilterChange
        )
        Spacer(modifier = Modifier.height(6.dp))
    }
}

@Composable
fun HeaderWithBackButton(
    title: String,
    onBackClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Back button
        if (onBackClick != null) {
            Image(
                painter = painterResource(R.drawable.ic_back__1_),
                contentDescription = "back button",
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { onBackClick() }
            )
        } else {
            Spacer(modifier = Modifier.width(48.dp)) // Keeps title centered if no back button
        }

        // Title
        Text(
            text = title,
            style = TextStyle(
                color = colorResource(R.color.main_color_yankies),
                fontSize = 16.sp,
                fontFamily = Alexandria
            )
        )

        Spacer(modifier = Modifier.width(48.dp)) // Balance the row
    }
}



@Preview(showBackground = true,locale = "ar")
@Composable
fun MyLibraryHeaderPreview() {
    MyLibraryHeader(
        navController = NavController(LocalContext.current), // null for preview
        selectedFilter = MediaFilter.ARTICLES, onFilterChange = {}, // dummy lambda
        onBackClick = null,
    )
}

@Composable
fun LibraryFilterBarPreview() {
    LibraryFilterBar(
        selected = MediaFilter.AUDIO, onSelectedChange = {})
}

@Composable
fun LibraryFilterBar(
    selected: MediaFilter,
    onSelectedChange: (MediaFilter) -> Unit,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp)) // هنا نعمل الحواف مستديرة
            .background(colorResource(R.color.filter_background))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        LibraryFilterChipItem(
            option = MediaFilter.ARTICLES,
            isSelected = selected == MediaFilter.ARTICLES,
            text = "مقالات"
        ) { onSelectedChange(it) }

        LibraryFilterChipItem(
            option = MediaFilter.AUDIO,
            isSelected = selected == MediaFilter.AUDIO,
            text = "ملفات صوتية"
        ) { onSelectedChange(it) }

        LibraryFilterChipItem(
            option = MediaFilter.VIDEO, isSelected = selected == MediaFilter.VIDEO, text = "فيديو"
        ) { onSelectedChange(it) }

    }
}

@Composable
private fun LibraryFilterChipItem(
    option: MediaFilter, isSelected: Boolean, text: String, onClick: (MediaFilter) -> Unit
) {
    val bgColor = if (isSelected) Color.White else Color.Transparent
    val textColor =
        if (isSelected) colorResource(R.color.company_color) else colorResource(R.color.main_color_yankies)

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bgColor)
            .clickable { onClick(option) }
            .padding(horizontal = 12.dp, vertical = 8.dp)) {
        Text(
            text = text, style = TextStyle(
                color = textColor,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                fontFamily = Alexandria
            )
        )
    }
}

