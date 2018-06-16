package com.github.ojh.example.clutter.di

import com.github.ojh.clutter.anotation.ActivityScope
import com.github.ojh.example.clutter.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}