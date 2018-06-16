package com.github.ojh.example.clutter.ui

import com.github.ojh.clutter.base.BaseViewModel
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable
import javax.inject.Inject

class MainViewModel {

    interface Inputs {
        fun onClickTest()
    }

    interface Outputs {
        fun clickTest(): Observable<Unit>
    }

    class ViewModel @Inject constructor() : BaseViewModel(), Inputs, Outputs {

        val inputs: Inputs = this
        val outputs: Outputs = this

        private val clickTestRelay = PublishRelay.create<Unit>()


        override fun onClickTest() {
            clickTestRelay.accept(Unit)
        }

        override fun clickTest(): Observable<Unit> {
            return clickTestRelay
        }
    }

}