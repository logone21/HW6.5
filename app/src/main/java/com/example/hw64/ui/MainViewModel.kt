package com.example.hw64.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var mCounter = 0
    private var mHistory = ""

    var history= MutableLiveData<String>()
    var counter= MutableLiveData<Int>()

    fun increment(){
        mCounter ++
        counter.value=mCounter
        mHistory ="$mHistory\n+"
        history.value = mHistory
    }
    fun decrement(){
        mCounter --
        counter.value = mCounter
        mHistory ="$mHistory\n-"
        history.value = mHistory
    }




}