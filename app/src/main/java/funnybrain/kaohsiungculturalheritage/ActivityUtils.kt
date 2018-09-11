package funnybrain.kaohsiungculturalheritage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object ActivityUtils {

    fun addFragmentToActivityWithTag(
            fragmentManager: FragmentManager,
            fragment: Fragment,
            frameId: Int,
            tag: String) {


        fragmentManager
                .beginTransaction()
                .add(frameId, fragment, tag)
                .commitAllowingStateLoss()
    }
}