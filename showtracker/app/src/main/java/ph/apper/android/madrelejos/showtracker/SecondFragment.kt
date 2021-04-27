package ph.apper.android.madrelejos.showtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_second.view.*
import ph.apper.android.madrelejos.showtracker.MainActivity.Companion.showList
import ph.apper.android.madrelejos.showtracker.adapters.ShowAdapter
import ph.apper.android.madrelejos.showtracker.model.Show
import ph.apper.android.madrelejos.showtracker.model.ShowGenres
import ph.apper.android.madrelejos.showtracker.model.ShowType

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    companion object{
        private lateinit var showAdapter : ShowAdapter
        fun updateAdapter(){
            showAdapter.notifyItemInserted(0)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.rv_show.layoutManager=LinearLayoutManager(this.requireActivity().applicationContext)
        view.rv_show.layoutManager= GridLayoutManager(this.requireActivity().applicationContext, 2)

        //Adapter, manages per row in recycler view
        view.rv_show.adapter = ShowAdapter(showList, this.requireActivity().applicationContext)

        showAdapter = ShowAdapter(MainActivity.showList, this.requireActivity().applicationContext)
//        view.rv_show.adapter = showAdapter
        view.rv_show.adapter
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }



}