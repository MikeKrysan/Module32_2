package com.mikekrysan.module32_2

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter

class Stock(var name: String, private var _price:Int = 0, @DrawableRes val iconId: Int): BaseObservable() {

    @get: Bindable
    var price: Int = _price
        set(value) {
            field = value
            //оповещается поле price
            notifyPropertyChanged(BR.price)
        }

    companion object {
        @BindingAdapter("imageId")
        @JvmStatic
        fun loadImage(view: ImageView, imageId: Int) {
            view.setImageResource(imageId)
        }
    }
}