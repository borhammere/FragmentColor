package com.example.fragmentcolor.data

import android.graphics.Color
import com.example.fragmentcolor.domain.ColorEntity
import com.example.fragmentcolor.domain.ColorsRepo
import java.util.*

class InMemoryColorRepoImpl : ColorsRepo {
    override fun getColors(): List<ColorEntity> {
        return listOf(
            ColorEntity(generateId(), "Blue", Color.BLUE),
            ColorEntity(generateId(), "Red", Color.RED),
            ColorEntity(generateId(), "Green", Color.GREEN),
            ColorEntity(generateId(), "Yellow", Color.YELLOW),
            ColorEntity(generateId(), "Black", Color.BLACK),
            ColorEntity(generateId(), "Cyan", Color.CYAN),
            ColorEntity(generateId(), "Magenta", Color.MAGENTA)
        )
    }

    private fun generateId() = UUID.randomUUID().toString()

}