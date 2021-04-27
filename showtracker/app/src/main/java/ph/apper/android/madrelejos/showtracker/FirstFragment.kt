package ph.apper.android.madrelejos.showtracker

import android.graphics.Insets.add
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.core.view.OneShotPreDrawListener.add
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*
import ph.apper.android.madrelejos.showtracker.model.Show
import ph.apper.android.madrelejos.showtracker.model.ShowGenres
import ph.apper.android.madrelejos.showtracker.model.ShowType

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Created during runtime, not preloaded
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Need to do findViewById, unlike in the MainActivity

        init(view)


    }

    private fun init(view: View) {
        var typeArray = arrayOf(
            ShowType.UNDEFINED.toString(),
            ShowType.ANIME.toString(),
            ShowType.MOVIE.toString(),
            ShowType.OVA.toString(),
            ShowType.SERIES.toString(),
            ShowType.SHORTFILMS.toString()
        )

        var typeGenre = arrayOf(
            ShowGenres.UNDEFINED.toString(),
            ShowGenres.ACTION,
            ShowGenres.ANIMATION,
            ShowGenres.ARTHOUSE,
            ShowGenres.COMEDY,
            ShowGenres.DOCUMENTARY,
            ShowGenres.DRAMA,
            ShowGenres.FANTASY,
            ShowGenres.FOREIGN,
            ShowGenres.HORROR,
            ShowGenres.ROMANCE,
            ShowGenres.SCIFI,
            ShowGenres.THRILLER
        )

        val arrayTypeAdapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, typeArray)
        spinner_type.adapter = arrayTypeAdapter

        val arrayGenreAdapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, typeGenre)
        spinner_genre.adapter = arrayGenreAdapter

        spinner_type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("Spinner Data", "Selected : ${typeArray[position]}")
            }
        }

        spinner_genre.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("Spinner Data", "Selected : ${typeGenre[position]}")
            }
        }

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            //new show add here
            var title = et_title.text.toString()
            var genre: String = spinner_genre.selectedItem.toString() as String
            var type: String = spinner_type.selectedItem.toString() as String
//            SecondFragment.add(Show("Showtime", ShowType.SERIES, ShowGenres.DOCUMENTARY))

            MainActivity.addShow(Show(
                title,
                ShowType.getType(type),
                ShowGenres.getGenre(genre)
            ))

            Log.d("Data", "$title, $genre, $type")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}
