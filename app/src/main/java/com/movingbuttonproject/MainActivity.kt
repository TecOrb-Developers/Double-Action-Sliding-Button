package com.movingbuttonproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.slidingbutton.CallbackReturnValue
import com.example.slidingbutton.SlidingButton
import com.movingbuttonproject.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log

class MainActivity : AppCompatActivity(),CallbackReturnValue {
    private lateinit var binding:ActivityMainBinding

    lateinit var value : ConstraintLayout.LayoutParams
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)


            binding.imageView.setOnTouchListener(
                SlidingButton(binding.moveImageLayout.width, binding.moveImageLayout.height,this)
            )
    }

    override fun backValue(newX: Float) {
        Log.d("TAG", "onTouch: $newX")
        if(newX>370) {
            binding.textView2.setTextColor(resources.getColor(R.color.black))
            binding.textView.setTextColor(resources.getColor(R.color.white))
        }
        else if(newX<20){
            binding.textView2.setTextColor(resources.getColor(R.color.white))
            binding.textView.setTextColor(resources.getColor(R.color.black))
        }
    }


}