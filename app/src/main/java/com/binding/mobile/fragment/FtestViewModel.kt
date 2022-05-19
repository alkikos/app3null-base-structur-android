package com.binding.mobile.fragment

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.app3null.basestructure.viewModels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FtestViewModel@Inject constructor(
    val handle: SavedStateHandle
) : BaseViewModel<FtestViewState>() {



    fun testFunction(){
        Log.d("DBG", "OK")
    }
}