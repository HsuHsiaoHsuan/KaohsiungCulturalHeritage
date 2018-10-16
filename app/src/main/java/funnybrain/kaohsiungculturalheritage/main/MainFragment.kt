package funnybrain.kaohsiungculturalheritage.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.main.adapter.DataItemRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainContract.View {

    private var dataList = mutableListOf<DataItem>()
    private var listener: OnListFragmentInteractionListener? = null

    override fun getDataOk(data: List<DataItem>) {
        dataList.clear()
        dataList.addAll(data)
        rv_list.adapter?.notifyDataSetChanged()
        progress_circular.visibility = View.GONE
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_list.layoutManager = LinearLayoutManager(context)
        var dividerItemDecoration = DividerItemDecoration(rv_list.context, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(context!!, R.drawable.divider_6dp)!!)
        rv_list.addItemDecoration(dividerItemDecoration)
        rv_list.adapter = DataItemRecyclerViewAdapter(dataList, listener)
    }

    override fun onDetach() {
        super.onDetach()
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
