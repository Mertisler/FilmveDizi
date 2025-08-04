package com.loc.filmvedizi


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.loc.filmvedizi.data.tv.repository.TvRepository
import com.loc.filmvedizi.data.tv.viewmodel.TvViewModel

class TvViewModelFactory(
    private val repository: TvRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TvViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
