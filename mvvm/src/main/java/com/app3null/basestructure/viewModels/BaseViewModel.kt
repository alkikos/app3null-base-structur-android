package com.app3null.basestructure.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app3null.basestructure.actions.ViewStateAction
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.typeOf

abstract class BaseViewModel<VIEW_STATE: Any> :
    ViewModel() {

    private val liveViewState = MutableLiveData<VIEW_STATE>()

    protected val compositeDisposable = CompositeDisposable()

    private var currentState: VIEW_STATE? = null

    protected fun registerDisposables(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }


    private fun sendState(state: VIEW_STATE) {
        this.currentState = state
        liveViewState.postValue(currentState!!)
    }


    fun getLiveViewState(): LiveData<VIEW_STATE> {
        return liveViewState
    }

}

inline fun <reified T: Any> BaseViewModel<T>.dispatchAction(viewStateAction: ViewStateAction<T>){
    val old = BaseViewModel::class.declaredMemberProperties.find { it.name == "currentState" }?.also {
        it.isAccessible = true
    }?.call(this) as T?

    BaseViewModel::class.declaredMemberFunctions.find { it.name == "sendState" }?.also {
        it.isAccessible = true
    }?.call(this, viewStateAction.newState(old?: CreateInstance()))
}


inline fun <reified T: Any> CreateInstance(): T{
    if(T::class.isInstance(MainViewState))
        return MainViewState as T
    else if (T::class.isInstance(AtestViewState)){
        return AtestViewState
    }

    return T::class.createInstance()

}