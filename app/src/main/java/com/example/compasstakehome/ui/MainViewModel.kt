package com.example.compasstakehome.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compasstakehome.domain.usesCase.GetDataUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDataUC: GetDataUC
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    private val _every10ThCharacter = MutableLiveData<List<String>>()
    val every10ThCharacter = _every10ThCharacter
    private val _splitAndCount = MutableLiveData<List<Pair<String, Int>>>()
    val splitAndCount = _splitAndCount

    fun onCreate() {
        viewModelScope.launch {

            isLoading.postValue(true)

            val response = getDataUC()
            if (!response.data.isNullOrEmpty()) {
                getCharacterEvery10th(response.data)
                splitTextAndCountWords(response.data)
                isLoading.postValue(false)
            } else {
                returnEmptyValues()
            }
        }
    }


    private fun returnEmptyValues() {
        isLoading.postValue(false)
        _every10ThCharacter.postValue(emptyList())
        _splitAndCount.postValue(emptyList())
    }

    private fun splitTextAndCountWords(response: String) {
        viewModelScope.launch {
            val results2 = (response.split(" ", ".", "'\t'", "\n"))

            val counterList = results2.groupingBy { it }.eachCount()
                .filter { it.value >= 1 }
                .toList()

            println(counterList)
            _splitAndCount.postValue(counterList)
        }
    }

    private fun getCharacterEvery10th(response: String) {
        viewModelScope.launch {

            val results = arrayListOf<String>()
            var i = 0
            while (i <= response.length) {
                if (i % 10 == 0) {
                    results.add(response.substring(i, i + 1))
                }
                i++
            }
            println(results)

            _every10ThCharacter.postValue(results)
        }
    }

}