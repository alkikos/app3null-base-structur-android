package com.binding.mobile.ui.activitymain

import androidx.lifecycle.SavedStateHandle
import com.app3null.basestructure.viewModels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    val handle: SavedStateHandle
): BaseViewModel<MainViewState>() {

    /*override fun getInitialState(): MainViewState {
        return MainViewState
    }*/

    fun getTestStr(): String {
        return "~~~TestViewModel"
    }
}