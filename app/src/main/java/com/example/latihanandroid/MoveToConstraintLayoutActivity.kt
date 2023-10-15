package com.example.latihanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.latihanandroid.databinding.ActivityMainBinding
import com.example.latihanandroid.databinding.ActivityMoveToConstraintLayoutBinding

class MoveToConstraintLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoveToConstraintLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveToConstraintLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextText.setText("gege")
        binding.editTextText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                binding.tvResultTxt.text = "hasilny adalah " +s
            }
        })
    }
}