package com.oghenovo.studentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.oghenovo.studentdata.newactivity.AddStudentDataActivity
import com.oghenovo.studentdata.databinding.ActivityMainBinding
import com.oghenovo.studentdata.ui.ItemAdapter
import com.oghenovo.studentdata.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.floatingBtn.setOnClickListener {
            val intent = Intent(this, AddStudentDataActivity::class.java)
            startActivity(intent)
        }
        itemAdapter = ItemAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.itemRv.adapter = itemAdapter

        viewModel.getItems()
        viewModel.itemsLiveData.observe(this, { list ->
            itemAdapter.list = list
            itemAdapter.notifyDataSetChanged()
        })
    }
}