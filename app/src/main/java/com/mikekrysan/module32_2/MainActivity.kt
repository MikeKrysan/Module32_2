package com.mikekrysan.module32_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import com.mikekrysan.module32_2.databinding.ActivityMainBinding
import com.mikekrysan.module32_2.databinding.SampleBinding
import java.util.*

fun getExRate():Double {
    return 75.842
}

class MainActivity : AppCompatActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.cash = 10
//        binding.notifyPropertyChanged(BR.cash)
//
//    }

    //юнит 3 - задача реализовать динамически изменающуюся модель данных и сделать простые привязки
//    lateinit var countDownTimer: CountDownTimer
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        //создаем юзера
//        val user = User(50_000, arrayListOf(Stock("Яндекс", 5000, R.drawable.yandex_icon), Stock("Mail.ru Group", 3000, R.drawable.mailru_icon)))
//        //юзера передаем в binding
//        binding.user = user
//
//        //Для binding получаем адаптер и присваиваем его как адаптер на основе stockList-a
//        (binding.recyclerView.adapter) = StockAdapter(user.stockList)
//        //Чтобы данные изменялись динамически нам нужен таймер - класс CountDownTimer
//        val r = Random(System.currentTimeMillis())
//        countDownTimer = object : CountDownTimer(10_000, 1000L) {
//            //действия описываем в методе Tick
//            override fun onTick(millisUntilFinished: Long) {
//                user.cash += -1000 + r.nextInt(2000)    //меняем кеш от -1000 до 1000 руб
//                user.stockList.forEach {
//                    it.price += (-0.1*it.price).toInt() + r.nextInt((0.2*it.price).toInt())
//                }
//            }
//            //метод который срабатывает когда таймер завершается
//            override fun onFinish() {
//                countDownTimer.start()
//            }
//        }
//        countDownTimer.start()
//    }

    //Юнит 4 -  Data Binding. Выражения
    //Binding переменных
//    lateinit var countDownTimer: CountDownTimer
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val binding: SampleBinding = DataBindingUtil.setContentView(this, R.layout.sample)
//        binding.unit = Unit(5,6,12)
//    }

    //Binding выражений/Binding обработчиков
//    lateinit var countDownTimer: CountDownTimer
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val binding: SampleBinding = DataBindingUtil.setContentView(this, R.layout.sample)
//        binding.unit = Unit(5,6,7, 10)
//    }

    //Юнит4 - реализация возможности приостановления процесса изменения данных которые были реализованы ранее в 3 юните, и возобновление процесса
    //Желательно с именением текстового поля, вызывая метод resume или pause
    lateinit var countDownTimer: CountDownTimer
    var flag: ObservableBoolean = ObservableBoolean(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //создаем юзера
        val user = User(50_000, arrayListOf(Stock("Яндекс", 5000, R.drawable.yandex_icon), Stock("Mail.ru Group", 3000, R.drawable.mailru_icon)))
        //юзера передаем в binding
        binding.user = user
        binding.exRate = getExRate()

        //функция изменяет флаг. Инвертирует текущее значение флага. И проверяет, если флаг правда, то таймер мы должны запустить
        binding.f = {
            flag.set(!flag.get())
            if(flag.get()) {
                countDownTimer.start()
            } else {
                countDownTimer.cancel()
            }
        }

        binding.flag =flag

        //Для binding получаем адаптер и присваиваем его как адаптер на основе stockList-a
        (binding.recyclerView.adapter) = StockAdapter(user.stockList)
        //Чтобы данные изменялись динамически нам нужен таймер - класс CountDownTimer
        val r = Random(System.currentTimeMillis())
        countDownTimer = object : CountDownTimer(10_000, 1000L) {
            //действия описываем в методе Tick
            override fun onTick(millisUntilFinished: Long) {
                user.cash += -1000 + r.nextInt(2000)    //меняем кеш от -1000 до 1000 руб
                user.stockList.forEach {
                    it.price += (-0.1*it.price).toInt() + r.nextInt((0.2*it.price).toInt())
                }
            }
            //метод который срабатывает когда таймер завершается
            override fun onFinish() {
                countDownTimer.start()
            }
        }
        countDownTimer.start()
    }




}