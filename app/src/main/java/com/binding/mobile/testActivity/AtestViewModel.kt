package com.binding.mobile.testActivity

import androidx.lifecycle.SavedStateHandle
import com.app3null.basestructure.viewModels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AtestViewModel@Inject constructor(
    val handle: SavedStateHandle
) : BaseViewModel<AtestViewState>() {


}