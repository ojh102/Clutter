package com.github.ojh.example.clutter.di

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.github.ojh.clutter.base.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AppModule {

    @Singleton
    @Binds
    abstract fun bindContext(application: Application): Context

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}