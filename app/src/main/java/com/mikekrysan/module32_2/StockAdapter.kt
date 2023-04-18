package com.mikekrysan.module32_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mikekrysan.module32_2.databinding.ListItemBinding


//Акции будут хранится в RecyclerView, чтобы можно было добавить большее количество и экономить память
class StockAdapter(var data: ArrayList<Stock>): RecyclerView.Adapter<StockAdapter.StockHolder>() {

    //В холдер родительский мы перадаем root binding - это базовое свойство которое есть у всякого binding-объекта
    class StockHolder(var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockHolder {
        //при создании мы сначала создаем inflater
        val inflater = LayoutInflater.from(parent.context)
        //потом с помощью DataBindingUtil.inflate() передаем туда inflater (файл разметки) и не присоединяем к родителю
        return StockHolder(DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false))
    }

    //В методе мы присваиваем stock. Stock описан в list_item.xml
    override fun onBindViewHolder(holder: StockHolder, position: Int) {
        holder.binding.stock = data[position]
        holder.binding.exRate = getExRate()
    }

    override fun getItemCount(): Int {
        return data.size
    }

}