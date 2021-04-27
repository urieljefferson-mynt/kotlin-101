package ph.apper.android.madrelejos.showtracker

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import ph.apper.android.madrelejos.showtracker.adapters.ShowAdapter
import ph.apper.android.madrelejos.showtracker.model.Show
import ph.apper.android.madrelejos.showtracker.model.ShowGenres
import ph.apper.android.madrelejos.showtracker.model.ShowType

class MainActivity : AppCompatActivity() {

    companion object {
        var showList: ArrayList<Show> = ArrayList()
        fun addShow(show: Show){
            showList.add(show)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        populateShow()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun populateShow(){
        showList = ArrayList()

        var temp = Show("Infinity Train", ShowType.SERIES, ShowGenres.ANIMATION)
        showList.add(temp)

        temp = Show("Midsommar", ShowType.MOVIE, ShowGenres.HORROR)
        showList.add(temp)

        temp = Show("They Shall Not Grow Old", ShowType.SERIES, ShowGenres.DOCUMENTARY)
        showList.add(temp)

        temp = Show("Berserk", ShowType.MOVIE, ShowGenres.HORROR)
        showList.add(temp)

        temp = Show("Gravity Falls", ShowType.SERIES, ShowGenres.ANIMATION)
        showList.add(temp)

        temp = Show("The Expanse", ShowType.SERIES, ShowGenres.SCIFI)
        showList.add(temp)

        temp = Show("Midnight Gospel", ShowType.SERIES, ShowGenres.ANIMATION)
        showList.add(temp)

        temp = Show("Bojack Horseman", ShowType.SERIES, ShowGenres.ANIMATION)
        showList.add(temp)

        temp = Show("Mirror Mask", ShowType.MOVIE, ShowGenres.FANTASY)
        showList.add(temp)

        temp = Show("Cat Soup", ShowType.SHORTFILMS, ShowGenres.ANIMATION)
        showList.add(temp)

    }
}