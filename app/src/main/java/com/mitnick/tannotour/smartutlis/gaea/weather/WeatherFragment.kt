package com.mitnick.tannotour.smartutlis.gaea.weather

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.WeatherBean
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.WeatherCacheBean
import com.mitnick.tannotour.smartutlis.gaea.weather.dynamic.*
import kotlinx.android.synthetic.main.gaea_weather_city_fragment.*
import kotlinx.android.synthetic.main.gaea_weather_fragment.*
import org.jetbrains.anko.support.v4.toast
import com.mitnick.tannotour.smartutlis.gaea.weather.adapter.ThreeHoursAdapter
import android.support.v7.widget.LinearLayoutManager
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.smartutlis.gaea.weather.adapter.SixDaysAdapter
import com.mitnick.tannotour.smartutlis.gaea.weather.bean.ForestBeans
import java.text.SimpleDateFormat
import android.support.v7.widget.GridLayoutManager
import com.mitnick.tannotour.smartutlis.gaea.login.GaeaLoginActivity
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.magnetic.GaeaMagneticMonitorActivity
import com.mitnick.tannotour.smartutlis.gaea.weather.adapter.SuggestionAdapter
import com.mitnick.tannotour.smartutlis.gaea.weather.model.FakeWeather


/**
 * Created by mitnick on 2018/2/7.
 * Description
 */

@CacheKey(keys = arrayOf(WeatherCacheBean::class, UserBean::class))
class WeatherFragment: Fragment(), CacheValueObserver {

    var weather: WeatherBean? = null
    var user: UserBean? = null

    override fun onNotify(key: Class<*>, newValue: Any) {
        when(key.name){
            UserBean::class.java.name -> {
                user = (newValue as UserBean).clone() as UserBean
            }
            WeatherCacheBean::class.java.name -> {
                if(weather != null){
                    return
                }
                weather = (newValue as WeatherCacheBean).weather
                if(weather != null){
                    /* 实时天气情况 */
                    tv_now_hum.text = weather!!.showapi_res_body.f1.jiangshui
                    tv_now_pres.text = weather!!.showapi_res_body.f1.air_press
                    tv_now_wind_sc.text = weather!!.showapi_res_body.now.wind_power
                    tv_now_wind_dir.text = weather!!.showapi_res_body.now.wind_direction
                    tv_temp.text = "${weather!!.showapi_res_body.now.temperature}℃"
                    tv_weather_string.text = weather!!.showapi_res_body.now.weather
                    tv_temp_max.text = "${weather!!.showapi_res_body.f1.day_air_temperature}℃"
                    tv_temp_min.text = "${weather!!.showapi_res_body.f1.night_air_temperature}℃"
                    /* 3小时预报 */
                    val linearLayoutManager = LinearLayoutManager(activity)
                    linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
                    recyclerView_hourly.layoutManager = linearLayoutManager
                    val hourAdapter = ThreeHoursAdapter()
                    recyclerView_hourly.adapter = hourAdapter
                    weather!!.showapi_res_body.f1.`_$3hourForcast`.forEach {
                        hourAdapter.addData(it)
                    }
                    /* 7天预报 */
                    val linearLayoutManager2 = LinearLayoutManager(activity)
                    recyclerView_day.layoutManager = linearLayoutManager2
                    val dayAdapter = SixDaysAdapter()
                    recyclerView_day.adapter = dayAdapter
                    dayAdapter.addData(
                            ForestBeans(
                                    parseTime1(weather!!.showapi_res_body.f2.day) +
                                            "  周" + weeks[Integer.valueOf(weather!!.showapi_res_body.f2.weekday) - 1]
                                    , weather!!.showapi_res_body.f2.day_weather_pic
                                    , weather!!.showapi_res_body.f2.day_weather
                                    , weather!!.showapi_res_body.f2.day_air_temperature + "℃ / "
                                    + weather!!.showapi_res_body.f2.night_air_temperature + "℃"
                            )
                    )
                    dayAdapter.addData(
                            ForestBeans(
                                    parseTime1(weather!!.showapi_res_body.f3.day) +
                                            "  周" + weeks[Integer.valueOf(weather!!.showapi_res_body.f3.weekday) - 1]
                                    , weather!!.showapi_res_body.f3.day_weather_pic
                                    , weather!!.showapi_res_body.f3.day_weather
                                    , weather!!.showapi_res_body.f3.day_air_temperature + "℃ / "
                                    + weather!!.showapi_res_body.f3.night_air_temperature + "℃"
                            )
                    )
                    dayAdapter.addData(
                            ForestBeans(
                                    parseTime1(weather!!.showapi_res_body.f4.day) +
                                            "  周" + weeks[Integer.valueOf(weather!!.showapi_res_body.f4.weekday) - 1]
                                    , weather!!.showapi_res_body.f4.day_weather_pic
                                    , weather!!.showapi_res_body.f4.day_weather
                                    , weather!!.showapi_res_body.f4.day_air_temperature + "℃ / "
                                    + weather!!.showapi_res_body.f4.night_air_temperature + "℃"
                            )
                    )
                    dayAdapter.addData(
                            ForestBeans(
                                    parseTime1(weather!!.showapi_res_body.f5.day) +
                                            "  周" + weeks[Integer.valueOf(weather!!.showapi_res_body.f5.weekday) - 1]
                                    , weather!!.showapi_res_body.f5.day_weather_pic
                                    , weather!!.showapi_res_body.f5.day_weather
                                    , weather!!.showapi_res_body.f5.day_air_temperature + "℃ / "
                                    + weather!!.showapi_res_body.f5.night_air_temperature + "℃"
                            )
                    )
                    dayAdapter.addData(
                            ForestBeans(
                                    parseTime1(weather!!.showapi_res_body.f6.day) +
                                            "  周" + weeks[Integer.valueOf(weather!!.showapi_res_body.f6.weekday) - 1]
                                    , weather!!.showapi_res_body.f6.day_weather_pic
                                    , weather!!.showapi_res_body.f6.day_weather
                                    , weather!!.showapi_res_body.f6.day_air_temperature + "℃ / "
                                    + weather!!.showapi_res_body.f6.night_air_temperature + "℃"
                            )
                    )
                    dayAdapter.addData(
                            ForestBeans(
                                    parseTime1(weather!!.showapi_res_body.f7.day) +
                                            "  周" + weeks[Integer.valueOf(weather!!.showapi_res_body.f7.weekday) - 1]
                                    , weather!!.showapi_res_body.f7.day_weather_pic
                                    , weather!!.showapi_res_body.f7.day_weather
                                    , weather!!.showapi_res_body.f7.day_air_temperature + "℃ / "
                                    + weather!!.showapi_res_body.f7.night_air_temperature + "℃"
                            )
                    )
                    /* 加载建议 */
                    suggesstionRecyclerView.layoutManager = object : GridLayoutManager(activity, 4) {
                        override fun canScrollVertically(): Boolean {
                            return false
                        }
                    }
                    val suggestionAdapter = SuggestionAdapter()
                    suggesstionRecyclerView.adapter = suggestionAdapter
                    suggestionAdapter.addData(FakeWeather.空气, weather!!.showapi_res_body.f1.index.aqi.title)
                    suggestionAdapter.addData(FakeWeather.舒适度, weather!!.showapi_res_body.f1.index.mf.title)
                    suggestionAdapter.addData(FakeWeather.洗车, weather!!.showapi_res_body.f1.index.wash_car.title)
                    suggestionAdapter.addData(FakeWeather.穿衣, weather!!.showapi_res_body.f1.index.ls.title)
                    suggestionAdapter.addData(FakeWeather.感冒, weather!!.showapi_res_body.f1.index.cold.title)
                    suggestionAdapter.addData(FakeWeather.运动, weather!!.showapi_res_body.f1.index.sports.title)
                    suggestionAdapter.addData(FakeWeather.旅游, weather!!.showapi_res_body.f1.index.travel.title)
                    suggestionAdapter.addData(FakeWeather.紫外线, weather!!.showapi_res_body.f1.index.uv.title)
                }else{
                    toast("天气数据错误")
                }
            }
        }
    }

