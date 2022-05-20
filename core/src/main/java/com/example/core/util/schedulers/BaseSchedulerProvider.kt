package com.example.core.util.schedulers

import io.reactivex.rxjava3.core.Scheduler


interface BaseSchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}