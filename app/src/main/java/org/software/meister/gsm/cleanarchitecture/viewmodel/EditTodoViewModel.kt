package org.software.meister.gsm.cleanarchitecture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.software.meister.gsm.domain.usecase.UpdateTodoItemUseCase
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.software.meister.gsm.domain.TodoItem
import org.software.meister.gsm.domain.usecase.DeleteTodoItemUseCase
import org.software.meister.gsm.domain.usecase.GetTodoItemUseCase

@HiltViewModel
class EditTodoViewModel @Inject constructor(val updateTodoItemUseCase: UpdateTodoItemUseCase, val deleteTodoItemUseCase: DeleteTodoItemUseCase, val getTodoItemUseCase: GetTodoItemUseCase) : ViewModel(){
    val titleTodo = MutableLiveData<String>()
    val textTodo = MutableLiveData<String>()
    val finishEvent = MutableLiveData<Boolean>()
    private var time = 0L

    fun getTodoItem(id : Int){
        viewModelScope.launch {
            val item = getTodoItemUseCase(id)
            titleTodo.value = item?.title
            textTodo.value = item?.text
            time = item?.createdAt?:0
        }
    }

    fun updateTodo(id : Int){
        if(titleTodo.value.toString().isNotEmpty() && textTodo.value.toString().isNotEmpty() && id != -1){
            viewModelScope.launch {
                updateTodoItemUseCase(TodoItem(id, titleTodo.value.toString(), textTodo.value.toString(), time))
                finishEvent.value = true
            }
        }
    }

    fun deleteTodo(id : Int){
        viewModelScope.launch {
            deleteTodoItemUseCase(id)
            finishEvent.value = true
        }
    }
}