package org.software.meister.gsm.cleanarchitecture.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.software.meister.gsm.cleanarchitecture.databinding.ActivityMainBinding
import org.software.meister.gsm.cleanarchitecture.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initAction()
        initObserve()
    }

    private fun initAction(){
        binding.writeButton.setOnClickListener {
            // intent to write activity
        }
    }

    private fun initObserve(){
        with(viewModel){
            todoItem.observe(this@MainActivity) {
                val intent = Intent(this@MainActivity, EditTodoActivity::class.java)
                intent.putExtra("id", it.id)
                intent.putExtra("title", it.title)
                intent.putExtra("text", it.text)
                intent.putExtra("createdAt", it.createdAt)
                startActivity(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getList()
    }
}