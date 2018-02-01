package com.mitnick.tannotour.smartutlis.gaea.dynamic.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.*

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */
class GaeaDynamicFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val mFragments: LinkedList<Fragment> = LinkedList()
    private val mTitles: LinkedList<String> = LinkedList()

    fun addFragment(fragment: Fragment, title: String) {
        mFragments.add(fragment)
        mTitles.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }
}