package com.mikekrysan.module32_2

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

//Опишем модель данных: класс User имеет cash и StockList - акции. Stock - одна акциия. Реализует BaseObservable - чтобы была возможность за ним наблюдать и оповещать об изменениях наши View
class User(private val _cash: Int, val stockList: ArrayList<Stock>): BaseObservable() {
    //нотация для возможности использовать метод notifyPropertyChanged()
    @get:Bindable
    var cash: Int = _cash
    set(value) {
        field = value
        //метод который оповещает View об произошедших изменениях. В сгенерированном классе BR cash - это описанная переменная
        notifyPropertyChanged(BR.cash)
    }
}