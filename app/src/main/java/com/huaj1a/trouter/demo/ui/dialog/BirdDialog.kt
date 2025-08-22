package com.huaj1a.trouter.demo.ui.dialog

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.demo.R
import com.huaj1a.trouter.ui.BaseComposeModalDialog

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
@Route(
    path = BirdDialogPath,
    height = 0.2f,
    width = 0.5f
)
class BirdDialog(
    context: Context
): BaseComposeModalDialog(context) {
    @Composable
    override fun ComposeContent() {
        
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_bird))
        val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.fillMaxSize()
                    .scale(1.5f)
            )
        }
        
    }
}

const val BirdDialogPath = "/dialog/BirdDialog"