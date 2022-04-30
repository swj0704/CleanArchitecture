package org.software.meister.gsm.cleanarchitecture.viwemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.software.meister.gsm.cleanarchitecture.view.OnClickTodoItem
import org.software.meister.gsm.cleanarchitecture.view.TodoAdapter
import org.software.meister.gsm.domain.TodoItem
import org.software.meister.gsm.domain.usecase.GetTodoListUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val listUseCase : GetTodoListUseCase): ViewModel() {

    val adapter = TodoAdapter(object : OnClickTodoItem {
        override fun onClickTodoItemListener(item: TodoItem) {
            _todoItem.value = item
        }

    })

    private val _todoItem = MutableLiveData<TodoItem>()
    val todoItem : LiveData<TodoItem>
        get() = _todoItem

    fun getList(){
        viewModelScope.launch {
            adapter.submitList(listUseCase())
        }
    }
}