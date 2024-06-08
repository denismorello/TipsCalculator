package com.example.tipscalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    //Desenvolvimentos a serem realizados:
    //Valor total da conta
    //Numero de pessoas
    //Porcentagem da gorjeta
    //10%, 15% ou 20%
    //Calular
    //Limpar

    //Recuperar as views do layout
    //ViewBinding

    //Recuperar os radio buttons
    //Calculo da tip
    //Calculo do resultado

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var percentage: Int = 0

        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 20
            }
        }

        binding.btnClean.setOnClickListener {
            println()
        }

        binding.btnCalculate.setOnClickListener {
            val totalTable: Float = binding.tieTotal.text.toString().toFloat()
            val nPeople: Int = binding.tieNumberOfPeople.text.toString().toInt()

            val total = (((totalTable * percentage) / 100) + totalTable) / nPeople
            binding.tvResult.text = "Total with tips: $total"

        }


    }
}