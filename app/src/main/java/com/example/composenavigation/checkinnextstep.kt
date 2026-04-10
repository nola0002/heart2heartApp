package com.example.composenavigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import kotlin.math.roundToInt

// ─── DATA ───────────────────────────────────────────────

data class CheckinOption(val title: String, val message: String)

// De 5 hjerte-valg
val options = listOf(
    CheckinOption("Made it home",   "(Your name) made it home safely"),
    CheckinOption("On my way home", "(Your name) is on the way home"),
    CheckinOption("Location share", "sharing your location for 30 minutes"),
    CheckinOption("Custom",         "Custom message"),
    CheckinOption("Help",           "(Your name) needs help")
)

// Pentagon-placering: 72° mellem hvert hjerte
val angles = listOf(0f,    72f,   144f,  -144f,  -72f)
val xPos   = listOf(0.dp,  88.dp, 54.dp, (-54).dp, (-88).dp)
val yPos   = listOf((-95).dp, (-28).dp, 76.dp, 76.dp, (-28).dp)

// ─── HJERTEFORM ─────────────────────────────────────────

class HeartShape : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val (w, h) = size.width to size.height
        val path = Path().apply {
            moveTo(w/2f, h/5f)
            cubicTo(5*w/14f, 0f,     0f,       h/15f,  w/28f,    2*h/5f)
            cubicTo(w/14f,   2*h/3f, 3*w/7f,   5*h/6f, w/2f,     h     )
            cubicTo(4*w/7f,  5*h/6f, 13*w/14f, 2*h/3f, 27*w/28f, 2*h/5f)
            cubicTo(w,       h/15f,  9*w/14f,  0f,     w/2f,     h/5f  )
            close()
        }
        return Outline.Generic(path)
    }
}

// ─── HOVED-SKÆRM ────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Checkinnextstep(navController: NavController) {

    var selectedIndex by remember { mutableStateOf(0) }
    var totalRotation by remember { mutableFloatStateOf(0f) }
    val animatedRotation by animateFloatAsState(
        targetValue = totalRotation,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "rotation"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Check-in next step") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Tilbage")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .safeDrawingPadding()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Text("Check-in")

            // Blomsten — roterer som én enhed
            Box(
                modifier = Modifier
                    .size(320.dp, 360.dp)
                    .rotate(animatedRotation),
                contentAlignment = Alignment.Center
            ) {
                options.forEachIndexed { index, option ->
                    HeartPetalButton(
                        text           = option.title,
                        isSelected     = selectedIndex == index,
                        x              = xPos[index],
                        y              = yPos[index],
                        petalRotation  = angles[index],
                        flowerRotation = animatedRotation,
                        onClick = {
                            // Beregn korteste vej og roter blomsten
                            var delta = angles[index] - angles[selectedIndex]
                            if (delta > 180f)  delta -= 360f
                            if (delta < -180f) delta += 360f
                            totalRotation -= delta
                            selectedIndex = index
                        }
                    )
                }
            }

            // Beskeden under blomsten — animerer ved skift
            AnimatedContent(
                targetState = options[selectedIndex].message,
                transitionSpec = {
                    slideInHorizontally { it / 3 } + fadeIn() togetherWith
                            slideOutHorizontally { -it / 3 } + fadeOut()
                },
                label = "message"
            ) { message ->
                Text(message, textAlign = TextAlign.Center, color = Color.Gray)
            }

            SwipeToConfirmButton(onConfirmed = { navController.popBackStack() })
        }
    }
}

// ─── SWIPE KNAP ─────────────────────────────────────────

@Composable
fun SwipeToConfirmButton(onConfirmed: () -> Unit) {
    val thumbSize   = 56.dp
    val thumbSizePx = with(LocalDensity.current) { thumbSize.toPx() }

    var trackWidth by remember { mutableFloatStateOf(0f) }
    var dragOffset by remember { mutableFloatStateOf(0f) }

    val maxDrag   = (trackWidth - thumbSizePx - 8f).coerceAtLeast(0f)
    val progress  = if (maxDrag > 0f) dragOffset / maxDrag else 0f
    val textAlpha = (1f - progress * 2f).coerceIn(0f, 1f)

    val animatedOffset by animateFloatAsState(
        targetValue = dragOffset,
        animationSpec = tween(300),
        label = "thumb"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(50))
            .background(Color(0xFFFF1493))
            .onSizeChanged { trackWidth = it.width.toFloat() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Check in",
            color = Color.White.copy(alpha = textAlpha),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        // Den hvide cirkel man swiper
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 4.dp)
                .offset { IntOffset(animatedOffset.roundToInt(), 0) }
                .size(thumbSize)
                .clip(CircleShape)
                .background(Color.White)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        dragOffset = (dragOffset + delta).coerceIn(0f, maxDrag)
                    },
                    onDragStopped = {
                        if (progress >= 0.7f) { onConfirmed() } else { dragOffset = 0f }
                    }
                )
        )
    }
}

// ─── HJERTE KNAP ────────────────────────────────────────

@Composable
fun HeartPetalButton(
    text: String,
    isSelected: Boolean,
    x: Dp, y: Dp,
    petalRotation: Float,
    flowerRotation: Float,
    onClick: () -> Unit
) {
    Surface(
        color           = if (isSelected) Color(0xFFFF1493) else Color(0xFFFF69B4),
        shadowElevation = 8.dp,
        shape           = HeartShape(),
        modifier        = Modifier
            .offset(x = x, y = y)
            .rotate(petalRotation)
            .size(130.dp, 140.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .rotate(-(flowerRotation + petalRotation)),
            contentAlignment = Alignment.Center
        ) {
            Text(text, color = Color.White, textAlign = TextAlign.Center)
        }
    }
}