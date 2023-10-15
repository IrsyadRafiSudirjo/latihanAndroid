package com.example.latihanandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "$selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setiap membuat button pastikan membuat findciew dan juga setOnclicklistenernya
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject:Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone:Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

        val btnMoveViewAndGroup:Button = findViewById(R.id.btn_move_for_view_and_group)
        btnMoveViewAndGroup.setOnClickListener(this)

        val btnMoveToConstraintLayoutActivity:Button = findViewById(R.id.btn_move_to_constraint_layout)
        btnMoveToConstraintLayoutActivity.setOnClickListener(this)

        val btnMoveRecycleViewActivity:Button = findViewById(R.id.btn_move_to_recycle_view)
        btnMoveRecycleViewActivity.setOnClickListener(this)


        val btnMoveCalculateActivity:Button = findViewById(R.id.btn_move_to_calculate_view)
        btnMoveCalculateActivity.setOnClickListener(this)

//        val btnMoveToConstraintLayoutActivity = findViewById(R.id.btn_move_to_constraint_layout)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btn_move_activity ->{
                //membuat intent untuk menjalankan aktivitas
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                //menjlankan intent untuk memmindah aktivitas dari main activity ke move activity
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)

                //menyimpan variable pada intent dengan key yang sesuai di activity yang dituju
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "MIR")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_activity_object -> {
                //Membuat object person
                val person = Person(
                    "MIR",
                    5,
                    "mir@safarma.com",
                    "Bandung"
                )

                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                //memasukan object pada key activity
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            //implicit intent
            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                //membuka aplikasi lain yaitu nomor telepone
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }

            R.id.btn_move_for_view_and_group ->{
                val moveViewAndGroupIntent = Intent(this@MainActivity, VIewAndGroupActivity::class.java)
                startActivity(moveViewAndGroupIntent)
            }
            R.id.btn_move_to_constraint_layout ->{
                val moveToConstraintLayoutActivity = Intent(this@MainActivity, MoveToConstraintLayoutActivity::class.java)
                startActivity(moveToConstraintLayoutActivity)
            }
            R.id.btn_move_to_recycle_view ->{
                val moveToRecycleViewActivity = Intent(this@MainActivity, MoveRecycleViewActivity::class.java)
                startActivity(moveToRecycleViewActivity)
            }
            R.id.btn_move_to_calculate_view -> {
                val moveCalculateActivity = Intent(this@MainActivity, CalculateActivity::class.java)
                startActivity(moveCalculateActivity)
            }
        }
    }
}