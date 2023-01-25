package com.roman_druck.short_book

import androidx.appcompat.app.AppCompatActivity

object FragmentManager {
    var currentFrag: BaseFragment? = null

    fun setFragment(newFrag: BookDescriptionFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFrag)
        transaction.commit()
        currentFrag = newFrag
    }
}