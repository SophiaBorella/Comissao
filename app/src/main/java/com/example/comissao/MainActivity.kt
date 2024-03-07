package com.example.comissao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        btnCalc.setOnClickListener {

            /*---------------------------------------------------------------------------------*/

            val salario = findViewById<EditText>(R.id.salarioFixo)
            val km = findViewById<EditText>(R.id.qtdKm)
            val comissao = findViewById<TextView>(R.id.comissao)
            val resultado = findViewById<TextView>(R.id.resultado)
            val nsalario = salario.text.toString()
            val nkm      = km.text.toString()
            val nsalariofixo = nsalario.toDouble()
            val nkmperc = nkm.toDouble()

            /*---------------------------------------------------------------------------------*/

            val Comi: Double = when {
                nkmperc <= 500 -> 0.001 * 100
                nkmperc <= 1000 -> 0.0015 * 100
                nkmperc <= 2000 -> 0.0025 * 100
                else -> 0.003 * 100
            }

            /*---------------------------------------------------------------------------------*/

            val result: Double = nsalariofixo * (Comi / 100)  * nkmperc
            val total: Double = result + nsalariofixo

            comissao.text = "Sua comissão é: R$ %.2f".format(result)
            resultado.text = "Salário final é: R$ %.2f".format(total)

            Toast.makeText(this, "Sua Comissão é = $result ", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "O total do pagamento é = $total ", Toast.LENGTH_SHORT).show()

            /*---------------------------------------------------------------------------------*/
        }
    }
}
