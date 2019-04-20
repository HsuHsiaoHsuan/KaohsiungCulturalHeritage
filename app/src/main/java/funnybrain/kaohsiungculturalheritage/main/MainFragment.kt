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
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.main.adapter.DataItemRecyclerViewAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.themedRecyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.find

class MainFragment : Fragment(), MainContract.View {

    private var dataList = mutableListOf<DataItem>()
    private var listener: OnListFragmentInteractionListener? = null

    lateinit var rv_list: RecyclerView

    override fun getDataOk(data: List<DataItem>) {
        dataList.clear()
        dataList.addAll(data)
        rv_list.adapter!!.notifyDataSetChanged()
        Logger.e("HIHI")
    }

    override fun getDataFail(msg: String) {
        Logger.e(msg)
    }

    lateinit var mPresenter: MainContract.Presenter

    override fun setPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return UI{
            constraintLayout {
                lparams(width = matchParent, height = matchParent)

                themedRecyclerView {
                    id = R.id.data_list
                    overScrollMode = View.OVER_SCROLL_NEVER
                }.lparams(width = matchParent, height = matchParent) {
                    horizontalMargin = dip(16)
                }
            }
        }.view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_list = find(R.id.data_list)
        rv_list.layoutManager = LinearLayoutManager(context)
        var dividerItemDecoration = DividerItemDecoration(rv_list.context, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(context!!, R.drawable.divider_6dp)!!)
        rv_list.addItemDecoration(dividerItemDecoration)
        rv_list.adapter = DataItemRecyclerViewAdapter(dataList, listener)

        mPresenter.getData(activity!!)
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
//        @IdRes val ID_PROGRESS = View.generateViewId()
    }
}
