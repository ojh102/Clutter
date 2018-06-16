package com.github.ojh.example.clutter.di

import com.github.ojh.clutter.anotation.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideTestText(): String {
        return "test"
    }

}