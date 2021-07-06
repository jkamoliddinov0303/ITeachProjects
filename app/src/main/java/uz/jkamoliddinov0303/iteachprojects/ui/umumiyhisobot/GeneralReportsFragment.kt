package uz.jkamoliddinov0303.iteachprojects.ui.umumiyhisobot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_general_reports.*
import uz.jkamoliddinov0303.iteachprojects.R
import uz.jkamoliddinov0303.iteachprojects.ui.umumiyhisobot.fortablayout.TabAdapter

@Suppress("DEPRECATION")
class GeneralReportsFragment : Fragment() {

    private lateinit var generalReportsViewModel: GeneralReportsViewModel
    private val titles: MutableList<String> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        titles.apply {
            add("Kunlik")
            add("Umumiy")
        }
        return inflater.inflate(R.layout.fragment_general_reports, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabAdapter = TabAdapter(fragmentManager = this.requireFragmentManager(), titles)
        view_pager_reports.adapter = tabAdapter
        reports_tab_layout.setupWithViewPager(view_pager_reports)
        setMarginTabItems()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setMarginTabItems() {
        for (i in 0 until reports_tab_layout.tabCount) {
            val tabItem = (reports_tab_layout.getChildAt(0) as ViewGroup).getChildAt(i)
            val params = tabItem.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(25, 25, 25, 0)
            params.width = 270
            params.height = 100
        }
    }
}