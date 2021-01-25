package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //对变量延迟初始化,使用lateinit关键字，告诉kotlin编译器在未来对变量进行初始化，可以不必赋值null，从而减少后续的判空操作，如下
    private lateinit var str: String

    //不适用延迟初始化，则需要先赋值null，随后还需要判空等操作
    private var strNor: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("data", "onCreate execute")
        if (!::str.isInitialized) {
            //判断是否初始化
//            实现相关操作
            str = "延迟初始化"
        }
        strNor = "未延迟初始化"
    }

    override fun onClick(v: View?) {
        //一个使用了延迟初始化，一个未使用
        str[0]//不需要判空操作
        strNor?.get(0)//需要判空操作
    }

}
