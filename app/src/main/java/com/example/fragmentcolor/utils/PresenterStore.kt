package com.example.fragmentcolor.utils

import java.util.*

class PresenterStore {
    private val storage: MutableMap<String, BasePresenter> = WeakHashMap()

    fun savePresenter(presenter: BasePresenter) {
        storage[presenter.id] = presenter
    }

    fun getPresenter(id: String): BasePresenter? {
        return storage[id]
    }
}

interface BasePresenter {
    val id: String
}