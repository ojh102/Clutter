package com.github.ojh.example.clutter.di

import android.app.Application
import com.github.ojh.example.clutter.ClutterApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: ClutterApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}