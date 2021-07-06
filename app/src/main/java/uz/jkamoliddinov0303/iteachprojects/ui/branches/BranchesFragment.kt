package uz.jkamoliddinov0303.iteachprojects.ui.branches

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import uz.jkamoliddinov0303.iteachprojects.R

class BranchesFragment : Fragment() {

    private lateinit var slideshowViewModel: BranchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProvider(this).get(BranchesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_branches, container, false)
        initializeBarChart(root)
        return root
    }

    private fun initializeBarChart(view: View) {
        val chart = view.findViewById<BarChart>(R.id.branches_bar_chart)

        val visitors = ArrayList<BarEntry>()
        var x = 0
        visitors.add(BarEntry(2014f, 420f))
        visitors.add(BarEntry(2015f, 475f))
        visitors.add(BarEntry(2016f, 510f))
        visitors.add(BarEntry(2017f, 590f))
        visitors.add(BarEntry(2018f, 620f))
        visitors.add(BarEntry(2019f, 700f))
        visitors.add(BarEntry(2020f, 650f))
        visitors.add(BarEntry(2021f, 440f))

//        for (i in 1..20) {
//            x += 25
//            visistors.add(BarEntry((2000 + i).toFloat(), (500 + x).toFloat()))
//        }

        val barDataSet = BarDataSet(visitors, "Visitors")
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)

        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f

        val barData = BarData(barDataSet)
        chart.setFitBars(true)
        chart.data = barData
        chart.description.text = "BarChart Example"
        chart.animateXY(2000,2000)

    }
}