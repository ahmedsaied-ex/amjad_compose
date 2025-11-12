package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun DashedBorderBox(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    strokeWidth: Dp = 2.dp,
    dashLength: Dp = 10.dp,
    cornerRadius: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.drawBehind {
            val stroke = Stroke(
                width = strokeWidth.toPx(), pathEffect = PathEffect.dashPathEffect(
                    floatArrayOf(dashLength.toPx(), dashLength.toPx()), 0f
                ), cap = StrokeCap.Round
            )

            drawRoundRect(
                color = color,
                size = size,
                style = stroke,
                cornerRadius = CornerRadius(
                    x = cornerRadius.toPx(), y = cornerRadius.toPx()
                )
            )
        }) {
        content()
    }
}