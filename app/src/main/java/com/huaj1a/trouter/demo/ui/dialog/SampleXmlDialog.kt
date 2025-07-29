package com.huaj1a.trouter.demo.ui.dialog

import android.content.Context
import android.os.Bundle
import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.demo.databinding.SampleXmlDialogBinding
import com.huaj1a.trouter.ui.BaseDialog

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/29
 */
@Route(
    path = SampleXmlDialogPath,
    height = 0.5f,
    width = 0.75f
)
class SampleXmlDialog(
    context: Context
): BaseDialog(context) {

    private lateinit var binding: SampleXmlDialogBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SampleXmlDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.ivClose.setOnClickListener { 
            dismiss()
        }
    }
}

const val SampleXmlDialogPath = "/dialog/SampleXmlDialog"