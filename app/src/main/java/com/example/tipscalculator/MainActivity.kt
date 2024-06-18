package com.example.tipscalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnClean.setOnClickListener {
            clean()
        }

        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val numOfPeopleTemp = binding.tieNumberOfPeople.text
            val percentageTemp = binding.tiePercentage.text

            if (totalTableTemp?.isEmpty() == true ||
                numOfPeopleTemp?.isEmpty() == true ||
                percentageTemp?.isEmpty() == true) { //Verifica se algum dos campos está vazio
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()

            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = numOfPeopleTemp.toString().toInt()
                val percentage: Int = percentageTemp.toString().toInt()

                val total = (((totalTable * percentage) / 100) + totalTable) / nPeople


                val intent = Intent(
                    this,
                    SummaryActivity::class.java
                ) //Utilizado para levar informações de uma Activity para outra
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("numOfPeople", nPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalAmount", total)
                }
                clean()
                startActivity(intent)
            }

        }

    }

    fun clean() {
        binding.tieTotal.setText("")
        binding.tieNumberOfPeople.setText("")
        binding.tiePercentage.setText("")
    }
}