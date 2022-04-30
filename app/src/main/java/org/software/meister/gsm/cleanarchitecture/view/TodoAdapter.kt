package org.software.meister.gsm.cleanarchitecture.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.software.meister.gsm.cleanarchitecture.databinding.ItemTodoBinding
import org.software.meister.gsm.domain.TodoItem

interface OnClickTodoItem{
    fun onClickTodoItemListener(item : TodoItem)
}

class TodoAdapter(private val handler : OnClickTodoItem) : ListAdapter<TodoItem, TodoViewHolder>(TodoDiff){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position), handler)
    }

}

class TodoViewHolder(private val binding : ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item : TodoItem, handler: OnClickTodoItem){
        binding.item = item
        binding.handler = handler
    }
}

object TodoDiff : DiffUtil.ItemCallback<TodoItem>(){
    override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.text == newItem.text && oldItem.createdAt == newItem.createdAt
    }

    override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem == newItem
    }

}