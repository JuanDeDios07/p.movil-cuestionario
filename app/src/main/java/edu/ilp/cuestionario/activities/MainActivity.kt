package edu.ilp.cuestionario.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import edu.ilp.cuestionario.R
import edu.ilp.cuestionario.modelo.Pregunta

class MainActivity : AppCompatActivity() {
    var preguntas = ArrayList<Pregunta>()
    var posicionActual = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // este metodo añade preguntas ala lista
        caragrPreguntas()
        // este metodo añade preguntas al usuario
        mostrarPreguntas()

        val btnVerdad = findViewById<android.view.View>(R.id.btnVerdadero)
        btnVerdad.setOnClickListener() {
            if (preguntas[posicionActual].respuesta)
                Toast.makeText(this, "La respuesta es Corecta", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "La respuesta es InCorecta", Toast.LENGTH_SHORT).show()
        }
        val btnincorecto = findViewById<android.view.View>(R.id.btnFalso)
        btnincorecto.setOnClickListener() {
            if (!preguntas[posicionActual].respuesta)
                Toast.makeText(this, "la respuesta es Corecta", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "La respuesta es InCorecta", Toast.LENGTH_SHORT).show()
        }

        val btnNext = findViewById<Button>(R.id.btnsiguiente)
        btnNext.setOnClickListener {
            try {
                posicionActual++
                mostrarPreguntas()
            }catch (e: Exception){
                println("FIN DE LAS ENCUESTAS")
                Toast.makeText(this, "FIN DE LAS ENCUESTAS", Toast.LENGTH_SHORT).show()
            }
        }
// TAREA PARA EL MIERCOLES

        val btnRetroceder = findViewById<Button>(R.id.btnatras)
        btnRetroceder.setOnClickListener {
            try {
                posicionActual =posicionActual-1
                mostrarPreguntas()
            }catch (e: Exception){
                println("NO HAY MAS ENCUESTAS ATRAS")
                Toast.makeText(this, "NO HAY MAS ENCUESTAS ATRAS", Toast.LENGTH_SHORT).show()
            }
        }

        val btnCloss=findViewById<Button>(R.id.btncerrar)
        btnCloss.setOnClickListener{
                finish();
            println("FIN DE LA APLICACIÓN")
        }

    }
    private fun mostrarPreguntas() {

        val TextoPregunta = findViewById<TextView>(R.id.tvPregunta)
        TextoPregunta.text = preguntas[posicionActual].enunciado

    }

    fun caragrPreguntas() {
        preguntas.add(Pregunta(enunciado = "Caracas es la capital de Venesuela ?",true))
        preguntas.add(Pregunta(enunciado = "Piura es un departamento que pertenece a Ecuador ?",false))
        preguntas.add(Pregunta(enunciado = "Uruguay es un pais Latino Americano ?",true))
        preguntas.add(Pregunta(enunciado = "Lima es la Capital de Chile ?",false))
        preguntas.add(Pregunta(enunciado = "Perú esta en el continente de Americano ?",true))

    }
}