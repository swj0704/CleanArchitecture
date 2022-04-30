package org.software.meister.gsm.cleanarchitecture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.software.meister.gsm.domain.TodoItem
import org.software.meister.gsm.domain.usecase.PostTodoItemUseCase
import javax.inject.Inject


@HiltViewModel
class WriteTodoViewModel @Inject constructor(val postTodoItemUseCase: PostTodoItemUseCase) : ViewModel(){
    val titleTodo = MutableLiveData<String>()
    val textTodo = MutableLiveData<String>()
    val finishEvent = MutableLiveData<Boolean>()

    fun postTodo(){
        if(titleTodo.value.toString().isNotEmpty() && textTodo.value.toString().isNotEmpty()){
            viewModelScope.launch {
                postTodoItemUseCase(TodoItem(0, titleTodo.value.toString(), textTodo.value.toString(), System.currentTimeMillis()))
                finishEvent.value = true
            }
        }
    }
}