package uz.jkamoliddinov0303.iteachprojects.ui.chartDiagrams

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter

class MyYAxisFormatter:ValueFormatter(){
    private val labels = arrayOf(20,21,22,23,24,25,26,27,28,29,30)
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        //val result = String.format("%0.2f",value).toFloat()
        //Log.d("TESTAXISLABEL", String.format("%0.2f",value))
        return (labels.getOrNull(value.toInt()) ?: "$value mln") as String
    }
}