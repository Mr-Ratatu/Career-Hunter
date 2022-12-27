package com.work.found.routing.base

import android.os.Bundle
import androidx.fragment.app.Fragment

object FragmentFactory {
    fun <T : Fragment> createFragment(clazz: Class<T>, bundle: Bundle?): Fragment {
        val fragment = clazz.newInstance()
        fragment.arguments = bundle
        return fragment
    }
}