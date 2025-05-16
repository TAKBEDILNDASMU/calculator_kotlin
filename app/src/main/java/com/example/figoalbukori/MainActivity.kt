package com.example.figoalbukori

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponent()

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            var result: String? = savedInstanceState.getString(STATE_RESULT)
            tvResult.setText(result)
        }
    }

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    private final val STATE_RESULT: String? = "state_result"

    private fun initComponent() {
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        tvResult.setText(R.string.result)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {
            val inputLength: String = edtLength.text.toString().trim()
            val inputWidth: String = edtWidth.text.toString().trim()
            val inputHeigth: String = edtHeight.text.toString().trim()
            var isEmptyFields: Boolean = false

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true
                edtLength.setError("Field ini tidak boleh kosong")
            }

            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true
                edtWidth.setError("Field ini tidak boleh kosong")
            }

            if (TextUtils.isEmpty(inputHeigth)) {
                isEmptyFields = true
                edtHeight.setError("Field ini tidak boleh kosong")
            }

            if (!isEmptyFields) {
                val volume: Double = inputLength.toDouble() * inputWidth.toDouble() *
                        inputHeigth.toDouble()

                tvResult.setText(volume.toString())
            }

        }

    }
}