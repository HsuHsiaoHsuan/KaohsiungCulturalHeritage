package funnybrain.kaohsiungculturalheritage.main.adapter

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem


import funnybrain.kaohsiungculturalheritage.main.MainFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.list_item_main.view.*

class DataItemRecyclerViewAdapter(
        private val mValues: MutableList<DataItem>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<DataItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->

            val item = v.tag as DataItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mTvTitle.text = item.title
        holder.mTvType.text = item.type
        val request: ImageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse(item.image[0]))
                .disableDiskCache()
                .setProgressiveRenderingEnabled(true)
                .build()
        val controller: DraweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(holder.mImage.controller)
                .build()
        holder.mImage.controller = controller

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTvTitle: TextView = mView.tv_title
        val mTvType: TextView = mView.tv_type
        val mImage: SimpleDraweeView = mView.iv_photo

        override fun toString(): String {
            return super.toString() + " '" + mTvType.text + "'"
        }
    }
}
