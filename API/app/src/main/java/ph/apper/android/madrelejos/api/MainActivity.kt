package ph.apper.android.madrelejos.api

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pokemoninfo.*
import ph.apper.android.madrelejos.api.viewAdapter.PokemonInfoAdapter


class MainActivity : AppCompatActivity() {
    val pokemonListFragment = PokemonListFragment()
    val pokemonImageFragment = PokemonImageFragment()
    val pokemonInfoFragment = PokemonInfoFragment()

    private lateinit var pokemonInfoAdapter : PokemonInfoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_holder, pokemonListFragment)
            .commit()

        pokemonInfoAdapter = PokemonInfoAdapter(supportFragmentManager)
        pokemonInfoAdapter.add(pokemonInfoFragment, "Pokemon Information")
        pokemonInfoAdapter.add(pokemonImageFragment, "Pokemon Image")
        pokemon_info_viewpager.adapter = pokemonInfoAdapter
    }
}