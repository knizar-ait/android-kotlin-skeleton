package com.interview.skeleton.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.interview.skeleton.R
import com.interview.skeleton.di.ServiceLocator

class DetailActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvPrice: TextView
    private lateinit var progressBar: ProgressBar

    private val viewModel: DetailViewModel by viewModels {
        ServiceLocator.provideDetailViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupViews()
        setupObservers()

        val dataId = intent.getIntExtra("DATA_ID_EXTRA", -1)
        if (dataId != -1) {
            viewModel.loadData(dataId)
        }
    }

    private fun setupViews() {
        tvName = findViewById(R.id.tvName)
        tvDescription = findViewById(R.id.tvDescription)
        tvPrice = findViewById(R.id.tvPrice)
        progressBar = findViewById(R.id.progressBar)
    }

    private fun setupObservers() {
        viewModel.data.observe(this) { data ->
            tvName.text = data.name
            tvDescription.text = data.description
            tvPrice.text = "$${data.price}"
        }

        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}
