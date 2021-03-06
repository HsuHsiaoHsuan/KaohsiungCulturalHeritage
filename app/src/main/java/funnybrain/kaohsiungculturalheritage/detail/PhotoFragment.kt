package funnybrain.kaohsiungculturalheritage.detail


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.request.ImageRequestBuilder
import funnybrain.kaohsiungculturalheritage.R
import kotlinx.android.synthetic.main.fragment_photo.*
import org.jetbrains.anko.include
import org.jetbrains.anko.support.v4.UI

private const val PIC_URL = "param1"

class PhotoFragment : Fragment() {
    private var picUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            picUrl = it.getString(PIC_URL, "")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return UI {
            include<View>(R.layout.fragment_photo)
        }.view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val request = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse(picUrl))
                .disableDiskCache()
                .setProgressiveRenderingEnabled(true)
                .build()
        sdv_image.controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(sdv_image.controller)
                .build()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
                PhotoFragment().apply {
                    arguments = Bundle().apply {
                        putString(PIC_URL, param1)
                    }
                }
    }
}
