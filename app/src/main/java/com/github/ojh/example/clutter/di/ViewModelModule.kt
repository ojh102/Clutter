package com.github.ojh.example.clutter.di

import android.arch.lifecycle.ViewModel
import com.github.ojh.clutter.anotation.ViewModelKey
import com.github.ojh.example.clutter.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.ViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel.ViewModel): ViewModel

}