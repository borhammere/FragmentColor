package com.example.fragmentcolor.domain

import com.example.fragmentcolor.domain.ColorEntity

interface ColorsRepo {
    // C_R_UD
    fun getColors(): List<ColorEntity>

}