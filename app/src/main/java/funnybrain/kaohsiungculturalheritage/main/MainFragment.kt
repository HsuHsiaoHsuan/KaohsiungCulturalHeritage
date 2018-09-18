package funnybrain.kaohsiungculturalheritage.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.main.adapter.DataItemRecyclerViewAdapter

import funnybrain.kaohsiungculturalheritage.main.dummy.DummyContent
import funnybrain.kaohsiungculturalheritage.main.dummy.DummyContent.DummyItem

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [MainFragment.OnListFragmentInteractionListener] interface.
 */
class MainFragment : Fragment(), MainContract.View {

    private var dataList: List<DataItem> = ArrayList()

    override fun getDataOk(data: List<DataItem>) {
        dataList = data
        recyclerView.adapter = DataItemRecyclerViewAdapter(dataList, listener)

        Log.e("FREEMAN", "getDataOk")
        data.forEach {
            println(it.title)
        }
    }

    override fun getDataFail(msg: String) {
    }

    lateinit var mPresenter: MainContract.Presenter

    override fun setPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DataItemRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        recyclerView = view.findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
            mPresenter.getData()
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("FREEMAN", "onDetach")
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: DataItem?)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
