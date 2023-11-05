package com.example.composek.ui.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composek.viewmodel.TaskViewModel

@Composable
fun CircleRing(boxWidthDp: Int,vm:TaskViewModel= viewModel()) {

    val strokeWidth = 30f

    Canvas(modifier = Modifier
        .size(boxWidthDp.dp)
        .padding(8.dp)) {

        drawArc(
            Color(0, 0, 0, 15),
            startAngle = 160f, sweepAngle = 220f,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )

        drawArc(
            Color.White,
            startAngle = 160f, sweepAngle = vm.pointOfYearPercent,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )

    }
}


