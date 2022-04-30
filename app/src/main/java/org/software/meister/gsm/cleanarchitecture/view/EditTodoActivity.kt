package org.software.meister.gsm.cleanarchitecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.software.meister.gsm.cleanarchitecture.databinding.ActivityEditTodoBinding
import org.software.meister.gsm.cleanarchitecture.viewmodel.EditTodoViewModel

@AndroidEntryPoint
class EditTodoActivity : AppCompatActivity() {

    private val binding : ActivityEditTodoBinding by lazy {
        ActivityEditTodoBinding.inflate(layoutInflater)
    }

    val viewModel : EditTodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.id = intent.getIntExtra("id", -1)
        viewModel.getTodoItem(intent.getIntExtra("id", -1))

        viewModel.finishEvent.observe(this){
            finish()
        }
    }
}