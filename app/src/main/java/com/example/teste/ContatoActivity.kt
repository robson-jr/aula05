package com.example.teste

import android.app.Activity
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teste.databinding.ActivityContatoBinding

class ContatoActivity : AppCompatActivity() {

    lateinit var binding: ActivityContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIr.setOnClickListener {
            val msg = """ ${getString(R.string.nome)}: ${binding.editNome.text}
            |${getString(R.string.telefone)} : ${binding.editTel.text}
            |${getString((R.string.email))}: ${binding.editEmail.text}
            |
            |${getString(R.string.contato_tel)}: ${if (binding.checkBoxTelefone.isChecked) "${getString(R.string.Sim)}" else "${getString(R.string.Não)}" }
            |${getString(R.string.contato_email)}: ${if (binding.checkBoxEmail.isChecked) "${getString(R.string.Sim)}" else "${getString(R.string.Não)}"}
        """.trimMargin()

            alert("${getString(R.string.Confirmação)}", msg)
        }


    }

    fun alert(titulo: String,msg:String){
        AlertDialog.Builder(this)
        .setTitle(titulo)
            .setMessage(msg)
            .setPositiveButton("OK", null)
            .create()
            .show()
    }
}