package com.mitnick.tannotour.smartutlis.gaea.magnetic

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.tools.TipDialog
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import kotlinx.android.synthetic.main.gaea_magnetic_monitor_activity.*
import org.jetbrains.anko.toast
import java.util.*


/**
 * Created by mitnick on 2018/2/5.
 * Description
 */
class GaeaMagneticMonitorActivity: AppCompatActivity(), GaeaMagneticFuncs, SensorEventListener {

    private lateinit var user: UserBean
    private lateinit var sensorManager: SensorManager
    //记录rotationMatrix矩阵值
    private var r = FloatArray(9)
    private var gravity: FloatArray? = null
    private var geomagnetic: FloatArray? = null
    private var I = FloatArray(9)
    /* 计时变量 */
    private var time = 15
    /* 图表数据 */
    private val values = LinkedList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_magnetic_monitor_activity)
        QMUIDialog.MessageDialogBuilder(this)
                .setTitle("提示")
                .setMessage("使用前请先按照画倒八字方法校准手机")
                .addAction("确定") { dialog, _ ->
                    dialog.dismiss()
                }.show()
        init()
        user = intent.getParcelableExtra<UserBean>("user")
    }

    override fun onPause() {
        super.onPause()
        stopListen()
    }

    private fun init(){
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        magneticMonitorStartButton.setOnClickListener {
            time = 15
            initChart()
            val sensor1 = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            sensorManager.registerListener(this, sensor1, SensorManager.SENSOR_DELAY_UI)
            val sensor2 = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
            sensorManager.registerListener(this, sensor2, SensorManager.SENSOR_DELAY_UI)
            magneticMonitorStartButton.visibility = View.GONE
            magneticMonitorChart.visibility = View.VISIBLE
            magneticMonitorClock.postDelayed(handler,1000)
        }
        magneticMonitorResultText.setOnClickListener {
            val tip = TipDialog.showTip(magneticMonitorResultText, QMUITipDialog.Builder.ICON_TYPE_LOADING, "正在上传", autoDismiss = false)
            addScore(
                    true,
                    user,
                    "2"
            ){
                when(it){
                    STATE.SUCCESS -> {
                        toast("上传成功，获得3积分")
                    }
                    STATE.FAILED -> {
                        toast("上传失败")
                    }
                }
                tip.dismiss()
                magneticMonitorResultText.visibility = View.GONE
                magneticMonitorChart.visibility = View.GONE
                magneticMonitorStartButton.visibility = View.VISIBLE
            }
        }
        magneticMonitorCancel.setOnClickListener { finish() }
    }

    val handler = object : Runnable{
        override fun run() {
            if(time <= 0){
                stopListen()
                var avg = 0f
                var min = Float.MAX_VALUE
                var max = Float.MIN_VALUE
                values.forEach {
                    avg += it.y
                    if(min > it.y){
                        min = it.y
                    }
                    if(max < it.y){
                        max = it.y
                    }
                }
                avg /= values.size
                values.clear()
                var msg = ""
                if (max - min > 3.5){
                    msg = "磁场波动异常"
                }else {
                    msg = "磁场波动正常"
                }
                if(avg > 70 || avg < 20){
                    msg += "\n当前磁场异常，注意周围的电磁设备，已经影响健康"
                } else{
                    msg += "\n当前磁场正常"
                }
                magneticMonitorChart.visibility = View.GONE
                magneticMonitorResultText.text = "监测完成\n\n$msg\n\n点击上传本次实时数据（可得3积分）"
                magneticMonitorResultText.visibility = View.VISIBLE
            }else{
                time -= 1
                magneticMonitorClock.postDelayed(this,1000)
            }
        }

    }

    override fun onAccuracyChanged(sensorEvent: Sensor, p1: Int) {

    }

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        when (sensorEvent.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> {
                gravity = sensorEvent.values
                compute()
            }
            Sensor.TYPE_MAGNETIC_FIELD -> {
                geomagnetic = sensorEvent.values
                compute()
            }
        }
    }

    fun compute(){
        if (gravity != null && geomagnetic != null) {
            if (SensorManager.getRotationMatrix(r, I, gravity, geomagnetic)) {
//                val gri = gravity!![0] * r[6] + gravity!![1] * r[7] + gravity!![2] * r[8]
                val h = (I[3] * r[0] + I[4] * r[3] + I[5] * r[6]) * geomagnetic!![0] +
                        (I[3] * r[1] + I[4] * r[4] + I[5] * r[7]) * geomagnetic!![1] +
                        (I[3] * r[2] + I[4] * r[5] + I[5] * r[8]) * geomagnetic!![2]
                magneticMonitorClock.setMagneticText((h+0.5).toInt().toString())
                addValue(h)
            }
        }
    }

    fun addValue(value: Float){
        values.removeFirst()
        for (index in 0 until values.size){
            val entry = values[index]
            entry.x = entry.x - 1
            values[index] = entry
        }
        val entryNew = Entry(values.size.toFloat(), value)
        values.add(entryNew)
        refreshChartData()
    }

    fun initChart() {
        values.clear()
        (0..100).mapTo(values) { Entry(it.toFloat(), 40f) }
        // 不显示数据描述
        magneticMonitorChart.description.isEnabled = false
        // 没有数据的时候，显示“暂无数据”
        magneticMonitorChart.setNoDataText("暂无数据")
        // 不显示表格颜色
        magneticMonitorChart.setDrawGridBackground(false)
        // 设置是否可以触摸
        magneticMonitorChart.setTouchEnabled(false)
        // 是否可以拖拽
        magneticMonitorChart.isDragEnabled = false
        // 是否可以缩放
        magneticMonitorChart.setScaleEnabled(false)
        // 集双指缩放
        magneticMonitorChart.setPinchZoom(false)
        // 不显示y轴右边的值
        magneticMonitorChart.axisRight.isEnabled = false
        // 不显示图例
        val legend = magneticMonitorChart.legend
        legend.isEnabled = false
        // 向左偏移15dp，抵消y轴向右偏移的30dp
        magneticMonitorChart.extraLeftOffset = -15f
        val xAxis = magneticMonitorChart.xAxis
        // 不显示x轴
        xAxis.setDrawAxisLine(false)
        // 设置x轴数据的位置
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textColor = Color.WHITE
        xAxis.textSize = 12f
        xAxis.gridColor = Color.parseColor("#525252")
        // 设置x轴数据偏移量
        xAxis.yOffset = -12f

        //设置y轴的LimitLine
        //        LimitLine yLimitLine = new LimitLine(70f,"磁场警戒线");
        //        yLimitLine.setLineColor(Color.rgb(229, 28, 35));
        //        yLimitLine.setTextColor(Color.rgb(229, 28, 35));
        //        yLimitLine.setTextSize(12);
        //获得左侧侧坐标轴
        val leftAxis = magneticMonitorChart.axisLeft
        //        leftAxis.setAxisMaximum(100f);
        //        leftAxis.setAxisMinimum(10f);
        /* 设置警戒线 */
        //        leftAxis.addLimitLine(yLimitLine);
        // 不显示y轴
        leftAxis.setDrawAxisLine(false)
        // 设置y轴数据的位置
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        // 不从y轴发出横向直线
        leftAxis.setDrawGridLines(true)
        leftAxis.textColor = Color.parseColor("#525252")
        leftAxis.textSize = 12f
        // 设置y轴数据偏移量
        leftAxis.xOffset = 30f
        leftAxis.yOffset = -3f
        leftAxis.axisMinimum = 0f
        //获得下方x轴
        magneticMonitorChart.xAxis.isEnabled = false
        //        XAxis xAxis = mChart.getXAxis();
        //        xAxis.setDrawAxisLine(false);
        //        xAxis.setDrawGridLines(false);
        //        xAxis.setDrawLabels(false);
        //Matrix matrix = new Matrix();
        // x轴缩放1.5倍
        //matrix.postScale(1.5f, 1f);
        // 在图表动画显示之前进行缩放
        //chart.getViewPortHandler().refresh(matrix, chart, false);
        // x轴执行动画
        //chart.animateX(2000);
        magneticMonitorChart.invalidate()
        //设置磁场数据
        refreshChartData()
    }

    fun refreshChartData() {
        val lineDataSet: LineDataSet
        if (magneticMonitorChart.data != null && magneticMonitorChart.data.dataSetCount > 0) {
            lineDataSet = magneticMonitorChart.data.getDataSetByIndex(0) as LineDataSet
            lineDataSet.values = values
        } else {
            lineDataSet = LineDataSet(values, "")
            // 设置曲线颜色
            lineDataSet.color = Color.parseColor("#03a9f4")
            // 设置平滑曲线
            lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
            // 不显示坐标点的小圆点
            lineDataSet.setDrawCircles(false)
            // 不显示坐标点的数据
            lineDataSet.setDrawValues(false)
            // 不显示定位线
            lineDataSet.isHighlightEnabled = false
            val data = LineData(lineDataSet)
            magneticMonitorChart.data = data
        }
        magneticMonitorChart.invalidate()
        magneticMonitorChart.data.notifyDataChanged()
        magneticMonitorChart.notifyDataSetChanged()
    }

    fun stopListen(){
        sensorManager.unregisterListener(this)
    }
}