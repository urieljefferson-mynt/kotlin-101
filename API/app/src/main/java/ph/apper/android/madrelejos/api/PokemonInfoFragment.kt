package ph.apper.android.madrelejos.api

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_pokemoninfo.*
import ph.apper.android.madrelejos.api.api.PokemonAPIClient
import ph.apper.android.madrelejos.api.extensions.getPokemonID
import ph.apper.android.madrelejos.api.model.PokemonInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonInfoFragment: Fragment() {

    private val receiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            var message: String? = intent!!.getStringExtra("data")
            Log.d("ON RECEIVE INFO", message!!)
            message?.let{
                getData(message.getPokemonID())

            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupReceiver()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_pokemoninfo, container, false)

        return view

    }
    private fun setupReceiver(){
        val intentFilter = IntentFilter()
        intentFilter.addAction("ph.apper.android.api.broadcast.GETDATA")
        activity!!.registerReceiver(receiver, intentFilter)
    }

    override fun onDestroyView() {
        activity!!.unregisterReceiver(receiver)
        super.onDestroyView()
    }

    private fun getData(id: Int){
        val call: Call<PokemonInfoResponse> =
            PokemonAPIClient.getPokemonData.getPokemonInfo(id)

        call.enqueue(object : Callback<PokemonInfoResponse> {
            override fun onFailure(call:Call<PokemonInfoResponse>, t: Throwable){
                Log.d("API Call", "FAILED")
                }

            override fun onResponse(
                call: Call<PokemonInfoResponse>,
                response: Response<PokemonInfoResponse>) {
                var response: PokemonInfoResponse = response!!.body()!!


                Intent().also{
                    Log.d("Pokemon", "${response.sprites.front_default}")
                    it.setAction("ph.apper.android.api.broadcast.LOADIMAGEACTION")
                    it.putExtra("data", response.sprites.front_default)
                    context!!.sendBroadcast(it)
                }

                Log.d("ID", response.id.toString())
                Log.d("Name", response.name)
                Log.d("height", response.height.toString())

                var pokemonAbilities = ArrayList<String>()

                for(ability in response.abilities){
                    pokemonAbilities.add(ability.ability.name.capitalize())
                }

                pokemon_name.text = response.name.toUpperCase()
                pokemon_height.text = response.height.toString()
                pokemon_abilities.text = pokemonAbilities.joinToString(separator =  ", ")

                }

        })

    }
}






