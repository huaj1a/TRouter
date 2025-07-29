package com.huaj1a.trouter.demo.ui.dialog

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.demo.ui.theme.pink
import com.huaj1a.trouter.demo.ui.widget.CloseButton
import com.huaj1a.trouter.route.TRouterBundle
import com.huaj1a.trouter.ui.BaseComposeDialog

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
@Route(
    path = BundleDialogPath,
    height = 0.5f,
    width = 0.75f
)
class BundleDialog(
    context: Context,
    bundle: TRouterBundle
): BaseComposeDialog(context, bundle) {
    @Composable
    override fun ComposeContent() {
        val intValue by remember { mutableIntStateOf(bundle?.getInt(KEY_INT) ?: 0) }
        val floatValue by remember { mutableStateOf(bundle?.getFloat(KEY_FLOAT) ?: 0f) }
        val timeValue by remember { mutableStateOf(bundle?.getLong(KEY_TIME) ?: 0L) }
        val stringValue by remember { mutableStateOf(bundle?.getString(KEY_STRING) ?: "") }
        val intListValue by remember { mutableStateOf(bundle?.getList<Int>(KEY_LIST_INT) ?: listOf()) }
        val stringListValue by remember { mutableStateOf(bundle?.getList<String>(KEY_LIST_STRING) ?: listOf()) }
        val objectVale by remember { mutableStateOf(bundle?.getObject<BundleTest>(KEY_OBJECT)) }

        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = pink, shape = RoundedCornerShape(14.dp))
        ) {
            CloseButton { 
                dismiss()
            }
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "int: $intValue"
                )
                Text(
                    text = "float: $floatValue"
                )
                Text(
                    text = "long: $timeValue"
                )
                Text(
                    text = "string: $stringValue"
                )
                Text(
                    text = "int list: ${intListValue.toIntArray().contentToString()}"
                )
                Text(
                    text = "string list: ${stringListValue.joinToString(",")}"
                )
                Text(
                    text = "object: ${objectVale?.intValue}" +
                            "|${objectVale?.floatValue}" +
                            "|${objectVale?.longValue}" +
                            "|${objectVale?.stringValue}" +
                            "|${objectVale?.intList?.toIntArray().contentToString()}" +
                            "|${objectVale?.stringList?.joinToString(",")}"
                )
            }
        }
    }

    companion object {
        const val KEY_INT = "key_int"
        const val KEY_FLOAT = "key_float"
        const val KEY_TIME = "key_time"
        const val KEY_STRING = "key_string"
        
        const val KEY_LIST_STRING = "key_list_string"
        const val KEY_LIST_INT = "key_list_int"
        const val KEY_OBJECT = "key_object"
    }
}

const val BundleDialogPath = "/dialog/BundleDialog"

data class BundleTest(
    val intValue: Int,
    val floatValue: Float,
    val longValue: Long,
    val stringValue: String,
    val intList: List<Int>,
    val stringList: List<String>
)