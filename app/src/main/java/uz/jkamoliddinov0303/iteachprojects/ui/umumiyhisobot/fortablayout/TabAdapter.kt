package uz.jkamoliddinov0303.iteachprojects.ui.umumiyhisobot.fortablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class TabAdapter(
    fragmentManager: FragmentManager,
    val listTitles: MutableList<String>
) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        val fragment1: Fragment = DailyReportFragment()
        val fragment2: Fragment = EachReportFragment()
        when (position) {
            0 -> return fragment1
            1 -> return fragment2
        }
        return fragment1
    }
    override fun getPageTitle(position: Int): CharSequence {
        return listTitles[position]
    }
}