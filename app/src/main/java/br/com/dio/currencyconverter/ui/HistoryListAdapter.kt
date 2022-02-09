package br.com.dio.currencyconverter.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.currencyconverter.core.extensions.formatCurrency
import br.com.dio.currencyconverter.data.model.Coin
import br.com.dio.currencyconverter.data.model.ExchangeResponseValue
import br.com.dio.currencyconverter.databinding.ItemHistoryBinding


class HistoryListAdapter: ListAdapter<ExchangeResponseValue, HistoryListAdapter.ViewHolder>(DiffCallBack()){

    var setOnMenuClick: (View, ExchangeResponseValue) -> Unit = {_, _ ->}
    var setOnCardClick: (ExchangeResponseValue) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryListAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemHistoryBinding
        ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ExchangeResponseValue){
            val coin = Coin.getByName(item.codein)

            binding.tvName.text = item.name
            binding.tvValue.text = item.bid.formatCurrency(coin.locale)
        }
    }

}

class DiffCallBack: DiffUtil.ItemCallback<ExchangeResponseValue>() {
    override fun areItemsTheSame(oldItem: ExchangeResponseValue, newItem: ExchangeResponseValue) = oldItem == newItem
    override fun areContentsTheSame(oldItem: ExchangeResponseValue, newItem: ExchangeResponseValue) = oldItem.id == newItem.id
}
