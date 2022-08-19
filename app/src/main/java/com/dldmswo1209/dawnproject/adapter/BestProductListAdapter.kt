package com.dldmswo1209.dawnproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dldmswo1209.dawnproject.dataClass.ProductItem
import com.dldmswo1209.dawnproject.databinding.BestProductItemBinding
import com.dldmswo1209.dawnproject.databinding.ProductRankItemBinding

class BestProductListAdapter: ListAdapter<ProductItem, BestProductListAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: BestProductItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(productItem: ProductItem){
            binding.itemImageView.setImageResource(productItem.image)
            binding.brandTextView.text = productItem.brand
            binding.detailTextView.text = productItem.detail
            binding.saleTextView.text = productItem.sale
            binding.priceTextView.text = productItem.price
            binding.likeButton.isChecked = productItem.like
            binding.likeButton.setOnClickListener {
                currentList[adapterPosition].like = !currentList[adapterPosition].like
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(BestProductItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<ProductItem>(){
            override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
                return oldItem.brand == newItem.brand
            }

            override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}