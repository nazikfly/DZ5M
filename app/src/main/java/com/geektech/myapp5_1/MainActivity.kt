package com.geektech.myapp5_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.myapp5_1.databinding.ActivityMainBinding
import com.geektech.myapp5_1.helper.Injector
import com.geektech.myapp5_1.view.CounterView


class MainActivity : AppCompatActivity(),CounterView {
    lateinit var binding: ActivityMainBinding
    private  val presenter=Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            incrementBtn.setOnClickListener() {
                presenter.increment()
            }
        }
    }

    override fun showNewCount(count:Int) {
        binding.resultTv.text=count.toString()
    }

    override fun changeTextColor() {
        binding.resultTv.setTextColor(Color.GREEN)
    }

    override fun showTost(msg: String) {
       Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}