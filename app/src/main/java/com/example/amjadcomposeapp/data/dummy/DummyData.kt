package com.example.amjadcomposeapp.data.dummy

import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.AssessmentCardModel
import com.example.amjadcomposeapp.domain.models.BannerImageModel
import com.example.amjadcomposeapp.domain.models.BottomSheetItem
import com.example.amjadcomposeapp.domain.models.EmojisModel
import com.example.amjadcomposeapp.domain.models.HrRequestModel
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.models.MediaType
import com.example.amjadcomposeapp.domain.models.MostUsedOfferModel
import com.example.amjadcomposeapp.domain.models.NewsModel
import com.example.amjadcomposeapp.domain.models.OffersCategoryModel
import com.example.amjadcomposeapp.domain.models.RequestItem
import com.example.amjadcomposeapp.domain.models.RequestStatus
import com.example.amjadcomposeapp.domain.models.SurveysTabsModel
import com.example.amjadcomposeapp.ui.theme.HrRequestAttendance
import com.example.amjadcomposeapp.ui.theme.HrRequestCredits
import com.example.amjadcomposeapp.ui.theme.HrRequestDocuments
import com.example.amjadcomposeapp.ui.theme.HrRequestHearing
import com.example.amjadcomposeapp.ui.theme.HrRequestPermission
import com.example.amjadcomposeapp.ui.theme.HrRequestRest
import com.example.amjadcomposeapp.ui.theme.HrRequestVows
import com.example.amjadcomposeapp.ui.theme.HrRequestWorkFromHome

object DummyData {
    val bannerList = listOf(
        BannerImageModel(
            img = R.drawable.banner_img
        ), BannerImageModel(
            img = R.drawable.banner_img
        ), BannerImageModel(
            img = R.drawable.banner_img
        )
    )


    val assessmentsList = listOf(
        AssessmentCardModel(
            img = R.drawable.illu_assessment_ocd,
            title = "الوسواس القهري",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_depression,
            title = "الاكتئاب",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_self_assessment_of_job_performance,
            title = "تقييم الأداء الوظيفي الذاتي",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_change_management_readiness,
            title = "الجاهزية لإدارة التغيير",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_emotional_intelligence,
            title = "الذكاء العاطفي",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_creative_thinking_and_innovation,
            title = "التفكير الإبداعي والابتكار",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_general_mental_health,
            title = "الصحة النفسية العامة",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_innovation_scale,
            title = "مقياس الابتكار",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_job_burnout,
            title = "الاحتراق الوظيفي",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_job_satisfaction,
            title = "الرضا الوظيفي",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_life_meaning,
            title = "معنى الحياة",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_life_satisfaction,
            title = "الرضا عن الحياة",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_manager_readiness,
            title = "جاهزية المدير",
            questions = 9,
            minutes = 2
        ), AssessmentCardModel(
            img = R.drawable.illu_assessment_work_stress,
            title = "ضغوط العمل",
            questions = 9,
            minutes = 2
        )

    )

    val HrRequestList = listOf(

        HrRequestModel(
            color = HrRequestAttendance,
            imgUrl = R.drawable.ic_we_hear_you,
            name = "سجل حضوري"
        ),
        HrRequestModel(
            color = HrRequestCredits,
            imgUrl = R.drawable.ic_we_hear_you,
            name = "اعتماداتي"
        ),
        HrRequestModel(
            color = HrRequestRest,
            imgUrl = R.drawable.ic_we_hear_you, name = "اجازاتي"
        ),
        HrRequestModel(
            color = HrRequestWorkFromHome,
            imgUrl = R.drawable.ic_we_hear_you,
            name = "عمل عن بعد"
        ),
        HrRequestModel(
            color = HrRequestDocuments,
            imgUrl = R.drawable.ic_we_hear_you,
            name = "مستنداتي"
        ),
        HrRequestModel(
            color = HrRequestVows,
            imgUrl = R.drawable.ic_we_hear_you, name = "عهداتي"
        ),
        HrRequestModel(
            color = HrRequestPermission,
            imgUrl = R.drawable.ic_we_hear_you,
            name = "اذاناتي"
        ),
        HrRequestModel(
            color = HrRequestHearing,
            imgUrl = R.drawable.ic_we_hear_you, name = "نسمعك"
        ),

        )

