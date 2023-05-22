package com.ssantano.project.common.android.ui.dialog.bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ssantano.project.common.android.extensions.setTextOrHide
import com.ssantano.project.databinding.DialogBasicBinding

class DefaultBottomDialog: BottomSheetDialogFragment() {

    companion object {
        private const val KEY_DESCRIPTION = "KEY_DESCRIPTION"
        private const val KEY_BUTTON_TEXT = "KEY_BUTTON_TEXT"

        fun newInstance(
            description: String,
            buttonText: String
        ): DefaultBottomDialog {
            val dialog = DefaultBottomDialog()
            val args = Bundle().apply {
                putString(KEY_DESCRIPTION, description)
                putString(KEY_BUTTON_TEXT, buttonText)
            }
            dialog.arguments = args
            return dialog
        }
    }

    private var _binding: DialogBasicBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogBasicBinding.inflate(inflater, container, false)

        binding.dialogBasicDescription.setTextOrHide(arguments?.getString(KEY_DESCRIPTION))
        binding.dialogBasicButton.setTextOrHide(arguments?.getString(KEY_BUTTON_TEXT))
        binding.dialogBasicButton.setOnClickListener { dismiss() }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}