package com.rachel.kisahnabi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rachel.kisahnabi.model.ResponseMain
import com.rachel.kisahnabi.repo.RepositoryMain

class ViewModelMain: ViewModel() {

    val repository = RepositoryMain()

    val responGetData = MutableLiveData<List<ResponseMain>>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getDataView(){
        isLoading.value = true

        repository.getData({
            isLoading.value = false
            responGetData.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

}
