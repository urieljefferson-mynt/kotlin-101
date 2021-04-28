package ph.apper.android.madrelejos.api.viewAdapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_pokemonlist_row.view.*
import ph.apper.android.madrelejos.api.R
import ph.apper.android.madrelejos.api.model.Pokemon

class PokemonAdapter(private val context: Context,
                     private var pokemonList: ArrayList<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_pokemonlist_row, parent, false)
        )


    override fun getItemCount() = pokemonList.size

    fun setList(pokemonlist: ArrayList<Pokemon>){
        this.pokemonList.clear()
        this.pokemonList.addAll(pokemonlist)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val pokemon_name = view.pokemon_name
        public var btn_view_data = view.btn_view_data

        fun bindItems(pokemon: Pokemon){
            pokemon_name.text = pokemon.name
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(pokemonList[position])
        holder.btn_view_data.setOnClickListener{
            Log.d("Pokemon", pokemonList[position].name)


            Intent().also{
                Log.d("Pokemon", pokemonList[position].url)
                it.setAction("ph.apper.android.api.broadcast.GETDATA")
                it.putExtra("data", pokemonList[position].url)
                context.sendBroadcast(it)
            }
        }
    }

}