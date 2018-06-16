package com.github.ojh.example.clutter.ui

import android.os.Bundle
import android.widget.Toast
import com.github.ojh.clutter.base.BaseActivity
import com.github.ojh.example.clutter.R
import com.github.ojh.example.clutter.databinding.ActivityMainBinding
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel.ViewModel>() {

    @Inject
    lateinit var testText: String

    override fun getLayoutRes() = R.layout.activity_main
    override fun getViewModelClass() = MainViewModel.ViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.inputs = viewModel

        bind(
                viewModel.outputs.clickTest()
                        .subscribeBy(onNext = {
                            Toast.makeText(this, testText, Toast.LENGTH_SHORT).show()
                        })
        )

    }
}
