package uz.jkamoliddinov0303.iteachprojects.ui.chartDiagrams

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.DecimalFormat

class MyValueFormatter : ValueFormatter() {
    private val format = DecimalFormat("###,##0.0")
    // override this for e.g. LineChart or ScatterChart
    override fun getPointLabel(entry: Entry?): String {
        return format.format(entry?.y)+" mln"
    }
//    // override this for BarChart
//    override fun getBarLabel(barEntry: BarEntry?): String {
//        return format.format(barEntry?.y)
//    }
//    // override this for custom formatting of XAxis or YAxis labels
//    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
//        return format.format(value)
//    }
//    // ... override other methods for the other chart types
}