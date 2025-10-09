package com.example.composetry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.constrainHeight
import androidx.compose.ui.unit.constrainWidth
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetry.ui.theme.ComposeTryTheme

enum class Position {
    END, PARALLEL
}

class PositionParentData(
    val position: Position,
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?): Any? {
        return this@PositionParentData
    }
}

fun Modifier.position(position: Position) = this.then(PositionParentData(position))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
) {
//    MyColumn(
//        modifier = Modifier
//            .height(150.dp)
//            .background(Color.Gray)
//    ) {
//        Text("asdfasd")
//        Text("asdfasddddd")
//        Text("asdfasd")
//        Text("asdfasd")
//    }
    Timeline {
        Text("Task 1")
        Text("Task 2", modifier = Modifier.position(Position.PARALLEL))
        Text("Task 3")
        Text("Task 4")
        Text("Task 5", modifier = Modifier.position(Position.END))

        Text("Task 6")
        Text("Task 7", modifier = Modifier.position(Position.PARALLEL))
        Text("Task 8", modifier = Modifier.position(Position.PARALLEL))
        Text("Task 9")
        Text("Task 10")
    }
}

@Composable
fun MyColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val childConstraings = constraints.copy(minHeight = 0, minWidth = 0)
        val placebales = measurables.map { measurable ->
            measurable.measure(childConstraings)
        }
        layout(
            constraints.constrainWidth(placebales.maxOf { it.width }),
            constraints.constrainHeight(placebales.sumOf { it.height })
        ) {
            var y = 0
            placebales.forEach { placebale ->
                placebale.placeRelative(0, y)
                y += placebale.height
            }
        }
    }
}

@Composable
fun Timeline(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            var x = 0
            var y = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(x, y)
                val position = ((placeable as? Measurable)?.parentData as? PositionParentData)?.position
                when (position){
                    Position.END -> {
                        x = 0
                    }
                    Position.PARALLEL -> {
                    }
                    else -> {
                        x += placeable.width
                    }
                }
                y += placeable.height
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ComposeTryTheme {
        HomeScreen()
    }
}



