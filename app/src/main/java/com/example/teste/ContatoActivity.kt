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

            alert("${getString(R.string.Confirmação)}", msg, this)
        }
        binding.editTel.isEnabled = binding.checkBoxTelefone.isChecked
        binding.editEmail.isEnabled = binding.checkBoxEmail.isChecked


        binding.checkBoxTelefone.setOnCheckedChangeListener { checkbox, marcado ->
                binding.editTel.isEnabled = marcado
        }
             binding.checkBoxEmail.setOnCheckedChangeListener { checkbox, marcado ->
                 binding.editEmail.isEnabled = marcado
             }

        }


}