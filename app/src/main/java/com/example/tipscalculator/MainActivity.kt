package com.example.tipscalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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


        val tieTotal: TextInputEditText = findViewById(R.id.tie_total) //Posso declarar o tipo após a variável
        val tieNumberOfPeople: TextInputEditText = findViewById(R.id.tie_number_of_people)
        val btnClean = findViewById<Button>(R.id.btn_clean) //posso declarar o tipo no findViewById
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        binding.btnClean.setOnClickListener {
            println()
        }

    }
}