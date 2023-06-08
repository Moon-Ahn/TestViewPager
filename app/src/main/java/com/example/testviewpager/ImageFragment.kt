package com.example.testviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ImageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_image, container, false)
        val imageView = rootView.findViewById<ImageView>(R.id.imageView)

        val imageResource = arguments?.getInt("imageResource")
        imageResource?.let {
            imageView.setImageResource(it)
        }

        return rootView
    }
}