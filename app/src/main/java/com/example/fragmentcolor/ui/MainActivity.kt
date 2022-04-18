package com.example.fragmentcolor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentcolor.databinding.ActivityMainBinding
import com.example.fragmentcolor.domain.ColorEntity
import com.example.fragmentcolor.ui.colorslist.ColorListFragment
import com.example.fragmentcolor.ui.colorviewer.ColorViewerFragment

class MainActivity : AppCompatActivity(), ColorListFragment.Controller {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val masterFragment: Fragment = ColorListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(binding.masterFragmentContainer.id, masterFragment)
                .commit()
        }
    }

    override fun openColorScreen(color: ColorEntity) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(
                binding.detailFragmentContainer.id,
                ColorViewerFragment.newInstance(color)
            )
            .commit()
    }
}