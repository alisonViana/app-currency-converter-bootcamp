package br.com.dio.currencyconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.currencyconverter.core.extensions.createProgressDialog
import br.com.dio.currencyconverter.databinding.ActivityHistoryBinding
import br.com.dio.currencyconverter.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHistoryBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<HistoryViewModel>()
    private val adapter by lazy { HistoryListAdapter() }
    private val loadingDialog by lazy { createProgressDialog() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}