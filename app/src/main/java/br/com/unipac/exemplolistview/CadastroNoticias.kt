package br.com.unipac.exemplolistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CadastroNoticias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_noticias)

        val tituloEdt = findViewById<EditText>(R.id.tituloEdt)
        val conteudoEdt = findViewById<EditText>(R.id.conteudoEdt)
        val salvarBtn = findViewById<Button>(R.id.salvarBtn)

        salvarBtn.setOnClickListener {
            val titulo = tituloEdt.text.toString()
            val conteudo = conteudoEdt.text.toString()

            Toast.makeText(this@CadastroNoticias, "Noticia $titulo - $conteudo", Toast.LENGTH_LONG).show()

            val intent = Intent(this@CadastroNoticias, MainActivity::class.java)
            intent.putExtra("titulo", titulo)
            intent.putExtra("conteudo", conteudo)
            startActivity(intent)
        }
    }
}