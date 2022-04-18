package com.example.fragmentcolor

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.fragmentcolor.data.InMemoryColorRepoImpl
import com.example.fragmentcolor.domain.ColorsRepo
import com.example.fragmentcolor.utils.PresenterStore

class App : Application() {
    val colorsRepo: ColorsRepo by lazy { InMemoryColorRepoImpl() }
    val presenterStore by lazy { PresenterStore() }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app