package com.example.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.teste.databinding.ActivityPokemonBinding

class Pokemon : AppCompatActivity() {
    lateinit var binding: ActivityPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_pokemon)
        setContentView(binding.root)

        val pokemons = arrayListOf("Escolha um Pokemon", "Bulbassauro", "Charmander", "Squirtle")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemons)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, spinner: View?, posicao: Int, id: Long) {

                when(posicao){
                    1 -> {
                        val imagemBulbassauro = getDrawable(R.drawable.bulbassauro)
                        binding.imageView.setImageDrawable(imagemBulbassauro)
                    }
                    2 -> {
                        val imagemCharmander = getDrawable(R.drawable.charmander)
                        binding.imageView.setImageDrawable(imagemCharmander)
                    }
                    3 ->{
                        val imagemSquirtle = getDrawable(R.drawable.squirtle)
                        binding.imageView.setImageDrawable(imagemSquirtle)
                    }
                    else -> {
                        binding.imageView.setImageDrawable(null)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.button2.setOnClickListener {
            when(binding.spinner.selectedItemPosition){
                1 -> alert("Tipo do Pokemon", "Grama/Veneno", this)
                2 -> alert("Tipo do Pokemon", "Fogo", this)
                3 -> alert("Tipo do Pokemon", "Agua", this)
                else -> alert("Erro" , "Selecione um pokemon", this)
            }
        }


    }

}