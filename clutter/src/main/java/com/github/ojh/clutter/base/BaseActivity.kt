package com.github.ojh.clutter.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var binding: VB
    lateinit var viewModel: VM

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun getViewModelClass(): Class<VM>

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())

        viewModel.let {
            if (it is BaseViewModel) {
                it.intent(intent)
            }
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()

        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        viewModel.let {
            if (it is BaseViewModel) {
                it.activityResult(requestCode, resultCode, data)
            }
        }
    }

    protected fun bind(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

}