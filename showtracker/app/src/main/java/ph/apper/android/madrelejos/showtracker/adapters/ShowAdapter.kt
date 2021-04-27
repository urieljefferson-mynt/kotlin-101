package ph.apper.android.madrelejos.showtracker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_show_view.view.*
import ph.apper.android.madrelejos.showtracker.R
import ph.apper.android.madrelejos.showtracker.model.Show

class ShowAdapter(val showList: ArrayList<Show>, val context : Context) : RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    class ShowViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val tv_title = view.tv_title
        val tv_type = view.tv_type
        val tv_genre = view.tv_genre
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        //Layout
        return ShowViewHolder(LayoutInflater.from(context).inflate(R.layout.item_show_view, parent, false))
    }

    override fun getItemCount(): Int { 
        return showList.size
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder?.tv_title.text = showList.get(position).title
        holder?.tv_type.text = showList.get(position).type.toString()
        holder?.tv_genre.text = showList.get(position).genre.toString()
    }


}