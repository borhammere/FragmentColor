package com.example.fragmentcolor

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentcolor.databinding.FragmentColorsListBinding

class ColorListFragment : Fragment(R.layout.fragment_colors_list) {
    private var _binding: FragmentColorsListBinding? = null
    private val binding: FragmentColorsListBinding
        get() = _binding!!

    private val colorsAdapter = ColorsAdapter()
    private val colorsRepo: ColorsRepo by lazy { app.colorsRepo }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentColorsListBinding.bind(view)
        initRecycler()
    }

    private fun initRecycler() {
        binding.colorsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = colorsAdapter
        }
        colorsAdapter.data = colorsRepo.getColors()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}