    val mostUsedOfferList = listOf(

        MostUsedOfferModel(
            mainBannerImg = R.drawable.offer_image,
            logoImg = R.drawable.jarir,
            title = "خصم 25% على اجمالي ا...",
            name = "مكتبة جرير"
        ),
        MostUsedOfferModel(
            mainBannerImg = R.drawable.offer_image1,
            logoImg = R.drawable.jarir,
            title = "عروض أسواق عبد الله ال...",
            name = "أسواق عبد الله العثيم"
        ),
        MostUsedOfferModel(
            mainBannerImg = R.drawable.offer_image2,
            logoImg = R.drawable.helen,
            title = "اشتر قهوة و الكروسون",
            name = "هلن للمخبوزات"
        ),

        )


    val newsList = listOf(
        NewsModel(
            img = R.drawable.offer_image,
            title = "كيف استفيد من برنامج أمجاد...",
            views = 120,
        ), NewsModel(
            img = R.drawable.offer_image,
            title = "ما هو الهليبيلي...",
            views = 189,
        ), NewsModel(
            img = R.drawable.offer_image,
            title = "كيف استفيد من الشعبولي...",
            views = 987,
        )
    )


    val offerCategoryList = listOf(
        OffersCategoryModel(
            img = R.drawable.ic_restaurants, title = "مطاعم"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_fashion, title = "الازياء"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_electronics, title = "الالكترونيات"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_beauty, title = "الجمال"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_perfume_fragrance, title = "العطور"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_cars, title = "سيارات"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_pharmacy, title = "صيدليات"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_jewelry, title = "مجوهرات"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_delivery, title = "توصيل"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_gifts, title = "هدايا"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_grocery, title = "مواد غذائيه"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_electronics__1_, title = "الالكترونيات"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_education_training, title = "التعليم"
        ),
        OffersCategoryModel(
            img = R.drawable.ic_hobbies, title = "الهوايات"
        ),

        )


    val surveyTabsList = listOf(

        SurveysTabsModel(
            title = "اخبار البلد", number = 12
        ),
        SurveysTabsModel(
            title = "اخبار البلد", number = 12
        ),
        SurveysTabsModel(
            title = "اخبار البلد", number = 12
        ),
        )


