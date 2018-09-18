package funnybrain.kaohsiungculturalheritage.detail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import funnybrain.kaohsiungculturalheritage.detail.PhotoFragment

class PhotoAdapter(fm: FragmentManager?, photoList: List<String>) : FragmentStatePagerAdapter(fm) {

    var data = photoList

    override fun getItem(position: Int): Fragment {
        return PhotoFragment.newInstance(data[position])
    }

    override fun getCount(): Int {
        return data.count()
    }

}