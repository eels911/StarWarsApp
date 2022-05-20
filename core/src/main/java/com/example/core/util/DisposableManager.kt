package com.example.core.util

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable


object DisposableManager {
    private val compositeDisposable = CompositeDisposable()

    fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun clear() {
        compositeDisposable.clear()
    }
}
