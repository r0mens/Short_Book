package com.roman_druck.short_book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BookDescriptionFragment : BaseFragment() {
    override fun onClickNew() {

    }
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_description, container, false)
    }
    companion object {
        fun newInstance(): BookDescriptionFragment {
            return BookDescriptionFragment()
        }
    }
}