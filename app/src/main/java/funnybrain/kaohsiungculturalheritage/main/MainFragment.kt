package funnybrain.kaohsiungculturalheritage.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.main.adapter.DataItemRecyclerViewAdapter

class MainFragment : Fragment(), MainContract.View {

    private var dataList = mutableListOf<DataItem>()
//    private var dataList: List<DataItem> = ArrayList()

    lateinit var recyclerView: RecyclerView
    private var listener: OnListFragmentInteractionListener? = null
//    lateinit var adapter: DataItemRecyclerViewAdapter

    override fun getDataOk(data: List<DataItem>) {
        dataList.clear()
        dataList.addAll(data)
        recyclerView.adapter?.notifyDataSetChanged()

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
            mPresenter.getData()
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        recyclerView = view.findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.adapter = DataItemRecyclerViewAdapter(dataList, listener)
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
