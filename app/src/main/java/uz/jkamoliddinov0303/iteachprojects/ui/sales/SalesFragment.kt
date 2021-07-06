package uz.jkamoliddinov0303.iteachprojects.ui.sales

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import uz.jkamoliddinov0303.iteachprojects.R
import uz.jkamoliddinov0303.iteachprojects.ui.chartDiagrams.MyXAxisFormatter

class SalesFragment : Fragment() {
    private lateinit var chartLine: LineChart

    private lateinit var homeViewModel: SalesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sales, container, false)
        initializeLineChart(root)
        initializeBarChart(root)
        return root
    }

    private fun initializeBarChart(view: View) {
        val chart = view.findViewById<BarChart>(R.id.sales_bar_chart)

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
        chart.animateXY(2000, 2000)
    }

    private fun initializeLineChart(view: View) {
        chartLine = view.findViewById<LineChart>(R.id.sales_line_chart)

        chartLine.setViewPortOffsets(0f, 0f, 0f, 0f)
        chartLine.setBackgroundColor(Color.WHITE)

        // description text
        chartLine.description.isEnabled = true
        chartLine.description.text = "Statistika"


        // enable touch gestures
        chartLine.setTouchEnabled(true)

        // enable scaling and dragging
        chartLine.isDragEnabled = true
        chartLine.setScaleEnabled(true)


        // if disabled, scaling can be done on x- and y-axis separately
        chartLine.setPinchZoom(false)

        chartLine.setDrawGridBackground(false)
        chartLine.maxHighlightDistance = 300f
        val myFormat = MyXAxisFormatter()
        val x = chartLine.xAxis
//        x.isEnabled = true
        x.typeface = Typeface.DEFAULT_BOLD
        x.setLabelCount(7, true)
        x.valueFormatter = myFormat
        x.textColor = Color.BLACK
        x.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        x.setDrawGridLines(false)
        x.axisLineColor = ContextCompat.getColor(requireContext(), R.color.purple_700)

        val y = chartLine.axisLeft
        y.typeface = Typeface.SERIF
        y.setLabelCount(6, true)
        y.textColor = Color.BLACK
        y.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
        y.setDrawGridLines(false)
        y.axisLineColor = ContextCompat.getColor(requireContext(), R.color.purple_700)

        chartLine.axisRight.isEnabled = true

        chartLine.legend.isEnabled = true

        chartLine.animateXY(2000, 2000)

        // don't forget to refresh the drawing
        chartLine.invalidate()
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
        if (chartLine.data != null && chartLine.data.dataSetCount > 0) {
            set1 = chartLine.data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            chartLine.data.notifyDataChanged()
            chartLine.notifyDataSetChanged()
        } else {
            //create a dataset and give it a type
            set1 = LineDataSet(values, "DataSet1")
            set1.mode = LineDataSet.Mode.CUBIC_BEZIER
            set1.cubicIntensity = 0.2f;
            set1.setDrawFilled(true);
            set1.setDrawCircles(true);
            set1.lineWidth = 1.8f;
            set1.circleRadius = 4f;
            set1.setCircleColor(Color.WHITE);
            set1.highLightColor = Color.rgb(244, 117, 117);
            set1.color = ActivityCompat.getColor(requireContext(), R.color.setcolor);
            set1.fillColor = Color.GREEN;
            set1.fillAlpha = 100
            set1.fillDrawable = requireActivity().getDrawable(R.drawable.linechart_back)
            set1.setDrawHorizontalHighlightIndicator(false);

            set1.fillFormatter =
                IFillFormatter { _,
                                 _ ->
                    chartLine.axisLeft.axisMinimum
                }
        }
        // create a data object with the data sets
        val data = LineData(set1)
        data.setValueTypeface(Typeface.DEFAULT)
        data.setValueTextSize(9f)
        data.setDrawValues(true)

        // set data
        chartLine.data = data
        Log.d("TAGCHART", "${set1}")
    }
}