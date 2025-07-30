package com.huaj1a.trouter.demo.ui.dialog.navigation

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.savedstate.SavedState
import com.huaj1a.trouter.demo.R
import com.huaj1a.trouter.route.TRouterBundle
import com.huaj1a.trouter.ui.BaseDialog
import java.util.Stack

/**
 * Description: from VenusDesk
 *
 * @Author: huaj1a
 * @Date: 2025/7/29
 */
abstract class BaseNavigationDialog(
    context: Context,
    bundle: TRouterBundle? = null,
): BaseDialog(context, bundle) {
    
    private var navId: Int? = null
    private var navStack: Stack<Int>? = null
    private var navController: NavController? = null
    private var onDestinationChangedListener: NavController.OnDestinationChangedListener? = null

    override fun onStart() {
        super.onStart()
        val ivClose = findViewById<ImageView>(R.id.iv_close)
        ivClose?.apply { 
            setOnClickListener { 
                dismiss()
            }
        }
    }
    
    protected fun addNavController(view: FragmentContainerView) {
        val ivBack = findViewById<ImageView>(R.id.iv_back)
        if (ivBack == null)
            return
        
        navId = view.id
        navStack = Stack()
        navController = view.findNavController()
        ivBack.setOnClickListener { navController?.popBackStack() }
        
        onDestinationChangedListener = object : NavController.OnDestinationChangedListener {
            @SuppressLint("RestrictedApi")
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: SavedState?,
            ) {
                /**
                 * Known issues:
                 * If the same fragment is opened twice, there may be a problem that needs to be resolved
                 */
                navStack?.apply {
                    if (!contains(destination.id)) {
                        push(destination.id)
                    } else if (peek() != destination.id) {
                        pop()
                    }

                    if (size >= 2) {
                        ivBack.visibility = View.VISIBLE
                    } else {
                        ivBack.visibility = View.GONE
                    }
                }
            }
        }
        navController?.addOnDestinationChangedListener(onDestinationChangedListener!!)
    }

    override fun dismiss() {
        super.dismiss()

        if (navController != null && onDestinationChangedListener != null) {
            navController?.removeOnDestinationChangedListener(onDestinationChangedListener!!)
            onDestinationChangedListener = null
            navController = null
        }
        navId?.let {
            /**
             * fragment attach activity
             * So when discarding, it is necessary to actively release the fragment, otherwise it will cause memory leak
             */
            val view = findViewById<FragmentContainerView>(it)
            view?.getFragment<Fragment>()?.let { fragment ->
                val transaction = fragment.parentFragmentManager.beginTransaction()
                transaction.remove(fragment)
                transaction.commitNow()
            }
        }
        
    }
    
}