package com.example.fragmentcolor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentcolor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val masterFragment: Fragment = ColorListFragment()
        supportFragmentManager
            .beginTransaction()
            .add(binding.masterFragmentContainer.id, masterFragment)
            .commit()
    }
}