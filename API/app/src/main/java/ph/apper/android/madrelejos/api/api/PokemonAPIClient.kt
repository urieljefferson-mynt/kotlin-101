package ph.apper.android.madrelejos.api.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonAPIClient {
    val BASE_URL = "https://pokeapi.co/api/v2/"

    val getPokemonData: PokemonAPI
        get(){
            //Response
            val gson = GsonBuilder().setLenient().create()
            //responsible for getting the ocntent
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            //responsible for doing the call
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(PokemonAPI::class.java)
        }

}