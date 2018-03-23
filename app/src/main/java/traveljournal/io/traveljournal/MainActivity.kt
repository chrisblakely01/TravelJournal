package traveljournal.io.traveljournal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.TabLayout
import android.util.Log
import traveljournal.io.traveljournal.src.fragment.JournalFragment
import traveljournal.io.traveljournal.src.adapter.TabPagerAdapter
import traveljournal.io.traveljournal.src.fragment.TripsFragment


class MainActivity : AppCompatActivity(),
        TripsFragment.OnTripSelectedListener,
        JournalFragment.OnJournalEntrySelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        configureTabLayout()

        fab.setOnClickListener { view ->
            /** Called when the user taps the Send button */
            //val editText = findViewById<EditText>(R.id.editText)
            //val message = editText.text.toString()
            val intent = Intent(this, AddNewTripActivity::class.java).apply {
                putExtra("123", "this is some extra stuff")
            }
            startActivity(intent)
        }

    }


    //tab_layout & pager automatically map to the ids of the components
    private fun configureTabLayout() {

        //get tab layout by id, add new tab
        tab_layout.addTab(tab_layout.newTab().setText("Journal"))
        tab_layout.addTab(tab_layout.newTab().setText("Trips"))

        //pass to adapter
        //TODO order tabs are initialised here need to match the ordering of getItem in adapter
        val adapter = TabPagerAdapter(supportFragmentManager,
                tab_layout.tabCount)

        pager.adapter = adapter

        pager.addOnPageChangeListener(
                TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
    }

    override fun onJournalEntrySelected(int: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        Log.d("JOURNAL VIEW CLICKED", "Clicked item with URI: " + int)




//        val intent = Intent(this, ViewJournalEntryDetailActivity::class.java).apply {
//            putExtra("123", "this is some extra stuff")
//        }
//        startActivity(intent)
    }

    override fun onTripSelected(uri: Uri) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        Log.d("TRIP VIEW CLICKED", "Clicked item with URI: " + uri)
    }

}