    val bottomSheetItems = listOf<BottomSheetItem>(
        BottomSheetItem(
            icon = R.drawable.consultation_family_ic, label = "أسرية"
        ), BottomSheetItem(
            icon = R.drawable.consultation_religious_ic, label = "دينية"
        ), BottomSheetItem(
            icon = R.drawable.consultation_sports_ic, label = "رياضية"
        ), BottomSheetItem(
            icon = R.drawable.consultation_financial_ic, label = "مالية"
        ), BottomSheetItem(
            icon = R.drawable.consultation_social_ic, label = "مجتمعية"
        ), BottomSheetItem(
            icon = R.drawable.consultation_psychological_ic, label = "نفسية"
        ), BottomSheetItem(
            icon = R.drawable.consultation_career_ic, label = "مهنية"
        )
    )
    val emojisList = listOf<EmojisModel>(
        EmojisModel(
            emoji = R.drawable.emoji_happy, name = "سعيد"
        ),
        EmojisModel(
            emoji = R.drawable.emoji_sad, name = "حزين"
        ),
        EmojisModel(
            emoji = R.drawable.emoji_enthusiastic, name = "متحمس"
        ),
        EmojisModel(
            emoji = R.drawable.emoji_exhausted, name = "مرهق"
        ),
        EmojisModel(
            emoji = R.drawable.emoji_angry, name = "غاضب"
        ),
        EmojisModel(
            emoji = R.drawable.emoji_anxious, name = "متوتر"
        ),

        )

val RequestItems=listOf(
    RequestItem(id = "1", title = "طلب #1",    name = "نورة إبراهيم", description = "3 نوفمبر 2024 - 12:47 م", status = RequestStatus.ACCEPTED),
    RequestItem(id = "2", title = "طلب #2",    name = "سارة العتيبي", description = "4 نوفمبر 2024 - 09:15 ص", status = RequestStatus.PENDING),
    RequestItem(id = "3", title = "طلب #3",    name = "ليان الحربي", description = "4 نوفمبر 2024 - 02:30 م", status = RequestStatus.REJECTED),
    RequestItem(id = "4", title = "طلب #4",    name = "أمل القحطاني", description = "5 نوفمبر 2024 - 10:05 ص", status = RequestStatus.ACCEPTED),
    RequestItem(id = "5", title = "طلب #5",    name = "نوف السبيعي", description = "5 نوفمبر 2024 - 03:22 م", status = RequestStatus.PENDING),
    RequestItem(id = "6", title = "طلب #6",    name = "ريم العنزي", description = "6 نوفمبر 2024 - 01:10 م", status = RequestStatus.ACCEPTED),
    RequestItem(id = "7", title = "طلب #7",    name = "منيرة الدوسري", description = "6 نوفمبر 2024 - 05:45 م", status = RequestStatus.PENDING),
    RequestItem(id = "8", title = "طلب #8",    name = "علياء المطيري", description = "7 نوفمبر 2024 - 08:50 ص", status = RequestStatus.REJECTED),
    RequestItem(id = "9", title = "طلب #9",    name = "شهد الحارثي", description = "7 نوفمبر 2024 - 11:40 ص", status = RequestStatus.ACCEPTED),
    RequestItem(id = "10", title = "طلب #10", name = "مي الغامدي", description = "8 نوفمبر 2024 - 04:15 م", status = RequestStatus.PENDING),
    RequestItem(id = "11", title = "طلب #11", name = "نورة المطيري", description = "8 نوفمبر 2024 - 06:30 م", status = RequestStatus.REJECTED),
    RequestItem(id = "12", title = "طلب #12", name = "جود السبيعي", description = "9 نوفمبر 2024 - 09:00 ص", status = RequestStatus.ACCEPTED),
    RequestItem(id = "13", title = "طلب #13", name = "هيفاء الزهراني", description = "9 نوفمبر 2024 - 12:15 م", status = RequestStatus.PENDING),
    RequestItem(id = "14", title = "طلب #14", name = "لمى الشهراني", description = "10 نوفمبر 2024 - 10:40 ص", status = RequestStatus.REJECTED),
    RequestItem(id = "15", title = "طلب #15", name = "العنود الرشيد", description = "10 نوفمبر 2024 - 01:55 م", status = RequestStatus.ACCEPTED),
    RequestItem(id = "16", title = "طلب #16", name = "فرح الحربي", description = "11 نوفمبر 2024 - 03:30 م", status = RequestStatus.PENDING),
    RequestItem(id = "17", title = "طلب #17", name = "دانة القحطاني", description = "11 نوفمبر 2024 - 07:45 م", status = RequestStatus.ACCEPTED),
    RequestItem(id = "18", title = "طلب #18", name = "رغد السبيعي", description = "12 نوفمبر 2024 - 09:10 ص", status = RequestStatus.REJECTED),
    RequestItem(id = "19", title = "طلب #19", name = "عهود العتيبي", description = "12 نوفمبر 2024 - 02:20 م", status = RequestStatus.ACCEPTED),
    RequestItem(id = "20", title = "طلب #20", name = "جنى الشمري", description = "13 نوفمبر 2024 - 05:00 م", status = RequestStatus.PENDING)
)
    val mediaRequests = listOf(
        MediaRequest(
            id = "1",
            name = "أحمد ديردري",
            title = "مقدمة في Compose",
            description = "تعلم أساسيات Jetpack Compose وكيفية بناء واجهات مستخدم حديثة لأندرويد.تعلم أساسيات Jetpack Compose وكيفية بناء واجهات مستخدم حديثة لأندرويد.تعلم أساسيات Jetpack Compose وكيفية بناء واجهات مستخدم حديثة لأندرويد.تعلم أساسيات Jetpack Compose وكيفية بناء واجهات مستخدم حديثة لأندرويد.تعلم أساسيات Jetpack Compose وكيفية بناء واجهات مستخدم حديثة لأندرويد.",
            type = MediaType.ARTICLES,
            url = "الباذنجان هو من الخضروات المفيدة جدًا للصحة، يحتوي على مضادات أكسدة قوية تساعد على حماية الخلايا وتحسين صحة القلب وخفض الكولسترول. كما أنه يحتوي على الألياف التي تحسن الهضم وتحافظ على الوزن المثالي. الباذنجان غني بالفيتامينات والمعادن مثل فيتامين C وK والبوتاسيوم والمغنيسيوم، مما يدعم الجهاز المناعي ويقوي العظام. يُنصح بتناوله مشويًا أو مسلوقًا للحصول على أقصى فائدة من العناصر الغذائية.",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "2",
            name = "سارة علي",
            title = "Compose للمبتدئين",
            description = "دليل فيديو خطوة بخطوة لمساعدة المبتدئين على فهم أساسيات Compose.دليل فيديو خطوة بخطوة لمساعدة المبتدئين على فهم أساسيات Compose.دليل فيديو خطوة بخطوة لمساعدة المبتدئين على فهم أساسيات Compose.دليل فيديو خطوة بخطوة لمساعدة المبتدئين على فهم أساسيات Compose.دليل فيديو خطوة بخطوة لمساعدة المبتدئين على فهم أساسيات Compose.",
            type = MediaType.VIDEO,
            url = "android.resource://com.example.amjadcomposeapp/raw/my_video",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "3",
            name = "محمد خالد",
            title = "شرح Kotlin Coroutines",
            description = "درس صوتي يشرح الكوروتينات والتزامن المهيكل في Kotlin.درس صوتي يشرح الكوروتينات والتزامن المهيكل في Kotlin.درس صوتي يشرح الكوروتينات والتزامن المهيكل في Kotlin.درس صوتي يشرح الكوروتينات والتزامن المهيكل في Kotlin.درس صوتي يشرح الكوروتينات والتزامن المهيكل في Kotlin. ",
            type = MediaType.AUDIO,
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "4",
            name = "ليلى حسن",
            title = "بناء واجهات مرنة",
            description = "تعلم كيفية بناء واجهات مستخدم مرنة وقابلة للتكيف في Compose.",
            type = MediaType.ARTICLES,
            url = "الباذنجان يحتوي على مركبات تساعد في خفض ضغط الدم وتحسين صحة القلب. كما يساهم في الوقاية من مرض السكري وتحسين مستويات السكر في الدم. الباذنجان منخفض السعرات وغني بالألياف، ما يجعله خيارًا ممتازًا للأشخاص الذين يسعون للتحكم في الوزن. تناوله بانتظام يعزز صحة الجهاز الهضمي ويقلل من التهابات الجسم.",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "5",
            name = "عمر يوسف",
            title = "إتقان الرسوم المتحركة في Compose",
            description = "شرح مفصل لواجهات برمجة التطبيقات الخاصة بالرسوم المتحركة في Jetpack Compose.",
            type = MediaType.VIDEO,
            url = "android.resource://com.example.amjadcomposeapp/raw/my_video",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "6",
            name = "نور الدين",
            title = "إدارة الحالة في Compose",
            description = "مقالة واضحة حول إدارة حالة واجهة المستخدم ودمج ViewModel.",
            type = MediaType.ARTICLES,
            url = "الباذنجان مفيد لصحة الدماغ لأنه يحتوي على مركبات الفلافونويد التي تحمي الخلايا العصبية. كما أنه يدعم صحة العيون ويحسن وظائف الجهاز المناعي. يمكن إدراجه في النظام الغذائي بعدة طرق مثل الشوي، الطهي بالبخار، أو إضافته للسلطات، ليصبح وجبة صحية ومتنوعة.",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "7",
            name = "فاطمة عادل",
            title = "العمل مع Flows",
            description = "فهم Kotlin Flow وكيفية استخدامه بشكل فعال في تطبيقات أندرويد.",
            type = MediaType.AUDIO,
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "8",
            name = "حسن محمود",
            title = "التنقل في Compose",
            description = "دليل كامل للتنقل في Jetpack Compose مع أمثلة عملية.",
            type = MediaType.VIDEO,
            url = "android.resource://com.example.amjadcomposeapp/raw/my_video",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "9",
            name = "ريم طه",
            title = "حقن التبعيات باستخدام Hilt",
            description = "استكشف Hilt وكيفية دمج حقن التبعيات في مشاريع Compose.",
            type = MediaType.ARTICLES,
            url = "الباذنجان غني بمركبات تحمي الكبد وتساعد في إزالة السموم من الجسم. كما يساعد في تحسين الهضم ويقلل من مشاكل القولون. إدراجه في النظام الغذائي يساعد على الشعور بالشبع ويقلل من الرغبة في تناول الوجبات السريعة.",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "10",
            name = "خالد سمير",
            title = "فهم ViewModels",
            description = "سلسلة صوتية تناقش ViewModels ودورة الحياة وحفظ الحالة.",
            type = MediaType.AUDIO,
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "11",
            name = "أمل سعيد",
            title = "تصميم واجهات مستخدم تفاعلية",
            description = "مقالة توضح كيفية إنشاء واجهات مستخدم تفاعلية باستخدام Compose.",
            type = MediaType.ARTICLES,
            url = "الباذنجان يحتوي على مركبات مضادة للالتهابات تساعد في حماية القلب والأوعية الدموية. كما أنه يساهم في تقوية جهاز المناعة والوقاية من الأمراض المزمنة عند تناوله بانتظام.",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "12",
            name = "محمود عادل",
            title = "تحسين الأداء في Compose",
            description = "درس فيديو يشرح أفضل الممارسات لتحسين أداء التطبيقات.",
            type = MediaType.VIDEO,
            url = "android.resource://com.example.amjadcomposeapp/raw/my_video",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "13",
            name = "هالة شريف",
            title = "معالجة البيانات باستخدام Kotlin",
            description = "سلسلة صوتية عن معالجة البيانات وإدارة الحالات.",
            type = MediaType.AUDIO,
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "14",
            name = "ياسر فهمي",
            title = "تخصيص الثيمات في Compose",
            description = "مقالة تشرح كيفية تخصيص الألوان والخطوط في تطبيقك.",
            type = MediaType.ARTICLES,
            url = "الباذنجان يحتوي على مضادات أكسدة تساعد في الوقاية من السرطان وتعزز صحة الجهاز المناعي. يمكن استخدامه في الوجبات اليومية بطرق مختلفة مثل الشوي والطهي بالبخار.",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "15",
            name = "ندى كامل",
            title = "إضافة التأثيرات الحركية",
            description = "فيديو يوضح كيفية استخدام الرسوم المتحركة لجذب المستخدم.",
            type = MediaType.VIDEO,
            url = "android.resource://com.example.amjadcomposeapp/raw/my_video",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "16",
            name = "عمرو صلاح",
            title = "التعامل مع الأحداث في Compose",
            description = "درس صوتي يشرح طرق التعامل مع نقرات المستخدم والأحداث الأخرى.",
            type = MediaType.AUDIO,
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "17",
            name = "سارة نجيب",
            title = "إنشاء نماذج تفاعلية",
            description = "مقالة حول إنشاء واجهات تحتوي على نماذج تفاعلية مع Compose.",
            type = MediaType.ARTICLES,
            url = "الباذنجان غني بالفيتامينات والمعادن الأساسية التي تدعم صحة العظام والجهاز العصبي. كما أنه منخفض السعرات وغني بالألياف، مما يجعله مثاليًا للحمية الغذائية.",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "18",
            name = "أحمد مصطفى",
            title = "تعلم الرسوم المتحركة الأساسية",
            description = "فيديو يشرح أساسيات الرسوم المتحركة في Compose.",
            type = MediaType.VIDEO,
            url = "android.resource://com.example.amjadcomposeapp/raw/my_video",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "19",
            name = "هند سامي",
            title = "تطبيقات صوتية متقدمة",
            description = "سلسلة صوتية تشرح التعامل مع الصوتيات في التطبيقات.",
            type = MediaType.AUDIO,
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "20",
            name = "خالد إبراهيم",
            title = "إدارة التنقل بين الشاشات",
            description = "مقالة حول أفضل الممارسات للتنقل بين الشاشات في Compose.",
            type = MediaType.ARTICLES,
            url = "الباذنجان يساهم في تحسين صحة الجهاز الهضمي وتقليل مشاكل الانتفاخ والإمساك. إدراجه بانتظام في النظام الغذائي يعزز من الشعور بالشبع ويقلل الرغبة في تناول الوجبات غير الصحية.",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "21",
            name = "ليلى سامح",
            title = "استخدام مكتبات Compose الخارجية",
            description = "فيديو يشرح كيفية دمج مكتبات طرف ثالث بسهولة.",
            type = MediaType.VIDEO,
            url = "android.resource://com.example.amjadcomposeapp/raw/my_video",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "22",
            name = "محمد عادل",
            title = "تدفق البيانات مع Flow",
            description = "درس صوتي يوضح كيفية استخدام Kotlin Flow لإدارة البيانات.",
            type = MediaType.AUDIO,
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "23",
            name = "ريم عبد الله",
            title = "التخصيص المتقدم للواجهة",
            description = "مقالة تشرح كيفية تخصيص الواجهة بشكل احترافي.",
            type = MediaType.ARTICLES,
            url = "الباذنجان مفيد للبشرة والشعر لأنه غني بمضادات الأكسدة التي تحمي من التجاعيد وتقلل من تلف الشعر. إدراجه بانتظام في النظام الغذائي يحسن الصحة العامة ويقوي المناعة.",
            thumbnailUrl = null
        ),
        MediaRequest(
            id = "24",
            name = "أحمد سعيد",
            title = "تحريك عناصر الواجهة",
            description = "فيديو يوضح كيفية تحريك عناصر واجهة المستخدم بسهولة.",
            type = MediaType.VIDEO,
            url = "android.resource://com.example.amjadcomposeapp/raw/my_video",
            thumbnailUrl = R.drawable.jarir
        ),
        MediaRequest(
            id = "25",
            name = "هالة محمود",
            title = "إدارة الحالة المتقدمة",
            description = "سلسلة صوتية حول تقنيات متقدمة لإدارة الحالة في Compose.",
            type = MediaType.AUDIO,
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            thumbnailUrl = null
        )
    )


}


