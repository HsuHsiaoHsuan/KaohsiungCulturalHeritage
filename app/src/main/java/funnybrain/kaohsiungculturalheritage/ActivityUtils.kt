package funnybrain.kaohsiungculturalheritage

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

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