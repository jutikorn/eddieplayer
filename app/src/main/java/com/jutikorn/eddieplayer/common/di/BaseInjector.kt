package com.jutikorn.eddieplayer.common.di

interface BaseInjector<out T : Component> {

    val COMPONENTS: T
}