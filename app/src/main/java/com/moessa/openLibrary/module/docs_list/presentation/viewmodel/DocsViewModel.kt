package com.moessa.openLibrary.module.docs_list.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moessa.openLibrary.module.docs_list.data.model.mapper.toEntity
import com.moessa.openLibrary.module.docs_list.domain.entity.DocsEntity
import com.moessa.openLibrary.module.docs_list.domain.entity.param.GetDocsListParam
import com.moessa.openLibrary.module.docs_list.domain.usecase.GetDocsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DocsViewModel @Inject constructor(
    private val getDocsListUseCase: GetDocsListUseCase
) : ViewModel() {

    private val _docsListStateFlow = MutableStateFlow<List<DocsEntity>?>(listOf())
    fun docsListStateFlow(): StateFlow<List<DocsEntity>?> = _docsListStateFlow

    private val _errorStateFlow = MutableStateFlow<Throwable?>(null)
    fun errorStateFlow(): StateFlow<Throwable?> = _errorStateFlow

    private val _loadingStateFlow = MutableStateFlow(false)
    fun loadingStateFlow(): StateFlow<Boolean> = _loadingStateFlow

    fun getDocsList(title: String) {

        viewModelScope.launch(Dispatchers.IO) {
            _loadingStateFlow.emit(true)
            getDocsListUseCase(GetDocsListParam(title)).let {
                _loadingStateFlow.emit(false)
                _docsListStateFlow.emit(it?.map { docModel ->
                    docModel.toEntity()
                })
            }
        }
    }
}