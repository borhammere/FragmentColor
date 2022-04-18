package com.example.fragmentcolor.ui.colorviewer

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmentcolor.R
import com.example.fragmentcolor.databinding.FragmentColorViewerBinding
import com.example.fragmentcolor.domain.ColorEntity

class ColorViewerFragment : Fragment(R.layout.fragment_color_viewer) {
    private val binding by viewBinding(FragmentColorViewerBinding::class.java)

    companion object {
        private const val COLOR_ARGS_KEY = "COLOR_ARGS_KEY"
        fun newInstance(colorEntity: ColorEntity) = ColorViewerFragment().apply {
            arguments = Bundle()
            arguments?.putParcelable(COLOR_ARGS_KEY, colorEntity)
        }
    }

    private fun getColorFromArguments(): ColorEntity {
        return arguments?.getParcelable(COLOR_ARGS_KEY)
            ?: throw IllegalStateException("Забыли в аргументы положить цвет !!!")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = getColorFromArguments()
        binding.root.setBackgroundColor(color.color)
        binding.nameTextView.text = color.name
        binding.redValueEditText.setText(Color.red(color.color).toString())
        binding.greenValueEditText.setText(Color.green(color.color).toString())
        binding.blueValueEditText.setText(Color.blue(color.color).toString())
        binding.saveColorButton.setOnClickListener {
            binding.nameTextView.text =
                "${binding.redValueEditText.text} : ${binding.greenValueEditText.text} : ${binding.blueValueEditText.text} "
        }
    }
}