    private fun parseTime1(time: String): String? {
        try {
            var simpleDateFormat = SimpleDateFormat("yyyyMMdd")
            // SimpleDateFormat的parse(String time)方法将String转换为Date
            val date = simpleDateFormat.parse(time)
            simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            // SimpleDateFormat的format(Date date)方法将Date转换为String
            val formattedTime = simpleDateFormat.format(date)
            return formattedTime
        } catch (e: Exception) {
            return null
        }
    }

    private val weeks = charArrayOf('一', '二', '三', '四', '五', '六', '日')

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gaea_weather_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switchDynamicWeather("晴（白天）")
        Cache.addObserver(this)
        weatherToMonitor.setOnClickListener {
            if(user == null){
                startActivity(Intent(activity, GaeaLoginActivity::class.java))
                activity.finish()
            }else{
                val intent = Intent(activity, GaeaMagneticMonitorActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }

        }
        weatherToTaifeng.setOnClickListener {

        }
        weatherToHome.setOnClickListener {

        }
        weatherToHelp.setOnClickListener {

        }
        swipe_container.setOnRefreshListener {
            swipe_container.isRefreshing = false
            toast("更新成功")
        }
    }

    override fun onResume() {
        super.onResume()
        dynamicWeather.onResume()
    }

    override fun onPause() {
        super.onPause()
        dynamicWeather.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        dynamicWeather.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Cache.removeObserver(this)
    }

    private fun switchDynamicWeather(which: String) {
        val info = ShortWeatherInfo()
        info.code = "100"
        info.windSpeed = "11"
        val type: BaseWeatherType
        when (which) {
            "晴（白天）" -> {
                info.sunrise = "00:01"
                info.sunset = "23:59"
                info.moonrise = "00:00"
                info.moonset = "00:01"
                type = SunnyType(activity, info)
            }
            "晴（夜晚）" -> {
                info.sunrise = "00:00"
                info.sunset = "00:01"
                info.moonrise = "00:01"
                info.moonset = "23:59"
                type = SunnyType(activity, info)
            }
            "多云" -> {
                info.sunrise = "00:01"
                info.sunset = "23:59"
                info.moonrise = "00:00"
                info.moonset = "00:01"
                val sunnyType = SunnyType(activity, info)
                sunnyType.isCloud = true
                type = sunnyType
            }
            "阴" -> type = OvercastType(activity, info)
            "雨" -> {
                val rainType = RainType(activity, RainType.RAIN_LEVEL_2, RainType.WIND_LEVEL_2)
                rainType.isFlashing = true
                type = rainType
            }
            "雨夹雪" -> {
                val rainSnowType = RainType(activity, RainType.RAIN_LEVEL_1, RainType.WIND_LEVEL_1)
                rainSnowType.isSnowing = true
                type = rainSnowType
            }
            "雪" -> type = SnowType(activity, SnowType.SNOW_LEVEL_2)
            "冰雹" -> type = HailType(activity)
            "雾" -> type = FogType(activity)
            "雾霾" -> type = HazeType(activity)
            "沙尘暴" -> type = SandstormType(activity)
            else -> type = SunnyType(activity, info)
        }
        dynamicWeather.setType(type)
    }
}