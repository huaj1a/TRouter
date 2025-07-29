package com.huaj1a.trouter.demo.ui.page

import android.graphics.Point
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.huaj1a.trouter.R
import com.huaj1a.trouter.demo.ui.dialog.AlbumDialogPath
import com.huaj1a.trouter.demo.ui.dialog.BasicComposeDialogPath
import com.huaj1a.trouter.demo.ui.dialog.BundleDialog
import com.huaj1a.trouter.demo.ui.dialog.BundleDialogPath
import com.huaj1a.trouter.demo.ui.dialog.BundleTest
import com.huaj1a.trouter.demo.ui.dialog.CameraDialogPath
import com.huaj1a.trouter.demo.ui.dialog.SampleXmlDialogPath
import com.huaj1a.trouter.demo.ui.widget.TextButton
import com.huaj1a.trouter.route.TRouter
import com.huaj1a.trouter.route.TRouterPermissionListener
import com.huaj1a.trouter.route.ext.build
import com.huaj1a.trouter.route.ext.permissionListener
import com.huaj1a.trouter.route.ext.withAnimation
import com.huaj1a.trouter.route.ext.withBundle
import com.huaj1a.trouter.route.ext.withDoubleClick
import com.huaj1a.trouter.route.ext.withDragEnable
import com.huaj1a.trouter.route.ext.withModalType
import com.huaj1a.trouter.route.ext.withPosition
import com.huaj1a.trouter.window.ModalType

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
@Composable
fun HomePage() {
    val context = LocalContext.current
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            TextButton(
                text = "1.Modal"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withModalType(ModalType.MODAL)
                    .navigation()
            }

            TextButton(
                text = "2.Semi Model"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withModalType(ModalType.SEMI_MODAL)
                    .navigation()
            }

            TextButton(
                text = "3.None Modal"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withModalType(ModalType.NON_MODAL)
                    .navigation()
            }

            TextButton(
                text = "4.Position(0, 0)"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withPosition(Point(0, 0))
                    .navigation()
            }

            TextButton(
                text = "5.Position(100, 100)"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withPosition(Point(100, 100))
                    .navigation()
            }

            TextButton(
                text = "6.Position(400, 400)"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withPosition(Point(400, 400))
                    .navigation()
            }

            TextButton(
                text = "7.Position(0, 1000)"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withPosition(Point(0, 1000))
                    .navigation()
            }

            TextButton(
                text = "8.DragEnable(false)"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withDragEnable(false)
                    .navigation()
            }

            TextButton(
                text = "9.DoubleClick(false)"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withDoubleClick(false)
                    .navigation()
            }

            TextButton(
                text = "10.DragEnable(false) DoubleClick(false)"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withDragEnable(false)
                    .withDoubleClick(false)
                    .navigation()
            }

            TextButton(
                text = "11.Camera Permission"
            ) {
                TRouter.getInstance()
                    .build(CameraDialogPath)
                    .permissionListener(object : TRouterPermissionListener {
                        override fun onDenied(deniedList: List<String>) {
                            Toast.makeText(context, "check permission fail, [${deniedList.joinToString("|") }}]", Toast.LENGTH_SHORT).show()
                        }
                    })
                    .navigation()
            }

            TextButton(
                text = "11.Read Media Permission"
            ) {
                TRouter.getInstance()
                    .build(AlbumDialogPath)
                    .permissionListener(object : TRouterPermissionListener {
                        override fun onDenied(deniedList: List<String>) {
                            Toast.makeText(context, "check permission fail, [${deniedList.joinToString("|") }}]", Toast.LENGTH_SHORT).show()
                        }
                    })
                    .navigation()
            }

            TextButton(
                text = "12.Bundle"
            ) {
                TRouter.getInstance()
                    .build(BundleDialogPath)
                    .withBundle(BundleDialog.KEY_INT, 123456)
                    .withBundle(BundleDialog.KEY_FLOAT, 3.14159f)
                    .withBundle(BundleDialog.KEY_TIME, System.currentTimeMillis())
                    .withBundle(BundleDialog.KEY_STRING, "Hello TRouter")
                    .withBundle(BundleDialog.KEY_LIST_INT, listOf(1, 3, 5))
                    .withBundle(BundleDialog.KEY_LIST_STRING, listOf("apple", "banana", "orange"))
                    .withBundle(BundleDialog.KEY_OBJECT, 
                        BundleTest(654321, 
                            1.2345f, 
                            System.currentTimeMillis(), 
                            "Hello Android", 
                            listOf(2, 4, 6),
                            listOf("java", "kotlin", "c++")
                        ))
                    .navigation()
            }

            TextButton(
                text = "13.anim none"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withAnimation(R.style.TRouter_Anim_None)
                    .navigation()
            }

            TextButton(
                text = "14.anim fade"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withAnimation(R.style.TRouter_Anim_Fade)
                    .navigation()
            }

            TextButton(
                text = "15.anim slide horizontal"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withAnimation(R.style.TRouter_Anim_Slide_Horizontal)
                    .navigation()
            }

            TextButton(
                text = "16.anim slide horizontal reverse"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withAnimation(R.style.TRouter_Anim_Slide_Horizontal_Reverse)
                    .navigation()
            }

            TextButton(
                text = "17.anim slide vertical"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withAnimation(R.style.TRouter_Anim_Slide_Vertical)
                    .navigation()
            }

            TextButton(
                text = "18.anim slide vertical reverse"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withAnimation(R.style.TRouter_Anim_Slide_Vertical_Reverse)
                    .navigation()
            }

            TextButton(
                text = "19.anim custom"
            ) {
                TRouter.getInstance()
                    .build(BasicComposeDialogPath)
                    .withAnimation(com.huaj1a.trouter.demo.R.style.Demo_Custom_Anim)
                    .navigation()
            }

            TextButton(
                text = "20.xml"
            ) {
                TRouter.getInstance()
                    .build(SampleXmlDialogPath)
                    .navigation()
            }
        }
    }
}