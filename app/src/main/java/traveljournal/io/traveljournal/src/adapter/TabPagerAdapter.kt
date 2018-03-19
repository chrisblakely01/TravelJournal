package traveljournal.io.traveljournal.src.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import traveljournal.io.traveljournal.src.fragment.JournalFragment
import traveljournal.io.traveljournal.src.fragment.TripsFragment

class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int) :
        FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> return JournalFragment()
            1 -> return TripsFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}