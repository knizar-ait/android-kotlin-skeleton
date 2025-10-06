package com.interview.skeleton.presentation.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.interview.skeleton.R
import com.interview.skeleton.di.ServiceLocator
import com.interview.skeleton.presentation.productdetail.DetailActivity

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: ProductListAdapter

    private val viewModel: ListViewModel by viewModels {
        ServiceLocator.provideDataListViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setupViews()
        setupObservers()

        viewModel.loadProducts()
        viewModel.loadProducts()
    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        adapter = ProductListAdapter { data ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("DATA_ID", data.id)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.data.observe(this) { data ->
            adapter.submitList(data)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}
