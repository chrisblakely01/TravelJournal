package traveljournal.io.traveljournal.src.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import traveljournal.io.traveljournal.AddNewTripActivity

import traveljournal.io.traveljournal.R
import traveljournal.io.traveljournal.ViewJournalEntryDetailActivity
import traveljournal.io.traveljournal.src.adapter.JournalViewAdapter



class JournalFragment : Fragment() {

    private var mListener: OnJournalEntrySelectedListener? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        val intent = Intent(activity, ViewJournalEntryDetailActivity::class.java).apply {
//            putExtra("123", "this is some extra stuff")
//        }

    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view =  inflater!!.inflate(R.layout.fragment_journal, container, false)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = JournalViewAdapter(activity)

        recyclerView = view.findViewById<RecyclerView>(R.id.journal_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }


        // Inflate the layout for this fragment
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    // Do I need this?
//    fun onButtonPressed(uri: Uri) {
//        if (mListener != null) {
//            mListener!!.onJournalEntrySelected(uri)
//        }
//    }

    // TODO: accept JournalEntryModel
    fun onJournalEntryClicked(int : Int) {
        mListener?.onJournalEntrySelected(int)
    }

    override fun onResume() {
        super.onResume()

        Log.d("JOURNAL FRAGMENT", "Resuming Fragment")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnJournalEntrySelectedListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnJournalEntrySelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnJournalEntrySelectedListener {
        // TODO: Update argument type and name
        fun onJournalEntrySelected(int: Int)
    }

}
