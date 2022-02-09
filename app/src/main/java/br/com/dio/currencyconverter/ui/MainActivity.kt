package br.com.dio.currencyconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.widget.doAfterTextChanged
import br.com.dio.currencyconverter.core.extensions.*
import br.com.dio.currencyconverter.data.model.Coin
import br.com.dio.currencyconverter.databinding.ActivityMainBinding
import br.com.dio.currencyconverter.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<MainViewModel>()
    private val loadingDialog by lazy { createProgressDialog() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setAdapters()
        setListeners()
        setObservers()

    }

    private fun setAdapters() {
        val list = Coin.values()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        binding.tvFrom.setAdapter(adapter)
        binding.tvTo.setAdapter(adapter)

        binding.tvFrom.setText(Coin.USD.name, false)
        binding.tvTo.setText(Coin.BRL.name, false)
    }

    private fun setListeners() {
        binding.tilValue.editText?.doAfterTextChanged {
            binding.btnConvert.isEnabled = binding.tilValue.text.isNotBlank()
        }
        binding.btnConvert.setOnClickListener {
            it.hideSoftKeyboard()

            val coinsToExchange = "${binding.tilFrom.text}-${binding.tilTo.text}"
            viewModel.getExchangeValues(coinsToExchange)
        }
    }

    private fun setObservers() {
        viewModel.state.observe(this){
            when (it) {
                MainViewModel.State.Loading -> loadingDialog.show()
                is MainViewModel.State.Error -> {
                    loadingDialog.dismiss()
                    createDialog {
                        setMessage(it.error.message)
                    }.show()
                }
                is MainViewModel.State.Success -> {
                    loadingDialog.dismiss()
                    onSuccess(it)
                }
            }
        }
    }

    private fun onSuccess(exchange: MainViewModel.State.Success) {
        val result = exchange.value.bid * binding.tilValue.text.toDouble()
        val coinFinal = Coin.values().find { it.name == binding.tilTo.text } ?: Coin.BRL

        binding.tvResult.text = result.formatCurrency(coinFinal.locale)
    }
}