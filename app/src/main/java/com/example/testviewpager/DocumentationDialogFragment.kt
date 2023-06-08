package com.example.testviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class DocumentationDialogFragment : DialogFragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var pagerAdapter: DocumentationPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.dialog_documentation, container, false)

        // Initialize the ViewPager2 and its adapter
        viewPager = rootView.findViewById(R.id.viewPager)
        pagerAdapter = DocumentationPagerAdapter(requireContext() as FragmentActivity)
        viewPager.adapter = pagerAdapter

        val btnClose = rootView.findViewById<ImageButton>(R.id.btnClose)
        btnClose.setOnClickListener {
            dismiss()
        }

        return rootView
    }
    override fun onResume() {
        super.onResume()
        // Adjust the width of the dialog window
        val width = resources.displayMetrics.widthPixels
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}

class DocumentationPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val imageResources = arrayOf(
        R.drawable.onboarding1,
        R.drawable.onboarding2,
        R.drawable.onboarding3,
        R.drawable.power2
    )
    override fun createFragment(position: Int): Fragment {
        val fragment = ImageFragment()
        fragment.arguments = Bundle().apply {
            putInt("imageResource", imageResources[position])
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return imageResources.size
    }
}

class DocumentationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_documentation, container, false)
        // Initialize and set up the content of the documentation page
        // You can access the views in the layout using rootView.findViewById()
        return rootView
    }
}