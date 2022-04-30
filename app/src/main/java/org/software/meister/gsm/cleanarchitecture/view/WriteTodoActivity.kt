package org.software.meister.gsm.cleanarchitecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.software.meister.gsm.cleanarchitecture.databinding.ActivityWriteTodoBinding
import org.software.meister.gsm.cleanarchitecture.viewmodel.WriteTodoViewModel

@AndroidEntryPoint
class WriteTodoActivity : AppCompatActivity() {

    private val binding : ActivityWriteTodoBinding by lazy {
        ActivityWriteTodoBinding.inflate(layoutInflater)
    }

    private val viewModel : WriteTodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.finishEvent.observe(this) {
            finish()
        }
    }
}