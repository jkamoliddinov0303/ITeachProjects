package uz.jkamoliddinov0303.iteachprojects.ui.umumiyhisobot.fortablayout

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate
import uz.jkamoliddinov0303.iteachprojects.R
import uz.jkamoliddinov0303.iteachprojects.ui.chartDiagrams.MyValueFormatter
import uz.jkamoliddinov0303.iteachprojects.ui.chartDiagrams.MyXAxisFormatter

class EachReportFragment : Fragment() {
    private lateinit var chart: LineChart
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_each_report, container, false)
        initializeLineChart(view)
        initializePieChart(view)
        Log.d("test_repost_general", "keldi")
        return view
    }

    private fun initializePieChart(view: View) {
        val chart = view.findViewById<PieChart>(R.id.general_report_pie_chart)
        chart.animateXY(3000, 3000)
        val visitors = ArrayList<PieEntry>()
        visitors.add(PieEntry(508f, "2016"))
        visitors.add(PieEntry(600f, "2017"))
        visitors.add(PieEntry(750f, "2018"))
        visitors.add(PieEntry(640f, "2019"))
        visitors.add(PieEntry(570f, "2020"))
        visitors.add(PieEntry(700f, "2021"))
        val pieDataSet = PieDataSet(visitors, "Visitors")
        pieDataSet.setAutomaticallyDisableSliceSpacing(true)
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS, 255)
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 16f
        val pieData = PieData(pieDataSet)
        chart.data = pieData
        chart.description.isEnabled = false
        chart.centerText = "Visitors"
        chart.animate()
    }

    private fun initializeLineChart(view: View) {
        chart = view.findViewById<LineChart>(R.id.general_report_line_chart)

        chart.setViewPortOffsets(200f, 100f, 100f, 100f)
        chart.setBackgroundColor(Color.WHITE)

        // description text
        chart.description.isEnabled = true
        chart.description.text = "Statistika"

        chart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                e?.icon = ContextCompat.getDrawable(requireContext(), R.drawable.linechart_back)
            }

            override fun onNothingSelected() {
                TODO("Not yet implemented")
            }

        })

        // enable touch gestures
        chart.setTouchEnabled(true)

        // enable scaling and dragging
        chart.isDragEnabled = true
        chart.setScaleEnabled(true)


        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false)

        chart.setDrawGridBackground(false)
        chart.maxHighlightDistance = 300f
        val myFormat = MyXAxisFormatter()
        val x = chart.xAxis
        x.typeface = Typeface.DEFAULT_BOLD
        x.setLabelCount(7, true)
        x.valueFormatter = myFormat
        x.textColor = Color.BLACK
        x.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        x.setDrawGridLines(false)
        x.axisLineColor = ContextCompat.getColor(requireContext(), R.color.purple_700)

        val y = chart.axisLeft
        y.isEnabled = true
        y.typeface = Typeface.SERIF
        y.setLabelCount(6, true)
        y.textColor = Color.BLACK
        y.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        y.setDrawGridLines(false)
        y.axisLineColor = ContextCompat.getColor(requireContext(), R.color.purple_700)
        chart.axisRight.isEnabled = false

        chart.legend.isEnabled = true

        chart.animateXY(2000, 2000)

        // don't forget to refresh the drawing
        chart.invalidate()
        setData()
//        Log.d("TAGTEST1", "onViewCreated: ")
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setData() {
        //for set1
        val values = ArrayList<Entry>()
        for (i in 0 until 7) {
            val z = (Math.random() * (5 + 1)).toFloat() + 20
            values.add(Entry(i.toFloat(), z))
        }
        var set1 = LineDataSet(null, null)
        if (chart.data != null && chart.data.dataSetCount > 0) {
            set1 = chart.data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            set1.setDrawCircleHole(true)
            set1.circleHoleColor = 4
            set1.circleHoleColor = Color.GREEN
            chart.data.notifyDataChanged()
            chart.notifyDataSetChanged()
        } else {
            //create a dataset and give it a type
            set1 = LineDataSet(values, "Kirim")
            set1.mode = LineDataSet.Mode.CUBIC_BEZIER
            set1.cubicIntensity = 0.2f
            set1.setDrawFilled(true)
            set1.setDrawCircles(false)
            set1.setDrawCircleHole(true)
            set1.circleHoleColor = 4
            set1.circleHoleColor = Color.GREEN
            set1.lineWidth = 1.8f
            set1.circleRadius = 4f
            set1.setCircleColor(Color.BLUE)
            set1.highLightColor = Color.rgb(244, 117, 117)
            set1.color = Color.BLUE
            set1.fillColor = Color.BLUE
            set1.fillAlpha = 10
            set1.setDrawHorizontalHighlightIndicator(false)
            set1.fillFormatter =
                IFillFormatter { _,
                                 _ ->
                    chart.axisLeft.axisMinimum
                }
            set1.setDrawCircleHole(true)
            set1.circleHoleColor = 4
            set1.circleHoleColor = Color.GREEN
            set1.valueFormatter = MyValueFormatter()
        }

        //for set1
        val values2 = ArrayList<Entry>()
        for (i in 0 until 7) {
            val z = (Math.random() * (5 + 1)).toFloat() + 20
            values2.add(Entry(i.toFloat(), z))
        }
        var set2 = LineDataSet(null, null)
        if (chart.data != null && chart.data.dataSetCount > 0) {
            set2 = chart.data.getDataSetByIndex(0) as LineDataSet
            set2.values = values2
            chart.data.notifyDataChanged()
            chart.notifyDataSetChanged()
        } else {
            //create a dataset and give it a type
            set2 = LineDataSet(values2, "Chiqim")
            set2.mode = LineDataSet.Mode.CUBIC_BEZIER
            set2.cubicIntensity = 0.2f
            set2.setDrawFilled(true)
            set2.setDrawCircles(true)
            set2.lineWidth = 1.8f
            set2.circleRadius = 2f
            set2.setCircleColor(Color.RED)
            set2.highLightColor = Color.rgb(244, 117, 117)
            set2.color = Color.RED
            set2.fillColor = Color.RED
            set2.fillAlpha = 10
            set2.setDrawHorizontalHighlightIndicator(false)
            set2.fillFormatter =
                IFillFormatter { _,
                                 _ ->
                    chart.axisLeft.axisMinimum
                }
        }
        // create a data object with the data sets
        val f = uz.jkamoliddinov0303.iteachprojects.ui.umumiyhisobot.utils.MyValueFormatter()
        set2.valueFormatter = f
        set1.setDrawValues(false)
        set2.setDrawValues(false)
        val data = LineData(set1, set2)
        data.setValueTypeface(Typeface.DEFAULT)
        data.setValueTextSize(9f)
        data.setDrawValues(false)

        // set data
        chart.data = data
        Log.d("TAGCHART", "${set1}")
    }
}