package com.geektech.myapp5_1.presenter

import com.geektech.myapp5_1.helper.Injector
import com.geektech.myapp5_1.view.CounterView

class Presenter{

   private val model=Injector.getModel()
    lateinit var view:CounterView

    fun increment(){
        model.increment()
        view.showNewCount(model.count)
      reaction()

    }
    fun attachView(view: CounterView){
        this.view=view
    }

    fun reaction() {
        if(model.count== +15)
            view.changeTextColor()
        if (model.count == +10) {
            view.showTost("Поздравлям")
        }
    }


}