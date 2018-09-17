package funnybrain.kaohsiungculturalheritage.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import funnybrain.kaohsiungculturalheritage.R
import funnybrain.kaohsiungculturalheritage.data.model.DataItem

//private const val ARG_DATA = "DATA"
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
