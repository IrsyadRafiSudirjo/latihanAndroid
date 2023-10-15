package com.example.latihanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.latihanandroid.databinding.ActivityCalculateBinding

class CalculateActivity : AppCompatActivity() {

    private lateinit var activityCalculateBinding: ActivityCalculateBinding
    //private lateinit var viewModel: CalculateViewModel
    private val viewModel: CalculateViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)
        activityCalculateBinding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(activityCalculateBinding.root)

        //viewModel = ViewModelProvider(this).get(CalculateViewModel::class.java)

        displayResult()
        activityCalculateBinding.btnCalculate.setOnClickListener {
            val width = activityCalculateBinding.edtWidth.text.toString()
            val height = activityCalculateBinding.edtHeight.text.toString()
            val length = activityCalculateBinding.edtLength.text.toString()
            when {
                width.isEmpty() -> {
                    activityCalculateBinding.edtWidth.error = "Masih kosong"
                }
                height.isEmpty() -> {
                    activityCalculateBinding.edtHeight.error = "Masih kosong"
                }
                length.isEmpty() -> {
                    activityCalculateBinding.edtLength.error = "Masih kosong"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityCalculateBinding.tvResult.text = viewModel.result.toString()
    }
}