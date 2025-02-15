package com.binding.mobile.activity


import android.os.Bundle
import androidx.activity.viewModels
import com.binding.mobile.ui.activitymain.MainViewModel
import com.binding.mobile.ui.activitymain.MainViewState
import com.binding.mobile.databinding.ActivityMainBinding
import com.app3null.basestructure.activities.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :  BaseActivity<MainViewState, MainViewModel>() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        renderView(savedInstanceState)
    }

    override fun reflectState(viewState: MainViewState) {

    }

    override fun renderView(savedInstanceState: Bundle?) {
        binding.tvMainText.text = "Test binding"
        println("~~~~2")
        println("~~~~${viewModel.getTestStr()}")
    }

    override fun provideViewModel(): MainViewModel {
        return viewModel
    }
}