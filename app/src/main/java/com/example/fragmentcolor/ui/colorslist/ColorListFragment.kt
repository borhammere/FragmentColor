package com.example.fragmentcolor.ui.colorslist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentcolor.R
import com.example.fragmentcolor.app
import com.example.fragmentcolor.databinding.FragmentColorsListBinding
import com.example.fragmentcolor.domain.ColorEntity
import com.example.fragmentcolor.domain.ColorsRepo
import com.example.fragmentcolor.utils.BasePresenter
import java.util.*

/**
 * Не забудь отнаследовать активити от контроллера
 */
class ColorListFragment : Fragment(R.layout.fragment_colors_list) {
    private var _binding: FragmentColorsListBinding? = null
    private val binding: FragmentColorsListBinding
        get() = _binding!!

    private lateinit var presenter: Presenter

    private val colorsAdapter = ColorsAdapter {
        controller.openColorScreen(it)
        presenter.currentColor = it
        binding.root.setBackgroundColor(it.color)
    }

    private val colorsRepo: ColorsRepo by lazy { app.colorsRepo }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity !is Controller) {
            throw IllegalStateException("Activity должна наследоваться от ColorListFragment.Controller")
        }
    }

    private val controller by lazy { activity as Controller }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentColorsListBinding.bind(view)

        if (savedInstanceState != null) {
            val presenterId = savedInstanceState.getString("presenter_id")!!
            presenter = app.presenterStore.getPresenter(presenterId) as Presenter
        } else {
            val id = UUID.randomUUID().toString()
            presenter = Presenter(id)
            app.presenterStore.savePresenter(presenter)
        }

        presenter.currentColor?.let {
            binding.root.setBackgroundColor(it.color)
        }
        initRecycler()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("presenter_id", presenter.id)
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

    interface Controller {
        fun openColorScreen(color: ColorEntity)
    }

}

class Presenter(override val id: String) : BasePresenter{
    var currentColor: ColorEntity? = null
}