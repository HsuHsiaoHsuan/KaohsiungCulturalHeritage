package funnybrain.kaohsiungculturalheritage.detail

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import com.tmall.ultraviewpager.UltraViewPager

import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.Utils
import funnybrain.kaohsiungculturalheritage.data.model.DataItem
import funnybrain.kaohsiungculturalheritage.detail.adapter.PhotoAdapter
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    private var data: DataItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getParcelable(ARG_DATA)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    lateinit var photoData: List<String>
    lateinit var photoAdapter: PhotoAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity!!.title = data!!.title

        c_type.text = data!!.type

        photoData = data!!.image
        photoAdapter = PhotoAdapter(fragmentManager, photoData)

        uvp_pager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL)
        uvp_pager.adapter = photoAdapter

        val point = Utils.getWindowScreen(activity!!)
        uvp_pager.updateLayoutParams {
            height = (point.x * (3.0f / 4.0f)).toInt()
        }
        uvp_pager.initIndicator()
        uvp_pager.indicator
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(resources.getColor(R.color.colorPrimary))
                .setNormalColor(resources.getColor(R.color.warm_grey))
                .setMargin(0, 0, 0, 35)
                .setRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4.0f, resources.displayMetrics).toInt())
                .setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM)
                .build()

        tv_title.text = data!!.title
        tv_intro.text = data!!.memo!!.replace("\r\n", "\r\n\r\n")

        tv_memo.text = data!!.desc
    }

    companion object {
        const val ARG_DATA = "DATA"

        @JvmStatic
        fun newInstance(item: DataItem) =
                DetailFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_DATA, item)
                    }
                }
    }
}
