package com.mitnick.tannotour.smartutlis.gaea.weather.bean;

import com.google.gson.annotations.SerializedName;
import com.mitnick.tannotour.easylib.cache.CacheBean;

import java.util.List;

/**
 * Created by mitnick on 2018/2/7.
 * Description
 */

public class WeatherBean {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"f6":{"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气阴沉，会感觉压抑，情绪低落。"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"不容易中暑","desc":"气温不高，中暑几率极低。"},"cold":{"title":"易发","desc":"天冷湿度大，注意增加衣服。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"热，感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天气炎热，可适量饮用啤酒，不要过量。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不适宜","desc":"有雨，天气不好，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"86%","night_wind_power":"微风 <5.4m/s","day_wind_power":"3-4级 5.5~7.9m/s","day_weather_code":"07","3hourForcast":[{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"26","hour":"8时-14时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"27","hour":"14时-20时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"20时-2时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"2时-8时","temperature":"25"}],"sun_begin_end":"05:29|18:21","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":3,"night_air_temperature":"25","day_air_temperature":"29","day_wind_direction":"东北风","day":"20170830","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"东北风"},"f7":{"day_weather":"中雨","night_weather":"小雨","night_weather_code":"07","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"89%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"08","3hourForcast":[{"wind_direction":"东北风","temperature_max":"29","wind_power":"微风,3","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","temperature_min":"25","hour":"8时-14时","temperature":"25"},{"wind_direction":"东风","temperature_max":"29","wind_power":"微风,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"25","hour":"14时-20时","temperature":"29"},{"wind_direction":"东风","temperature_max":"29","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"20时-2时","temperature":"26"},{"wind_direction":"无持续风向","temperature_max":"26","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"2时-8时","temperature":"25"}],"sun_begin_end":"05:29|18:20","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","weekday":4,"night_air_temperature":"25","day_air_temperature":"30","day_wind_direction":"东风","day":"20170831","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"无持续风向"},"ret_code":0,"time":"20170825073000","alarmList":[{"signalLevel":"黄色","issueContent":"上海中心气象台2017年08月25日01时45分发布雷电黄色预警[Ⅲ级/较重]：预计3小时内松江、青浦、金山等地将发生雷电活动，可能会造成雷电灾害事故，并伴有1小时20毫米左右的短时强降水。","issueTime":"2017-08-25 01:45:00","province":"上海市","signalType":"雷电","city":""},{"signalLevel":"黄色","issueContent":"上海中心气象台2017年08月24日10时29分发布高温黄色预警[Ⅲ级/较重]：受西太平洋副热带高压影响，目前本市气温正快速上升，预计今天全市大部地区的最高气温将超过35℃，请做好防暑降温工作。","issueTime":"2017-08-24 10:29:00","province":"上海市","signalType":"高温","city":""}],"cityInfo":{"c6":"shanghai","c5":"上海","c4":"shanghai","c3":"上海","c9":"中国","c8":"china","c7":"上海","c17":"+8","c16":"AZ9210","c1":"101020100","c2":"shanghai","c11":"021","longitude":121.445,"c10":"1","latitude":31.213,"c12":"200000","c15":"19"},"now":{"aqiDetail":{"co":"1.02","num":"240","so2":"10","area":"上海","o3":"53","no2":"58","quality":"良好","aqi":"56","pm10":"59","pm2_5":"24","o3_8h":"50","primary_pollutant":"颗粒物(PM10)"},"weather_code":"01","temperature_time":"11:00","wind_direction":"西南风","wind_power":"1级","sd":"58%","aqi":"56","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature":"34"},"f1":{"day_weather":"雷阵雨","night_weather":"雷阵雨","night_weather_code":"04","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"部分时间开启","desc":"天气燥热需适当开启空调，以免中暑。"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"一般","desc":"天热，头皮皮脂分泌多，注意清洁。"},"ag":{"title":"易发","desc":"应减少外出，外出需采取防护措施。"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"较适宜","desc":"只要您稍作准备就可以放心外出。"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"82%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"04","3hourForcast":[{"wind_direction":"西北风","temperature_max":"30","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"8时-11时","temperature":"30"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"30","hour":"11时-14时","temperature":"30"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"30","hour":"14时-17时","temperature":"33"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"27","hour":"17时-20时","temperature":"32"},{"wind_direction":"西北风","temperature_max":"32","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"26","hour":"20时-23时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"23时-2时","temperature":"26"},{"wind_direction":"东北风","temperature_max":"26","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"2时-5时","temperature":"26"},{"wind_direction":"东北风","temperature_max":"28","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"5时-8时","temperature":"26"}],"sun_begin_end":"05:25|18:27","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","weekday":5,"night_air_temperature":"26","day_air_temperature":"34","day_wind_direction":"西北风","day":"20170825","night_weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","night_wind_direction":"东北风"},"f3":{"day_weather":"多云","night_weather":"多云","night_weather_code":"01","index":{"yh":{"title":"较适宜","desc":"天气较好，适宜约会"},"ls":{"title":"不适宜","desc":"天气阴沉，不太适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"天气炎热，建议停止户外运动。"},"travel":{"title":"较适宜","desc":"天热注意防晒，可选择水上娱乐项目。"},"beauty":{"title":"去油","desc":"请选用露质面霜打底，水质无油粉底霜。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"适宜","desc":"天气较好，适宜划船及嬉玩水上运动。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"适宜","desc":"这种好天气去逛街可使身心畅快放松。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"天气炎热，建议停止户外运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"适宜","desc":"无雨且风力较小，易保持清洁度。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"炎热干燥，适宜饮用冰镇啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"12%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"01","3hourForcast":[{"wind_direction":"东风","temperature_max":"32","wind_power":"微风,3","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","temperature_min":"26","hour":"8时-11时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"32","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"11时-14时","temperature":"32"},{"wind_direction":"东南风","temperature_max":"32","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"14时-17时","temperature":"31"},{"wind_direction":"东南风","temperature_max":"31","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"29","hour":"17时-20时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"30","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"20时-23时","temperature":"29"},{"wind_direction":"东南风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"23时-2时","temperature":"28"},{"wind_direction":"东南风","temperature_max":"28","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"2时-5时","temperature":"28"},{"wind_direction":"东南风","temperature_max":"30","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"5时-8时","temperature":"27"}],"sun_begin_end":"05:27|18:25","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","weekday":7,"night_air_temperature":"27","day_air_temperature":"33","day_wind_direction":"东南风","day":"20170827","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"东南风"},"f2":{"day_weather":"雷阵雨","night_weather":"阴","night_weather_code":"02","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"85%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"04","3hourForcast":[{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"26","hour":"8时-11时","temperature":"28"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"28","hour":"11时-14时","temperature":"30"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"29","hour":"14时-17时","temperature":"30"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"27","hour":"17时-20时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"20时-23时","temperature":"27"},{"wind_direction":"东风","temperature_max":"27","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"23时-2时","temperature":"27"},{"wind_direction":"东风","temperature_max":"27","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"2时-5时","temperature":"26"},{"wind_direction":"东风","temperature_max":"30","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"5时-8时","temperature":"26"}],"sun_begin_end":"05:26|18:26","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","weekday":6,"night_air_temperature":"26","day_air_temperature":"31","day_wind_direction":"东北风","day":"20170826","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"东风"},"f5":{"day_weather":"小雨","night_weather":"大雨","night_weather_code":"09","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"易发","desc":"天冷湿度大，注意增加衣服。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"热，感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"72%","night_wind_power":"3-4级 5.5~7.9m/s","day_wind_power":"4-5级 8.0~10.7m/s","day_weather_code":"07","3hourForcast":[{"wind_direction":"西南风","temperature_max":"32","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"28","hour":"8时-14时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"32","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"27","hour":"14时-20时","temperature":"32"},{"wind_direction":"东北风","temperature_max":"32","wind_power":"4-5级,0","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/night/08.png","temperature_min":"26","hour":"20时-2时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/night/08.png","temperature_min":"26","hour":"2时-8时","temperature":"26"}],"sun_begin_end":"05:28|18:22","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":2,"night_air_temperature":"25","day_air_temperature":"32","day_wind_direction":"东北风","day":"20170829","night_weather_pic":"http://app1.showapi.com/weather/icon/night/09.png","night_wind_direction":"东北风"},"f4":{"day_weather":"晴","night_weather":"多云","night_weather_code":"01","index":{"yh":{"title":"较适宜","desc":"不用担心天气来调皮捣乱而影响了兴致。 "},"ls":{"title":"较适宜","desc":"天气不错，抓紧时机让衣物晒太阳吧。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"适宜钓鱼","desc":"风和日丽，适宜钓鱼。"},"sports":{"title":"适宜","desc":"适当减少运动时间并降低运动强度。"},"travel":{"title":"较不宜","desc":"天气很热，如外出可选择水上娱乐项目。"},"beauty":{"title":"去油","desc":"请选用露质面霜打底，水质无油粉底霜。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"适宜","desc":"天气较好，适宜划船及嬉玩水上运动。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"适宜","desc":"这种好天气去逛街可使身心畅快放松。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"适宜","desc":"适当减少运动时间并降低运动强度。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"适宜","desc":"无雨且风力较小，易保持清洁度。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"炎热干燥，适宜饮用冰镇啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"0%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"00","3hourForcast":[{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"27","hour":"8时-14时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,1","weather":"晴","weather_pic":"http://app1.showapi.com/weather/icon/day/00.png","temperature_min":"29","hour":"14时-20时","temperature":"33"},{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,0","weather":"晴","weather_pic":"http://app1.showapi.com/weather/icon/night/00.png","temperature_min":"28","hour":"20时-2时","temperature":"29"},{"wind_direction":"西南风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"2时-8时","temperature":"28"}],"sun_begin_end":"05:27|18:23","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/00.png","weekday":1,"night_air_temperature":"27","day_air_temperature":"33","day_wind_direction":"东南风","day":"20170828","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"西南风"},"showapi_treemap":true}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * f6 : {"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气阴沉，会感觉压抑，情绪低落。"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"不容易中暑","desc":"气温不高，中暑几率极低。"},"cold":{"title":"易发","desc":"天冷湿度大，注意增加衣服。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"热，感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天气炎热，可适量饮用啤酒，不要过量。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不适宜","desc":"有雨，天气不好，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"86%","night_wind_power":"微风 <5.4m/s","day_wind_power":"3-4级 5.5~7.9m/s","day_weather_code":"07","3hourForcast":[{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"26","hour":"8时-14时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"27","hour":"14时-20时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"20时-2时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"2时-8时","temperature":"25"}],"sun_begin_end":"05:29|18:21","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":3,"night_air_temperature":"25","day_air_temperature":"29","day_wind_direction":"东北风","day":"20170830","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"东北风"}
         * f7 : {"day_weather":"中雨","night_weather":"小雨","night_weather_code":"07","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"89%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"08","3hourForcast":[{"wind_direction":"东北风","temperature_max":"29","wind_power":"微风,3","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","temperature_min":"25","hour":"8时-14时","temperature":"25"},{"wind_direction":"东风","temperature_max":"29","wind_power":"微风,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"25","hour":"14时-20时","temperature":"29"},{"wind_direction":"东风","temperature_max":"29","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"20时-2时","temperature":"26"},{"wind_direction":"无持续风向","temperature_max":"26","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"2时-8时","temperature":"25"}],"sun_begin_end":"05:29|18:20","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","weekday":4,"night_air_temperature":"25","day_air_temperature":"30","day_wind_direction":"东风","day":"20170831","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"无持续风向"}
         * ret_code : 0
         * time : 20170825073000
         * alarmList : [{"signalLevel":"黄色","issueContent":"上海中心气象台2017年08月25日01时45分发布雷电黄色预警[Ⅲ级/较重]：预计3小时内松江、青浦、金山等地将发生雷电活动，可能会造成雷电灾害事故，并伴有1小时20毫米左右的短时强降水。","issueTime":"2017-08-25 01:45:00","province":"上海市","signalType":"雷电","city":""},{"signalLevel":"黄色","issueContent":"上海中心气象台2017年08月24日10时29分发布高温黄色预警[Ⅲ级/较重]：受西太平洋副热带高压影响，目前本市气温正快速上升，预计今天全市大部地区的最高气温将超过35℃，请做好防暑降温工作。","issueTime":"2017-08-24 10:29:00","province":"上海市","signalType":"高温","city":""}]
         * cityInfo : {"c6":"shanghai","c5":"上海","c4":"shanghai","c3":"上海","c9":"中国","c8":"china","c7":"上海","c17":"+8","c16":"AZ9210","c1":"101020100","c2":"shanghai","c11":"021","longitude":121.445,"c10":"1","latitude":31.213,"c12":"200000","c15":"19"}
         * now : {"aqiDetail":{"co":"1.02","num":"240","so2":"10","area":"上海","o3":"53","no2":"58","quality":"良好","aqi":"56","pm10":"59","pm2_5":"24","o3_8h":"50","primary_pollutant":"颗粒物(PM10)"},"weather_code":"01","temperature_time":"11:00","wind_direction":"西南风","wind_power":"1级","sd":"58%","aqi":"56","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature":"34"}
         * f1 : {"day_weather":"雷阵雨","night_weather":"雷阵雨","night_weather_code":"04","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"部分时间开启","desc":"天气燥热需适当开启空调，以免中暑。"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"一般","desc":"天热，头皮皮脂分泌多，注意清洁。"},"ag":{"title":"易发","desc":"应减少外出，外出需采取防护措施。"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"较适宜","desc":"只要您稍作准备就可以放心外出。"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"82%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"04","3hourForcast":[{"wind_direction":"西北风","temperature_max":"30","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"8时-11时","temperature":"30"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"30","hour":"11时-14时","temperature":"30"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"30","hour":"14时-17时","temperature":"33"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"27","hour":"17时-20时","temperature":"32"},{"wind_direction":"西北风","temperature_max":"32","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"26","hour":"20时-23时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"23时-2时","temperature":"26"},{"wind_direction":"东北风","temperature_max":"26","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"2时-5时","temperature":"26"},{"wind_direction":"东北风","temperature_max":"28","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"5时-8时","temperature":"26"}],"sun_begin_end":"05:25|18:27","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","weekday":5,"night_air_temperature":"26","day_air_temperature":"34","day_wind_direction":"西北风","day":"20170825","night_weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","night_wind_direction":"东北风"}
         * f3 : {"day_weather":"多云","night_weather":"多云","night_weather_code":"01","index":{"yh":{"title":"较适宜","desc":"天气较好，适宜约会"},"ls":{"title":"不适宜","desc":"天气阴沉，不太适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"天气炎热，建议停止户外运动。"},"travel":{"title":"较适宜","desc":"天热注意防晒，可选择水上娱乐项目。"},"beauty":{"title":"去油","desc":"请选用露质面霜打底，水质无油粉底霜。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"适宜","desc":"天气较好，适宜划船及嬉玩水上运动。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"适宜","desc":"这种好天气去逛街可使身心畅快放松。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"天气炎热，建议停止户外运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"适宜","desc":"无雨且风力较小，易保持清洁度。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"炎热干燥，适宜饮用冰镇啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"12%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"01","3hourForcast":[{"wind_direction":"东风","temperature_max":"32","wind_power":"微风,3","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","temperature_min":"26","hour":"8时-11时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"32","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"11时-14时","temperature":"32"},{"wind_direction":"东南风","temperature_max":"32","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"14时-17时","temperature":"31"},{"wind_direction":"东南风","temperature_max":"31","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"29","hour":"17时-20时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"30","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"20时-23时","temperature":"29"},{"wind_direction":"东南风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"23时-2时","temperature":"28"},{"wind_direction":"东南风","temperature_max":"28","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"2时-5时","temperature":"28"},{"wind_direction":"东南风","temperature_max":"30","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"5时-8时","temperature":"27"}],"sun_begin_end":"05:27|18:25","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","weekday":7,"night_air_temperature":"27","day_air_temperature":"33","day_wind_direction":"东南风","day":"20170827","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"东南风"}
         * f2 : {"day_weather":"雷阵雨","night_weather":"阴","night_weather_code":"02","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"85%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"04","3hourForcast":[{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"26","hour":"8时-11时","temperature":"28"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"28","hour":"11时-14时","temperature":"30"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"29","hour":"14时-17时","temperature":"30"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"27","hour":"17时-20时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"20时-23时","temperature":"27"},{"wind_direction":"东风","temperature_max":"27","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"23时-2时","temperature":"27"},{"wind_direction":"东风","temperature_max":"27","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"2时-5时","temperature":"26"},{"wind_direction":"东风","temperature_max":"30","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"5时-8时","temperature":"26"}],"sun_begin_end":"05:26|18:26","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","weekday":6,"night_air_temperature":"26","day_air_temperature":"31","day_wind_direction":"东北风","day":"20170826","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"东风"}
         * f5 : {"day_weather":"小雨","night_weather":"大雨","night_weather_code":"09","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"易发","desc":"天冷湿度大，注意增加衣服。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"热，感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"72%","night_wind_power":"3-4级 5.5~7.9m/s","day_wind_power":"4-5级 8.0~10.7m/s","day_weather_code":"07","3hourForcast":[{"wind_direction":"西南风","temperature_max":"32","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"28","hour":"8时-14时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"32","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"27","hour":"14时-20时","temperature":"32"},{"wind_direction":"东北风","temperature_max":"32","wind_power":"4-5级,0","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/night/08.png","temperature_min":"26","hour":"20时-2时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/night/08.png","temperature_min":"26","hour":"2时-8时","temperature":"26"}],"sun_begin_end":"05:28|18:22","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":2,"night_air_temperature":"25","day_air_temperature":"32","day_wind_direction":"东北风","day":"20170829","night_weather_pic":"http://app1.showapi.com/weather/icon/night/09.png","night_wind_direction":"东北风"}
         * f4 : {"day_weather":"晴","night_weather":"多云","night_weather_code":"01","index":{"yh":{"title":"较适宜","desc":"不用担心天气来调皮捣乱而影响了兴致。 "},"ls":{"title":"较适宜","desc":"天气不错，抓紧时机让衣物晒太阳吧。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"适宜钓鱼","desc":"风和日丽，适宜钓鱼。"},"sports":{"title":"适宜","desc":"适当减少运动时间并降低运动强度。"},"travel":{"title":"较不宜","desc":"天气很热，如外出可选择水上娱乐项目。"},"beauty":{"title":"去油","desc":"请选用露质面霜打底，水质无油粉底霜。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"适宜","desc":"天气较好，适宜划船及嬉玩水上运动。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"适宜","desc":"这种好天气去逛街可使身心畅快放松。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"适宜","desc":"适当减少运动时间并降低运动强度。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"适宜","desc":"无雨且风力较小，易保持清洁度。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"炎热干燥，适宜饮用冰镇啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}},"air_press":"1008 hPa","jiangshui":"0%","night_wind_power":"微风 <5.4m/s","day_wind_power":"微风 <5.4m/s","day_weather_code":"00","3hourForcast":[{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"27","hour":"8时-14时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,1","weather":"晴","weather_pic":"http://app1.showapi.com/weather/icon/day/00.png","temperature_min":"29","hour":"14时-20时","temperature":"33"},{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,0","weather":"晴","weather_pic":"http://app1.showapi.com/weather/icon/night/00.png","temperature_min":"28","hour":"20时-2时","temperature":"29"},{"wind_direction":"西南风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"2时-8时","temperature":"28"}],"sun_begin_end":"05:27|18:23","ziwaixian":"很强","day_weather_pic":"http://app1.showapi.com/weather/icon/day/00.png","weekday":1,"night_air_temperature":"27","day_air_temperature":"33","day_wind_direction":"东南风","day":"20170828","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"西南风"}
         * showapi_treemap : true
         */

        private F6Bean f6;
        private F7Bean f7;
        private int ret_code;
        private String time;
        private CityInfoBean cityInfo;
        private NowBean now;
        private F1Bean f1;
        private F3Bean f3;
        private F2Bean f2;
        private F5Bean f5;
        private F4Bean f4;
        private boolean showapi_treemap;
        private List<AlarmListBean> alarmList;

        public F6Bean getF6() {
            return f6;
        }

        public void setF6(F6Bean f6) {
            this.f6 = f6;
        }

        public F7Bean getF7() {
            return f7;
        }

        public void setF7(F7Bean f7) {
            this.f7 = f7;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public CityInfoBean getCityInfo() {
            return cityInfo;
        }

        public void setCityInfo(CityInfoBean cityInfo) {
            this.cityInfo = cityInfo;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public F1Bean getF1() {
            return f1;
        }

        public void setF1(F1Bean f1) {
            this.f1 = f1;
        }

        public F3Bean getF3() {
            return f3;
        }

        public void setF3(F3Bean f3) {
            this.f3 = f3;
        }

        public F2Bean getF2() {
            return f2;
        }

        public void setF2(F2Bean f2) {
            this.f2 = f2;
        }

        public F5Bean getF5() {
            return f5;
        }

        public void setF5(F5Bean f5) {
            this.f5 = f5;
        }

        public F4Bean getF4() {
            return f4;
        }

        public void setF4(F4Bean f4) {
            this.f4 = f4;
        }

        public boolean isShowapi_treemap() {
            return showapi_treemap;
        }

        public void setShowapi_treemap(boolean showapi_treemap) {
            this.showapi_treemap = showapi_treemap;
        }

        public List<AlarmListBean> getAlarmList() {
            return alarmList;
        }

        public void setAlarmList(List<AlarmListBean> alarmList) {
            this.alarmList = alarmList;
        }

        public static class F6Bean {
            /**
             * day_weather : 小雨
             * night_weather : 小雨
             * night_weather_code : 07
             * index : {"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气阴沉，会感觉压抑，情绪低落。"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"不容易中暑","desc":"气温不高，中暑几率极低。"},"cold":{"title":"易发","desc":"天冷湿度大，注意增加衣服。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"热，感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天气炎热，可适量饮用啤酒，不要过量。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不适宜","desc":"有雨，天气不好，不适宜放风筝。"}}
             * air_press : 1008 hPa
             * jiangshui : 86%
             * night_wind_power : 微风 <5.4m/s
             * day_wind_power : 3-4级 5.5~7.9m/s
             * day_weather_code : 07
             * 3hourForcast : [{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"26","hour":"8时-14时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"27","hour":"14时-20时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"3-4级,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"20时-2时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"2时-8时","temperature":"25"}]
             * sun_begin_end : 05:29|18:21
             * ziwaixian : 很强
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/07.png
             * weekday : 3
             * night_air_temperature : 25
             * day_air_temperature : 29
             * day_wind_direction : 东北风
             * day : 20170830
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/07.png
             * night_wind_direction : 东北风
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBean index;
            private String air_press;
            private String jiangshui;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String ziwaixian;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;
            @SerializedName("3hourForcast")
            private List<_$3hourForcastBean> _$3hourForcast;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBean getIndex() {
                return index;
            }

            public void setIndex(IndexBean index) {
                this.index = index;
            }

            public String getAir_press() {
                return air_press;
            }

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public List<_$3hourForcastBean> get_$3hourForcast() {
                return _$3hourForcast;
            }

            public void set_$3hourForcast(List<_$3hourForcastBean> _$3hourForcast) {
                this._$3hourForcast = _$3hourForcast;
            }

            public static class IndexBean {
                /**
                 * yh : {"title":"较不适宜","desc":"建议尽量不要去室外约会。"}
                 * ls : {"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"}
                 * clothes : {"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"}
                 * dy : {"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"}
                 * sports : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * travel : {"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"}
                 * beauty : {"title":"保湿","desc":"请选用保湿型霜类化妆品。"}
                 * xq : {"title":"较差","desc":"天气阴沉，会感觉压抑，情绪低落。"}
                 * hc : {"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"}
                 * zs : {"title":"不容易中暑","desc":"气温不高，中暑几率极低。"}
                 * cold : {"title":"易发","desc":"天冷湿度大，注意增加衣服。"}
                 * gj : {"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"}
                 * comfort : {"title":"较差","desc":"热，感觉不舒适"}
                 * uv : {"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"}
                 * cl : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * glass : {"title":"不需要","desc":"不需要佩戴"}
                 * aqi : {"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"}
                 * ac : {"title":"暂缺","desc":"暂缺"}
                 * wash_car : {"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"}
                 * mf : {"title":"暂缺","desc":"暂缺"}
                 * ag : {"title":"暂缺","desc":"暂缺"}
                 * pj : {"title":"适宜","desc":"天气炎热，可适量饮用啤酒，不要过量。"}
                 * nl : {"title":"暂缺","desc":"暂缺"}
                 * pk : {"title":"不适宜","desc":"有雨，天气不好，不适宜放风筝。"}
                 */

                private YhBean yh;
                private LsBean ls;
                private ClothesBean clothes;
                private DyBean dy;
                private SportsBean sports;
                private TravelBean travel;
                private BeautyBean beauty;
                private XqBean xq;
                private HcBean hc;
                private ZsBean zs;
                private ColdBean cold;
                private GjBean gj;
                private ComfortBean comfort;
                private UvBean uv;
                private ClBean cl;
                private GlassBean glass;
                private AqiBean aqi;
                private AcBean ac;
                private WashCarBean wash_car;
                private MfBean mf;
                private AgBean ag;
                private PjBean pj;
                private NlBean nl;
                private PkBean pk;

                public YhBean getYh() {
                    return yh;
                }

                public void setYh(YhBean yh) {
                    this.yh = yh;
                }

                public LsBean getLs() {
                    return ls;
                }

                public void setLs(LsBean ls) {
                    this.ls = ls;
                }

                public ClothesBean getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBean clothes) {
                    this.clothes = clothes;
                }

                public DyBean getDy() {
                    return dy;
                }

                public void setDy(DyBean dy) {
                    this.dy = dy;
                }

                public SportsBean getSports() {
                    return sports;
                }

                public void setSports(SportsBean sports) {
                    this.sports = sports;
                }

                public TravelBean getTravel() {
                    return travel;
                }

                public void setTravel(TravelBean travel) {
                    this.travel = travel;
                }

                public BeautyBean getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyBean beauty) {
                    this.beauty = beauty;
                }

                public XqBean getXq() {
                    return xq;
                }

                public void setXq(XqBean xq) {
                    this.xq = xq;
                }

                public HcBean getHc() {
                    return hc;
                }

                public void setHc(HcBean hc) {
                    this.hc = hc;
                }

                public ZsBean getZs() {
                    return zs;
                }

                public void setZs(ZsBean zs) {
                    this.zs = zs;
                }

                public ColdBean getCold() {
                    return cold;
                }

                public void setCold(ColdBean cold) {
                    this.cold = cold;
                }

                public GjBean getGj() {
                    return gj;
                }

                public void setGj(GjBean gj) {
                    this.gj = gj;
                }

                public ComfortBean getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBean comfort) {
                    this.comfort = comfort;
                }

                public UvBean getUv() {
                    return uv;
                }

                public void setUv(UvBean uv) {
                    this.uv = uv;
                }

                public ClBean getCl() {
                    return cl;
                }

                public void setCl(ClBean cl) {
                    this.cl = cl;
                }

                public GlassBean getGlass() {
                    return glass;
                }

                public void setGlass(GlassBean glass) {
                    this.glass = glass;
                }

                public AqiBean getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBean aqi) {
                    this.aqi = aqi;
                }

                public AcBean getAc() {
                    return ac;
                }

                public void setAc(AcBean ac) {
                    this.ac = ac;
                }

                public WashCarBean getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBean wash_car) {
                    this.wash_car = wash_car;
                }

                public MfBean getMf() {
                    return mf;
                }

                public void setMf(MfBean mf) {
                    this.mf = mf;
                }

                public AgBean getAg() {
                    return ag;
                }

                public void setAg(AgBean ag) {
                    this.ag = ag;
                }

                public PjBean getPj() {
                    return pj;
                }

                public void setPj(PjBean pj) {
                    this.pj = pj;
                }

                public NlBean getNl() {
                    return nl;
                }

                public void setNl(NlBean nl) {
                    this.nl = nl;
                }

                public PkBean getPk() {
                    return pk;
                }

                public void setPk(PkBean pk) {
                    this.pk = pk;
                }

                public static class YhBean {
                    /**
                     * title : 较不适宜
                     * desc : 建议尽量不要去室外约会。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class LsBean {
                    /**
                     * title : 不适宜
                     * desc : 有降水会淋湿衣物，不适宜晾晒。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBean {
                    /**
                     * title : 热
                     * desc : 适合穿T恤、短薄外套等夏季服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DyBean {
                    /**
                     * title : 不适宜钓鱼
                     * desc : 天气不好，不适合垂钓
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class SportsBean {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBean {
                    /**
                     * title : 较不宜
                     * desc : 有降水气温高，注意防暑降温携带雨具。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class BeautyBean {
                    /**
                     * title : 保湿
                     * desc : 请选用保湿型霜类化妆品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class XqBean {
                    /**
                     * title : 较差
                     * desc : 天气阴沉，会感觉压抑，情绪低落。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class HcBean {
                    /**
                     * title : 不适宜
                     * desc : 天气不好，建议选择别的娱乐方式。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ZsBean {
                    /**
                     * title : 不容易中暑
                     * desc : 气温不高，中暑几率极低。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdBean {
                    /**
                     * title : 易发
                     * desc : 天冷湿度大，注意增加衣服。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GjBean {
                    /**
                     * title : 不适宜
                     * desc : 有降水，出门带雨具并注意防雷。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBean {
                    /**
                     * title : 较差
                     * desc : 热，感觉不舒适
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBean {
                    /**
                     * title : 弱
                     * desc : 辐射较弱，涂擦SPF12-15、PA+护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClBean {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GlassBean {
                    /**
                     * title : 不需要
                     * desc : 不需要佩戴
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBean {
                    /**
                     * title : 优质
                     * desc : 空气很好，可以外出活动，呼吸新鲜空气
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AcBean {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBean {
                    /**
                     * title : 不适宜
                     * desc : 有雨，雨水和泥水会弄脏爱车。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class MfBean {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AgBean {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PjBean {
                    /**
                     * title : 适宜
                     * desc : 天气炎热，可适量饮用啤酒，不要过量。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class NlBean {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PkBean {
                    /**
                     * title : 不适宜
                     * desc : 有雨，天气不好，不适宜放风筝。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class _$3hourForcastBean {
                /**
                 * wind_direction : 东北风
                 * temperature_max : 29
                 * wind_power : 3-4级,3
                 * weather : 中雨
                 * weather_pic : http://app1.showapi.com/weather/icon/day/08.png
                 * temperature_min : 26
                 * hour : 8时-14时
                 * temperature : 27
                 */

                private String wind_direction;
                private String temperature_max;
                private String wind_power;
                private String weather;
                private String weather_pic;
                private String temperature_min;
                private String hour;
                private String temperature;

                public String getWind_direction() {
                    return wind_direction;
                }

                public void setWind_direction(String wind_direction) {
                    this.wind_direction = wind_direction;
                }

                public String getTemperature_max() {
                    return temperature_max;
                }

                public void setTemperature_max(String temperature_max) {
                    this.temperature_max = temperature_max;
                }

                public String getWind_power() {
                    return wind_power;
                }

                public void setWind_power(String wind_power) {
                    this.wind_power = wind_power;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getWeather_pic() {
                    return weather_pic;
                }

                public void setWeather_pic(String weather_pic) {
                    this.weather_pic = weather_pic;
                }

                public String getTemperature_min() {
                    return temperature_min;
                }

                public void setTemperature_min(String temperature_min) {
                    this.temperature_min = temperature_min;
                }

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class F7Bean {
            /**
             * day_weather : 中雨
             * night_weather : 小雨
             * night_weather_code : 07
             * index : {"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}}
             * air_press : 1008 hPa
             * jiangshui : 89%
             * night_wind_power : 微风 <5.4m/s
             * day_wind_power : 微风 <5.4m/s
             * day_weather_code : 08
             * 3hourForcast : [{"wind_direction":"东北风","temperature_max":"29","wind_power":"微风,3","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","temperature_min":"25","hour":"8时-14时","temperature":"25"},{"wind_direction":"东风","temperature_max":"29","wind_power":"微风,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"25","hour":"14时-20时","temperature":"29"},{"wind_direction":"东风","temperature_max":"29","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"20时-2时","temperature":"26"},{"wind_direction":"无持续风向","temperature_max":"26","wind_power":"微风,0","weather":"小雨","weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","temperature_min":"25","hour":"2时-8时","temperature":"25"}]
             * sun_begin_end : 05:29|18:20
             * ziwaixian : 很强
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/08.png
             * weekday : 4
             * night_air_temperature : 25
             * day_air_temperature : 30
             * day_wind_direction : 东风
             * day : 20170831
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/07.png
             * night_wind_direction : 无持续风向
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBeanX index;
            private String air_press;
            private String jiangshui;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String ziwaixian;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;
            @SerializedName("3hourForcast")
            private List<_$3hourForcastBeanX> _$3hourForcast;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBeanX getIndex() {
                return index;
            }

            public void setIndex(IndexBeanX index) {
                this.index = index;
            }

            public String getAir_press() {
                return air_press;
            }

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public List<_$3hourForcastBeanX> get_$3hourForcast() {
                return _$3hourForcast;
            }

            public void set_$3hourForcast(List<_$3hourForcastBeanX> _$3hourForcast) {
                this._$3hourForcast = _$3hourForcast;
            }

            public static class IndexBeanX {
                /**
                 * yh : {"title":"较不适宜","desc":"建议尽量不要去室外约会。"}
                 * ls : {"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"}
                 * clothes : {"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"}
                 * dy : {"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"}
                 * sports : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * travel : {"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"}
                 * beauty : {"title":"保湿","desc":"请选用保湿型霜类化妆品。"}
                 * xq : {"title":"较差","desc":"天气热，容易烦躁"}
                 * hc : {"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"}
                 * zs : {"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"}
                 * cold : {"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"}
                 * gj : {"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"}
                 * comfort : {"title":"较差","desc":"偏热或较热，部分人感觉不舒适"}
                 * uv : {"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"}
                 * cl : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * glass : {"title":"不需要","desc":"不需要佩戴"}
                 * aqi : {"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"}
                 * ac : {"title":"暂缺","desc":"暂缺"}
                 * wash_car : {"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"}
                 * mf : {"title":"暂缺","desc":"暂缺"}
                 * ag : {"title":"暂缺","desc":"暂缺"}
                 * pj : {"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"}
                 * nl : {"title":"暂缺","desc":"暂缺"}
                 * pk : {"title":"不宜","desc":"天气酷热，不适宜放风筝。"}
                 */

                private YhBeanX yh;
                private LsBeanX ls;
                private ClothesBeanX clothes;
                private DyBeanX dy;
                private SportsBeanX sports;
                private TravelBeanX travel;
                private BeautyBeanX beauty;
                private XqBeanX xq;
                private HcBeanX hc;
                private ZsBeanX zs;
                private ColdBeanX cold;
                private GjBeanX gj;
                private ComfortBeanX comfort;
                private UvBeanX uv;
                private ClBeanX cl;
                private GlassBeanX glass;
                private AqiBeanX aqi;
                private AcBeanX ac;
                private WashCarBeanX wash_car;
                private MfBeanX mf;
                private AgBeanX ag;
                private PjBeanX pj;
                private NlBeanX nl;
                private PkBeanX pk;

                public YhBeanX getYh() {
                    return yh;
                }

                public void setYh(YhBeanX yh) {
                    this.yh = yh;
                }

                public LsBeanX getLs() {
                    return ls;
                }

                public void setLs(LsBeanX ls) {
                    this.ls = ls;
                }

                public ClothesBeanX getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBeanX clothes) {
                    this.clothes = clothes;
                }

                public DyBeanX getDy() {
                    return dy;
                }

                public void setDy(DyBeanX dy) {
                    this.dy = dy;
                }

                public SportsBeanX getSports() {
                    return sports;
                }

                public void setSports(SportsBeanX sports) {
                    this.sports = sports;
                }

                public TravelBeanX getTravel() {
                    return travel;
                }

                public void setTravel(TravelBeanX travel) {
                    this.travel = travel;
                }

                public BeautyBeanX getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyBeanX beauty) {
                    this.beauty = beauty;
                }

                public XqBeanX getXq() {
                    return xq;
                }

                public void setXq(XqBeanX xq) {
                    this.xq = xq;
                }

                public HcBeanX getHc() {
                    return hc;
                }

                public void setHc(HcBeanX hc) {
                    this.hc = hc;
                }

                public ZsBeanX getZs() {
                    return zs;
                }

                public void setZs(ZsBeanX zs) {
                    this.zs = zs;
                }

                public ColdBeanX getCold() {
                    return cold;
                }

                public void setCold(ColdBeanX cold) {
                    this.cold = cold;
                }

                public GjBeanX getGj() {
                    return gj;
                }

                public void setGj(GjBeanX gj) {
                    this.gj = gj;
                }

                public ComfortBeanX getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBeanX comfort) {
                    this.comfort = comfort;
                }

                public UvBeanX getUv() {
                    return uv;
                }

                public void setUv(UvBeanX uv) {
                    this.uv = uv;
                }

                public ClBeanX getCl() {
                    return cl;
                }

                public void setCl(ClBeanX cl) {
                    this.cl = cl;
                }

                public GlassBeanX getGlass() {
                    return glass;
                }

                public void setGlass(GlassBeanX glass) {
                    this.glass = glass;
                }

                public AqiBeanX getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBeanX aqi) {
                    this.aqi = aqi;
                }

                public AcBeanX getAc() {
                    return ac;
                }

                public void setAc(AcBeanX ac) {
                    this.ac = ac;
                }

                public WashCarBeanX getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBeanX wash_car) {
                    this.wash_car = wash_car;
                }

                public MfBeanX getMf() {
                    return mf;
                }

                public void setMf(MfBeanX mf) {
                    this.mf = mf;
                }

                public AgBeanX getAg() {
                    return ag;
                }

                public void setAg(AgBeanX ag) {
                    this.ag = ag;
                }

                public PjBeanX getPj() {
                    return pj;
                }

                public void setPj(PjBeanX pj) {
                    this.pj = pj;
                }

                public NlBeanX getNl() {
                    return nl;
                }

                public void setNl(NlBeanX nl) {
                    this.nl = nl;
                }

                public PkBeanX getPk() {
                    return pk;
                }

                public void setPk(PkBeanX pk) {
                    this.pk = pk;
                }

                public static class YhBeanX {
                    /**
                     * title : 较不适宜
                     * desc : 建议尽量不要去室外约会。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class LsBeanX {
                    /**
                     * title : 不适宜
                     * desc : 有降水会淋湿衣物，不适宜晾晒。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBeanX {
                    /**
                     * title : 热
                     * desc : 适合穿T恤、短薄外套等夏季服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DyBeanX {
                    /**
                     * title : 不适宜钓鱼
                     * desc : 天气不好，不适合垂钓
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class SportsBeanX {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBeanX {
                    /**
                     * title : 较不宜
                     * desc : 有降水气温高，注意防暑降温携带雨具。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class BeautyBeanX {
                    /**
                     * title : 保湿
                     * desc : 请选用保湿型霜类化妆品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class XqBeanX {
                    /**
                     * title : 较差
                     * desc : 天气热，容易烦躁
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class HcBeanX {
                    /**
                     * title : 不适宜
                     * desc : 天气不好，建议选择别的娱乐方式。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ZsBeanX {
                    /**
                     * title : 可能中暑
                     * desc : 气温较高，易中暑人群注意阴凉休息。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdBeanX {
                    /**
                     * title : 少发
                     * desc : 感冒机率较低，避免长期处于空调屋中。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GjBeanX {
                    /**
                     * title : 不适宜
                     * desc : 有降水，出门带雨具并注意防雷。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBeanX {
                    /**
                     * title : 较差
                     * desc : 偏热或较热，部分人感觉不舒适
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBeanX {
                    /**
                     * title : 弱
                     * desc : 辐射较弱，涂擦SPF12-15、PA+护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClBeanX {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GlassBeanX {
                    /**
                     * title : 不需要
                     * desc : 不需要佩戴
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBeanX {
                    /**
                     * title : 优质
                     * desc : 空气很好，可以外出活动，呼吸新鲜空气
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AcBeanX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBeanX {
                    /**
                     * title : 不适宜
                     * desc : 有雨，雨水和泥水会弄脏爱车。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class MfBeanX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AgBeanX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PjBeanX {
                    /**
                     * title : 适宜
                     * desc : 天热潮湿，可饮用清凉的啤酒，不要贪杯。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class NlBeanX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PkBeanX {
                    /**
                     * title : 不宜
                     * desc : 天气酷热，不适宜放风筝。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class _$3hourForcastBeanX {
                /**
                 * wind_direction : 东北风
                 * temperature_max : 29
                 * wind_power : 微风,3
                 * weather : 小雨
                 * weather_pic : http://app1.showapi.com/weather/icon/day/07.png
                 * temperature_min : 25
                 * hour : 8时-14时
                 * temperature : 25
                 */

                private String wind_direction;
                private String temperature_max;
                private String wind_power;
                private String weather;
                private String weather_pic;
                private String temperature_min;
                private String hour;
                private String temperature;

                public String getWind_direction() {
                    return wind_direction;
                }

                public void setWind_direction(String wind_direction) {
                    this.wind_direction = wind_direction;
                }

                public String getTemperature_max() {
                    return temperature_max;
                }

                public void setTemperature_max(String temperature_max) {
                    this.temperature_max = temperature_max;
                }

                public String getWind_power() {
                    return wind_power;
                }

                public void setWind_power(String wind_power) {
                    this.wind_power = wind_power;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getWeather_pic() {
                    return weather_pic;
                }

                public void setWeather_pic(String weather_pic) {
                    this.weather_pic = weather_pic;
                }

                public String getTemperature_min() {
                    return temperature_min;
                }

                public void setTemperature_min(String temperature_min) {
                    this.temperature_min = temperature_min;
                }

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class CityInfoBean {
            /**
             * c6 : shanghai
             * c5 : 上海
             * c4 : shanghai
             * c3 : 上海
             * c9 : 中国
             * c8 : china
             * c7 : 上海
             * c17 : +8
             * c16 : AZ9210
             * c1 : 101020100
             * c2 : shanghai
             * c11 : 021
             * longitude : 121.445
             * c10 : 1
             * latitude : 31.213
             * c12 : 200000
             * c15 : 19
             */

            private String c6;
            private String c5;
            private String c4;
            private String c3;
            private String c9;
            private String c8;
            private String c7;
            private String c17;
            private String c16;
            private String c1;
            private String c2;
            private String c11;
            private double longitude;
            private String c10;
            private double latitude;
            private String c12;
            private String c15;

            public String getC6() {
                return c6;
            }

            public void setC6(String c6) {
                this.c6 = c6;
            }

            public String getC5() {
                return c5;
            }

            public void setC5(String c5) {
                this.c5 = c5;
            }

            public String getC4() {
                return c4;
            }

            public void setC4(String c4) {
                this.c4 = c4;
            }

            public String getC3() {
                return c3;
            }

            public void setC3(String c3) {
                this.c3 = c3;
            }

            public String getC9() {
                return c9;
            }

            public void setC9(String c9) {
                this.c9 = c9;
            }

            public String getC8() {
                return c8;
            }

            public void setC8(String c8) {
                this.c8 = c8;
            }

            public String getC7() {
                return c7;
            }

            public void setC7(String c7) {
                this.c7 = c7;
            }

            public String getC17() {
                return c17;
            }

            public void setC17(String c17) {
                this.c17 = c17;
            }

            public String getC16() {
                return c16;
            }

            public void setC16(String c16) {
                this.c16 = c16;
            }

            public String getC1() {
                return c1;
            }

            public void setC1(String c1) {
                this.c1 = c1;
            }

            public String getC2() {
                return c2;
            }

            public void setC2(String c2) {
                this.c2 = c2;
            }

            public String getC11() {
                return c11;
            }

            public void setC11(String c11) {
                this.c11 = c11;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getC10() {
                return c10;
            }

            public void setC10(String c10) {
                this.c10 = c10;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getC12() {
                return c12;
            }

            public void setC12(String c12) {
                this.c12 = c12;
            }

            public String getC15() {
                return c15;
            }

            public void setC15(String c15) {
                this.c15 = c15;
            }
        }

        public static class NowBean {
            /**
             * aqiDetail : {"co":"1.02","num":"240","so2":"10","area":"上海","o3":"53","no2":"58","quality":"良好","aqi":"56","pm10":"59","pm2_5":"24","o3_8h":"50","primary_pollutant":"颗粒物(PM10)"}
             * weather_code : 01
             * temperature_time : 11:00
             * wind_direction : 西南风
             * wind_power : 1级
             * sd : 58%
             * aqi : 56
             * weather : 多云
             * weather_pic : http://app1.showapi.com/weather/icon/day/01.png
             * temperature : 34
             */

            private AqiDetailBean aqiDetail;
            private String weather_code;
            private String temperature_time;
            private String wind_direction;
            private String wind_power;
            private String sd;
            private String aqi;
            private String weather;
            private String weather_pic;
            private String temperature;

            public AqiDetailBean getAqiDetail() {
                return aqiDetail;
            }

            public void setAqiDetail(AqiDetailBean aqiDetail) {
                this.aqiDetail = aqiDetail;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public String getTemperature_time() {
                return temperature_time;
            }

            public void setTemperature_time(String temperature_time) {
                this.temperature_time = temperature_time;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_power() {
                return wind_power;
            }

            public void setWind_power(String wind_power) {
                this.wind_power = wind_power;
            }

            public String getSd() {
                return sd;
            }

            public void setSd(String sd) {
                this.sd = sd;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWeather_pic() {
                return weather_pic;
            }

            public void setWeather_pic(String weather_pic) {
                this.weather_pic = weather_pic;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public static class AqiDetailBean {
                /**
                 * co : 1.02
                 * num : 240
                 * so2 : 10
                 * area : 上海
                 * o3 : 53
                 * no2 : 58
                 * quality : 良好
                 * aqi : 56
                 * pm10 : 59
                 * pm2_5 : 24
                 * o3_8h : 50
                 * primary_pollutant : 颗粒物(PM10)
                 */

                private String co;
                private String num;
                private String so2;
                private String area;
                private String o3;
                private String no2;
                private String quality;
                private String aqi;
                private String pm10;
                private String pm2_5;
                private String o3_8h;
                private String primary_pollutant;

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNum() {
                    return num;
                }

                public void setNum(String num) {
                    this.num = num;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm2_5() {
                    return pm2_5;
                }

                public void setPm2_5(String pm2_5) {
                    this.pm2_5 = pm2_5;
                }

                public String getO3_8h() {
                    return o3_8h;
                }

                public void setO3_8h(String o3_8h) {
                    this.o3_8h = o3_8h;
                }

                public String getPrimary_pollutant() {
                    return primary_pollutant;
                }

                public void setPrimary_pollutant(String primary_pollutant) {
                    this.primary_pollutant = primary_pollutant;
                }
            }
        }

        public static class F1Bean {
            /**
             * day_weather : 雷阵雨
             * night_weather : 雷阵雨
             * night_weather_code : 04
             * index : {"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"部分时间开启","desc":"天气燥热需适当开启空调，以免中暑。"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"一般","desc":"天热，头皮皮脂分泌多，注意清洁。"},"ag":{"title":"易发","desc":"应减少外出，外出需采取防护措施。"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"较适宜","desc":"只要您稍作准备就可以放心外出。"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}}
             * air_press : 1008 hPa
             * jiangshui : 82%
             * night_wind_power : 微风 <5.4m/s
             * day_wind_power : 微风 <5.4m/s
             * day_weather_code : 04
             * 3hourForcast : [{"wind_direction":"西北风","temperature_max":"30","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"8时-11时","temperature":"30"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"30","hour":"11时-14时","temperature":"30"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"30","hour":"14时-17时","temperature":"33"},{"wind_direction":"西北风","temperature_max":"33","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"27","hour":"17时-20时","temperature":"32"},{"wind_direction":"西北风","temperature_max":"32","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"26","hour":"20时-23时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"23时-2时","temperature":"26"},{"wind_direction":"东北风","temperature_max":"26","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"2时-5时","temperature":"26"},{"wind_direction":"东北风","temperature_max":"28","wind_power":"微风,0","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/night/04.png","temperature_min":"26","hour":"5时-8时","temperature":"26"}]
             * sun_begin_end : 05:25|18:27
             * ziwaixian : 很强
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/04.png
             * weekday : 5
             * night_air_temperature : 26
             * day_air_temperature : 34
             * day_wind_direction : 西北风
             * day : 20170825
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/04.png
             * night_wind_direction : 东北风
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBeanXX index;
            private String air_press;
            private String jiangshui;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String ziwaixian;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;
            @SerializedName("3hourForcast")
            private List<_$3hourForcastBeanXX> _$3hourForcast;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBeanXX getIndex() {
                return index;
            }

            public void setIndex(IndexBeanXX index) {
                this.index = index;
            }

            public String getAir_press() {
                return air_press;
            }

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public List<_$3hourForcastBeanXX> get_$3hourForcast() {
                return _$3hourForcast;
            }

            public void set_$3hourForcast(List<_$3hourForcastBeanXX> _$3hourForcast) {
                this._$3hourForcast = _$3hourForcast;
            }

            public static class IndexBeanXX {
                /**
                 * yh : {"title":"较不适宜","desc":"建议尽量不要去室外约会。"}
                 * ls : {"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"}
                 * clothes : {"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"}
                 * dy : {"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"}
                 * sports : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * travel : {"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"}
                 * beauty : {"title":"保湿","desc":"请选用保湿型霜类化妆品。"}
                 * xq : {"title":"较差","desc":"天气热，容易烦躁"}
                 * hc : {"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"}
                 * zs : {"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"}
                 * cold : {"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"}
                 * gj : {"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"}
                 * comfort : {"title":"较差","desc":"偏热或较热，部分人感觉不舒适"}
                 * uv : {"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"}
                 * cl : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * glass : {"title":"不需要","desc":"不需要佩戴"}
                 * aqi : {"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"}
                 * ac : {"title":"部分时间开启","desc":"天气燥热需适当开启空调，以免中暑。"}
                 * wash_car : {"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"}
                 * mf : {"title":"一般","desc":"天热，头皮皮脂分泌多，注意清洁。"}
                 * ag : {"title":"易发","desc":"应减少外出，外出需采取防护措施。"}
                 * pj : {"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"}
                 * nl : {"title":"较适宜","desc":"只要您稍作准备就可以放心外出。"}
                 * pk : {"title":"不宜","desc":"天气酷热，不适宜放风筝。"}
                 */

                private YhBeanXX yh;
                private LsBeanXX ls;
                private ClothesBeanXX clothes;
                private DyBeanXX dy;
                private SportsBeanXX sports;
                private TravelBeanXX travel;
                private BeautyBeanXX beauty;
                private XqBeanXX xq;
                private HcBeanXX hc;
                private ZsBeanXX zs;
                private ColdBeanXX cold;
                private GjBeanXX gj;
                private ComfortBeanXX comfort;
                private UvBeanXX uv;
                private ClBeanXX cl;
                private GlassBeanXX glass;
                private AqiBeanXX aqi;
                private AcBeanXX ac;
                private WashCarBeanXX wash_car;
                private MfBeanXX mf;
                private AgBeanXX ag;
                private PjBeanXX pj;
                private NlBeanXX nl;
                private PkBeanXX pk;

                public YhBeanXX getYh() {
                    return yh;
                }

                public void setYh(YhBeanXX yh) {
                    this.yh = yh;
                }

                public LsBeanXX getLs() {
                    return ls;
                }

                public void setLs(LsBeanXX ls) {
                    this.ls = ls;
                }

                public ClothesBeanXX getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBeanXX clothes) {
                    this.clothes = clothes;
                }

                public DyBeanXX getDy() {
                    return dy;
                }

                public void setDy(DyBeanXX dy) {
                    this.dy = dy;
                }

                public SportsBeanXX getSports() {
                    return sports;
                }

                public void setSports(SportsBeanXX sports) {
                    this.sports = sports;
                }

                public TravelBeanXX getTravel() {
                    return travel;
                }

                public void setTravel(TravelBeanXX travel) {
                    this.travel = travel;
                }

                public BeautyBeanXX getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyBeanXX beauty) {
                    this.beauty = beauty;
                }

                public XqBeanXX getXq() {
                    return xq;
                }

                public void setXq(XqBeanXX xq) {
                    this.xq = xq;
                }

                public HcBeanXX getHc() {
                    return hc;
                }

                public void setHc(HcBeanXX hc) {
                    this.hc = hc;
                }

                public ZsBeanXX getZs() {
                    return zs;
                }

                public void setZs(ZsBeanXX zs) {
                    this.zs = zs;
                }

                public ColdBeanXX getCold() {
                    return cold;
                }

                public void setCold(ColdBeanXX cold) {
                    this.cold = cold;
                }

                public GjBeanXX getGj() {
                    return gj;
                }

                public void setGj(GjBeanXX gj) {
                    this.gj = gj;
                }

                public ComfortBeanXX getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBeanXX comfort) {
                    this.comfort = comfort;
                }

                public UvBeanXX getUv() {
                    return uv;
                }

                public void setUv(UvBeanXX uv) {
                    this.uv = uv;
                }

                public ClBeanXX getCl() {
                    return cl;
                }

                public void setCl(ClBeanXX cl) {
                    this.cl = cl;
                }

                public GlassBeanXX getGlass() {
                    return glass;
                }

                public void setGlass(GlassBeanXX glass) {
                    this.glass = glass;
                }

                public AqiBeanXX getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBeanXX aqi) {
                    this.aqi = aqi;
                }

                public AcBeanXX getAc() {
                    return ac;
                }

                public void setAc(AcBeanXX ac) {
                    this.ac = ac;
                }

                public WashCarBeanXX getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBeanXX wash_car) {
                    this.wash_car = wash_car;
                }

                public MfBeanXX getMf() {
                    return mf;
                }

                public void setMf(MfBeanXX mf) {
                    this.mf = mf;
                }

                public AgBeanXX getAg() {
                    return ag;
                }

                public void setAg(AgBeanXX ag) {
                    this.ag = ag;
                }

                public PjBeanXX getPj() {
                    return pj;
                }

                public void setPj(PjBeanXX pj) {
                    this.pj = pj;
                }

                public NlBeanXX getNl() {
                    return nl;
                }

                public void setNl(NlBeanXX nl) {
                    this.nl = nl;
                }

                public PkBeanXX getPk() {
                    return pk;
                }

                public void setPk(PkBeanXX pk) {
                    this.pk = pk;
                }

                public static class YhBeanXX {
                    /**
                     * title : 较不适宜
                     * desc : 建议尽量不要去室外约会。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class LsBeanXX {
                    /**
                     * title : 不适宜
                     * desc : 有降水会淋湿衣物，不适宜晾晒。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBeanXX {
                    /**
                     * title : 热
                     * desc : 适合穿T恤、短薄外套等夏季服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DyBeanXX {
                    /**
                     * title : 不适宜钓鱼
                     * desc : 天气不好，不适合垂钓
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class SportsBeanXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBeanXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水气温高，注意防暑降温携带雨具。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class BeautyBeanXX {
                    /**
                     * title : 保湿
                     * desc : 请选用保湿型霜类化妆品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class XqBeanXX {
                    /**
                     * title : 较差
                     * desc : 天气热，容易烦躁
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class HcBeanXX {
                    /**
                     * title : 不适宜
                     * desc : 天气不好，建议选择别的娱乐方式。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ZsBeanXX {
                    /**
                     * title : 可能中暑
                     * desc : 气温较高，易中暑人群注意阴凉休息。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdBeanXX {
                    /**
                     * title : 少发
                     * desc : 感冒机率较低，避免长期处于空调屋中。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GjBeanXX {
                    /**
                     * title : 不适宜
                     * desc : 有降水，出门带雨具并注意防雷。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBeanXX {
                    /**
                     * title : 较差
                     * desc : 偏热或较热，部分人感觉不舒适
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBeanXX {
                    /**
                     * title : 弱
                     * desc : 辐射较弱，涂擦SPF12-15、PA+护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClBeanXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GlassBeanXX {
                    /**
                     * title : 不需要
                     * desc : 不需要佩戴
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBeanXX {
                    /**
                     * title : 优质
                     * desc : 空气很好，可以外出活动，呼吸新鲜空气
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AcBeanXX {
                    /**
                     * title : 部分时间开启
                     * desc : 天气燥热需适当开启空调，以免中暑。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBeanXX {
                    /**
                     * title : 不适宜
                     * desc : 有雨，雨水和泥水会弄脏爱车。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class MfBeanXX {
                    /**
                     * title : 一般
                     * desc : 天热，头皮皮脂分泌多，注意清洁。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AgBeanXX {
                    /**
                     * title : 易发
                     * desc : 应减少外出，外出需采取防护措施。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PjBeanXX {
                    /**
                     * title : 适宜
                     * desc : 天热潮湿，可饮用清凉的啤酒，不要贪杯。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class NlBeanXX {
                    /**
                     * title : 较适宜
                     * desc : 只要您稍作准备就可以放心外出。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PkBeanXX {
                    /**
                     * title : 不宜
                     * desc : 天气酷热，不适宜放风筝。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class _$3hourForcastBeanXX {
                /**
                 * wind_direction : 西北风
                 * temperature_max : 30
                 * wind_power : 微风,1
                 * weather : 多云
                 * weather_pic : http://app1.showapi.com/weather/icon/day/01.png
                 * temperature_min : 30
                 * hour : 8时-11时
                 * temperature : 30
                 */

                private String wind_direction;
                private String temperature_max;
                private String wind_power;
                private String weather;
                private String weather_pic;
                private String temperature_min;
                private String hour;
                private String temperature;

                public String getWind_direction() {
                    return wind_direction;
                }

                public void setWind_direction(String wind_direction) {
                    this.wind_direction = wind_direction;
                }

                public String getTemperature_max() {
                    return temperature_max;
                }

                public void setTemperature_max(String temperature_max) {
                    this.temperature_max = temperature_max;
                }

                public String getWind_power() {
                    return wind_power;
                }

                public void setWind_power(String wind_power) {
                    this.wind_power = wind_power;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getWeather_pic() {
                    return weather_pic;
                }

                public void setWeather_pic(String weather_pic) {
                    this.weather_pic = weather_pic;
                }

                public String getTemperature_min() {
                    return temperature_min;
                }

                public void setTemperature_min(String temperature_min) {
                    this.temperature_min = temperature_min;
                }

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class F3Bean {
            /**
             * day_weather : 多云
             * night_weather : 多云
             * night_weather_code : 01
             * index : {"yh":{"title":"较适宜","desc":"天气较好，适宜约会"},"ls":{"title":"不适宜","desc":"天气阴沉，不太适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"天气炎热，建议停止户外运动。"},"travel":{"title":"较适宜","desc":"天热注意防晒，可选择水上娱乐项目。"},"beauty":{"title":"去油","desc":"请选用露质面霜打底，水质无油粉底霜。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"适宜","desc":"天气较好，适宜划船及嬉玩水上运动。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"适宜","desc":"这种好天气去逛街可使身心畅快放松。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"天气炎热，建议停止户外运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"适宜","desc":"无雨且风力较小，易保持清洁度。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"炎热干燥，适宜饮用冰镇啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}}
             * air_press : 1008 hPa
             * jiangshui : 12%
             * night_wind_power : 微风 <5.4m/s
             * day_wind_power : 微风 <5.4m/s
             * day_weather_code : 01
             * 3hourForcast : [{"wind_direction":"东风","temperature_max":"32","wind_power":"微风,3","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","temperature_min":"26","hour":"8时-11时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"32","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"11时-14时","temperature":"32"},{"wind_direction":"东南风","temperature_max":"32","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"30","hour":"14时-17时","temperature":"31"},{"wind_direction":"东南风","temperature_max":"31","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"29","hour":"17时-20时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"30","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"20时-23时","temperature":"29"},{"wind_direction":"东南风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"23时-2时","temperature":"28"},{"wind_direction":"东南风","temperature_max":"28","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"2时-5时","temperature":"28"},{"wind_direction":"东南风","temperature_max":"30","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"5时-8时","temperature":"27"}]
             * sun_begin_end : 05:27|18:25
             * ziwaixian : 很强
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/01.png
             * weekday : 7
             * night_air_temperature : 27
             * day_air_temperature : 33
             * day_wind_direction : 东南风
             * day : 20170827
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/01.png
             * night_wind_direction : 东南风
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBeanXXX index;
            private String air_press;
            private String jiangshui;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String ziwaixian;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;
            @SerializedName("3hourForcast")
            private List<_$3hourForcastBeanXXX> _$3hourForcast;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBeanXXX getIndex() {
                return index;
            }

            public void setIndex(IndexBeanXXX index) {
                this.index = index;
            }

            public String getAir_press() {
                return air_press;
            }

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public List<_$3hourForcastBeanXXX> get_$3hourForcast() {
                return _$3hourForcast;
            }

            public void set_$3hourForcast(List<_$3hourForcastBeanXXX> _$3hourForcast) {
                this._$3hourForcast = _$3hourForcast;
            }

            public static class IndexBeanXXX {
                /**
                 * yh : {"title":"较适宜","desc":"天气较好，适宜约会"}
                 * ls : {"title":"不适宜","desc":"天气阴沉，不太适宜晾晒。"}
                 * clothes : {"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"}
                 * dy : {"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"}
                 * sports : {"title":"较不宜","desc":"天气炎热，建议停止户外运动。"}
                 * travel : {"title":"较适宜","desc":"天热注意防晒，可选择水上娱乐项目。"}
                 * beauty : {"title":"去油","desc":"请选用露质面霜打底，水质无油粉底霜。"}
                 * xq : {"title":"较差","desc":"天气热，容易烦躁"}
                 * hc : {"title":"适宜","desc":"天气较好，适宜划船及嬉玩水上运动。"}
                 * zs : {"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"}
                 * cold : {"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"}
                 * gj : {"title":"适宜","desc":"这种好天气去逛街可使身心畅快放松。"}
                 * comfort : {"title":"较差","desc":"偏热或较热，部分人感觉不舒适"}
                 * uv : {"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"}
                 * cl : {"title":"较不宜","desc":"天气炎热，建议停止户外运动。"}
                 * glass : {"title":"不需要","desc":"不需要佩戴"}
                 * aqi : {"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"}
                 * ac : {"title":"暂缺","desc":"暂缺"}
                 * wash_car : {"title":"适宜","desc":"无雨且风力较小，易保持清洁度。"}
                 * mf : {"title":"暂缺","desc":"暂缺"}
                 * ag : {"title":"暂缺","desc":"暂缺"}
                 * pj : {"title":"适宜","desc":"炎热干燥，适宜饮用冰镇啤酒，不要贪杯。"}
                 * nl : {"title":"暂缺","desc":"暂缺"}
                 * pk : {"title":"不宜","desc":"天气酷热，不适宜放风筝。"}
                 */

                private YhBeanXXX yh;
                private LsBeanXXX ls;
                private ClothesBeanXXX clothes;
                private DyBeanXXX dy;
                private SportsBeanXXX sports;
                private TravelBeanXXX travel;
                private BeautyBeanXXX beauty;
                private XqBeanXXX xq;
                private HcBeanXXX hc;
                private ZsBeanXXX zs;
                private ColdBeanXXX cold;
                private GjBeanXXX gj;
                private ComfortBeanXXX comfort;
                private UvBeanXXX uv;
                private ClBeanXXX cl;
                private GlassBeanXXX glass;
                private AqiBeanXXX aqi;
                private AcBeanXXX ac;
                private WashCarBeanXXX wash_car;
                private MfBeanXXX mf;
                private AgBeanXXX ag;
                private PjBeanXXX pj;
                private NlBeanXXX nl;
                private PkBeanXXX pk;

                public YhBeanXXX getYh() {
                    return yh;
                }

                public void setYh(YhBeanXXX yh) {
                    this.yh = yh;
                }

                public LsBeanXXX getLs() {
                    return ls;
                }

                public void setLs(LsBeanXXX ls) {
                    this.ls = ls;
                }

                public ClothesBeanXXX getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBeanXXX clothes) {
                    this.clothes = clothes;
                }

                public DyBeanXXX getDy() {
                    return dy;
                }

                public void setDy(DyBeanXXX dy) {
                    this.dy = dy;
                }

                public SportsBeanXXX getSports() {
                    return sports;
                }

                public void setSports(SportsBeanXXX sports) {
                    this.sports = sports;
                }

                public TravelBeanXXX getTravel() {
                    return travel;
                }

                public void setTravel(TravelBeanXXX travel) {
                    this.travel = travel;
                }

                public BeautyBeanXXX getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyBeanXXX beauty) {
                    this.beauty = beauty;
                }

                public XqBeanXXX getXq() {
                    return xq;
                }

                public void setXq(XqBeanXXX xq) {
                    this.xq = xq;
                }

                public HcBeanXXX getHc() {
                    return hc;
                }

                public void setHc(HcBeanXXX hc) {
                    this.hc = hc;
                }

                public ZsBeanXXX getZs() {
                    return zs;
                }

                public void setZs(ZsBeanXXX zs) {
                    this.zs = zs;
                }

                public ColdBeanXXX getCold() {
                    return cold;
                }

                public void setCold(ColdBeanXXX cold) {
                    this.cold = cold;
                }

                public GjBeanXXX getGj() {
                    return gj;
                }

                public void setGj(GjBeanXXX gj) {
                    this.gj = gj;
                }

                public ComfortBeanXXX getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBeanXXX comfort) {
                    this.comfort = comfort;
                }

                public UvBeanXXX getUv() {
                    return uv;
                }

                public void setUv(UvBeanXXX uv) {
                    this.uv = uv;
                }

                public ClBeanXXX getCl() {
                    return cl;
                }

                public void setCl(ClBeanXXX cl) {
                    this.cl = cl;
                }

                public GlassBeanXXX getGlass() {
                    return glass;
                }

                public void setGlass(GlassBeanXXX glass) {
                    this.glass = glass;
                }

                public AqiBeanXXX getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBeanXXX aqi) {
                    this.aqi = aqi;
                }

                public AcBeanXXX getAc() {
                    return ac;
                }

                public void setAc(AcBeanXXX ac) {
                    this.ac = ac;
                }

                public WashCarBeanXXX getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBeanXXX wash_car) {
                    this.wash_car = wash_car;
                }

                public MfBeanXXX getMf() {
                    return mf;
                }

                public void setMf(MfBeanXXX mf) {
                    this.mf = mf;
                }

                public AgBeanXXX getAg() {
                    return ag;
                }

                public void setAg(AgBeanXXX ag) {
                    this.ag = ag;
                }

                public PjBeanXXX getPj() {
                    return pj;
                }

                public void setPj(PjBeanXXX pj) {
                    this.pj = pj;
                }

                public NlBeanXXX getNl() {
                    return nl;
                }

                public void setNl(NlBeanXXX nl) {
                    this.nl = nl;
                }

                public PkBeanXXX getPk() {
                    return pk;
                }

                public void setPk(PkBeanXXX pk) {
                    this.pk = pk;
                }

                public static class YhBeanXXX {
                    /**
                     * title : 较适宜
                     * desc : 天气较好，适宜约会
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class LsBeanXXX {
                    /**
                     * title : 不适宜
                     * desc : 天气阴沉，不太适宜晾晒。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBeanXXX {
                    /**
                     * title : 热
                     * desc : 适合穿T恤、短薄外套等夏季服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DyBeanXXX {
                    /**
                     * title : 不适宜钓鱼
                     * desc : 天气不好，不适合垂钓
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class SportsBeanXXX {
                    /**
                     * title : 较不宜
                     * desc : 天气炎热，建议停止户外运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBeanXXX {
                    /**
                     * title : 较适宜
                     * desc : 天热注意防晒，可选择水上娱乐项目。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class BeautyBeanXXX {
                    /**
                     * title : 去油
                     * desc : 请选用露质面霜打底，水质无油粉底霜。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class XqBeanXXX {
                    /**
                     * title : 较差
                     * desc : 天气热，容易烦躁
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class HcBeanXXX {
                    /**
                     * title : 适宜
                     * desc : 天气较好，适宜划船及嬉玩水上运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ZsBeanXXX {
                    /**
                     * title : 可能中暑
                     * desc : 气温较高，易中暑人群注意阴凉休息。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdBeanXXX {
                    /**
                     * title : 少发
                     * desc : 感冒机率较低，避免长期处于空调屋中。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GjBeanXXX {
                    /**
                     * title : 适宜
                     * desc : 这种好天气去逛街可使身心畅快放松。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBeanXXX {
                    /**
                     * title : 较差
                     * desc : 偏热或较热，部分人感觉不舒适
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBeanXXX {
                    /**
                     * title : 弱
                     * desc : 辐射较弱，涂擦SPF12-15、PA+护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClBeanXXX {
                    /**
                     * title : 较不宜
                     * desc : 天气炎热，建议停止户外运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GlassBeanXXX {
                    /**
                     * title : 不需要
                     * desc : 不需要佩戴
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBeanXXX {
                    /**
                     * title : 优质
                     * desc : 空气很好，可以外出活动，呼吸新鲜空气
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AcBeanXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBeanXXX {
                    /**
                     * title : 适宜
                     * desc : 无雨且风力较小，易保持清洁度。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class MfBeanXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AgBeanXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PjBeanXXX {
                    /**
                     * title : 适宜
                     * desc : 炎热干燥，适宜饮用冰镇啤酒，不要贪杯。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class NlBeanXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PkBeanXXX {
                    /**
                     * title : 不宜
                     * desc : 天气酷热，不适宜放风筝。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class _$3hourForcastBeanXXX {
                /**
                 * wind_direction : 东风
                 * temperature_max : 32
                 * wind_power : 微风,3
                 * weather : 阴
                 * weather_pic : http://app1.showapi.com/weather/icon/day/02.png
                 * temperature_min : 26
                 * hour : 8时-11时
                 * temperature : 30
                 */

                private String wind_direction;
                private String temperature_max;
                private String wind_power;
                private String weather;
                private String weather_pic;
                private String temperature_min;
                private String hour;
                private String temperature;

                public String getWind_direction() {
                    return wind_direction;
                }

                public void setWind_direction(String wind_direction) {
                    this.wind_direction = wind_direction;
                }

                public String getTemperature_max() {
                    return temperature_max;
                }

                public void setTemperature_max(String temperature_max) {
                    this.temperature_max = temperature_max;
                }

                public String getWind_power() {
                    return wind_power;
                }

                public void setWind_power(String wind_power) {
                    this.wind_power = wind_power;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getWeather_pic() {
                    return weather_pic;
                }

                public void setWeather_pic(String weather_pic) {
                    this.weather_pic = weather_pic;
                }

                public String getTemperature_min() {
                    return temperature_min;
                }

                public void setTemperature_min(String temperature_min) {
                    this.temperature_min = temperature_min;
                }

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class F2Bean {
            /**
             * day_weather : 雷阵雨
             * night_weather : 阴
             * night_weather_code : 02
             * index : {"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}}
             * air_press : 1008 hPa
             * jiangshui : 85%
             * night_wind_power : 微风 <5.4m/s
             * day_wind_power : 微风 <5.4m/s
             * day_weather_code : 04
             * 3hourForcast : [{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"26","hour":"8时-11时","temperature":"28"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,3","weather":"雷阵雨","weather_pic":"http://app1.showapi.com/weather/icon/day/04.png","temperature_min":"28","hour":"11时-14时","temperature":"30"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"29","hour":"14时-17时","temperature":"30"},{"wind_direction":"东北风","temperature_max":"30","wind_power":"微风,1","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"27","hour":"17时-20时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"27","hour":"20时-23时","temperature":"27"},{"wind_direction":"东风","temperature_max":"27","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"23时-2时","temperature":"27"},{"wind_direction":"东风","temperature_max":"27","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"2时-5时","temperature":"26"},{"wind_direction":"东风","temperature_max":"30","wind_power":"微风,0","weather":"阴","weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","temperature_min":"26","hour":"5时-8时","temperature":"26"}]
             * sun_begin_end : 05:26|18:26
             * ziwaixian : 很强
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/04.png
             * weekday : 6
             * night_air_temperature : 26
             * day_air_temperature : 31
             * day_wind_direction : 东北风
             * day : 20170826
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/02.png
             * night_wind_direction : 东风
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBeanXXXX index;
            private String air_press;
            private String jiangshui;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String ziwaixian;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;
            @SerializedName("3hourForcast")
            private List<_$3hourForcastBeanXXXX> _$3hourForcast;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBeanXXXX getIndex() {
                return index;
            }

            public void setIndex(IndexBeanXXXX index) {
                this.index = index;
            }

            public String getAir_press() {
                return air_press;
            }

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public List<_$3hourForcastBeanXXXX> get_$3hourForcast() {
                return _$3hourForcast;
            }

            public void set_$3hourForcast(List<_$3hourForcastBeanXXXX> _$3hourForcast) {
                this._$3hourForcast = _$3hourForcast;
            }

            public static class IndexBeanXXXX {
                /**
                 * yh : {"title":"较不适宜","desc":"建议尽量不要去室外约会。"}
                 * ls : {"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"}
                 * clothes : {"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"}
                 * dy : {"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"}
                 * sports : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * travel : {"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"}
                 * beauty : {"title":"保湿","desc":"请选用保湿型霜类化妆品。"}
                 * xq : {"title":"较差","desc":"天气热，容易烦躁"}
                 * hc : {"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"}
                 * zs : {"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"}
                 * cold : {"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"}
                 * gj : {"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"}
                 * comfort : {"title":"较差","desc":"偏热或较热，部分人感觉不舒适"}
                 * uv : {"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"}
                 * cl : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * glass : {"title":"不需要","desc":"不需要佩戴"}
                 * aqi : {"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"}
                 * ac : {"title":"暂缺","desc":"暂缺"}
                 * wash_car : {"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"}
                 * mf : {"title":"暂缺","desc":"暂缺"}
                 * ag : {"title":"暂缺","desc":"暂缺"}
                 * pj : {"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"}
                 * nl : {"title":"暂缺","desc":"暂缺"}
                 * pk : {"title":"不宜","desc":"天气酷热，不适宜放风筝。"}
                 */

                private YhBeanXXXX yh;
                private LsBeanXXXX ls;
                private ClothesBeanXXXX clothes;
                private DyBeanXXXX dy;
                private SportsBeanXXXX sports;
                private TravelBeanXXXX travel;
                private BeautyBeanXXXX beauty;
                private XqBeanXXXX xq;
                private HcBeanXXXX hc;
                private ZsBeanXXXX zs;
                private ColdBeanXXXX cold;
                private GjBeanXXXX gj;
                private ComfortBeanXXXX comfort;
                private UvBeanXXXX uv;
                private ClBeanXXXX cl;
                private GlassBeanXXXX glass;
                private AqiBeanXXXX aqi;
                private AcBeanXXXX ac;
                private WashCarBeanXXXX wash_car;
                private MfBeanXXXX mf;
                private AgBeanXXXX ag;
                private PjBeanXXXX pj;
                private NlBeanXXXX nl;
                private PkBeanXXXX pk;

                public YhBeanXXXX getYh() {
                    return yh;
                }

                public void setYh(YhBeanXXXX yh) {
                    this.yh = yh;
                }

                public LsBeanXXXX getLs() {
                    return ls;
                }

                public void setLs(LsBeanXXXX ls) {
                    this.ls = ls;
                }

                public ClothesBeanXXXX getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBeanXXXX clothes) {
                    this.clothes = clothes;
                }

                public DyBeanXXXX getDy() {
                    return dy;
                }

                public void setDy(DyBeanXXXX dy) {
                    this.dy = dy;
                }

                public SportsBeanXXXX getSports() {
                    return sports;
                }

                public void setSports(SportsBeanXXXX sports) {
                    this.sports = sports;
                }

                public TravelBeanXXXX getTravel() {
                    return travel;
                }

                public void setTravel(TravelBeanXXXX travel) {
                    this.travel = travel;
                }

                public BeautyBeanXXXX getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyBeanXXXX beauty) {
                    this.beauty = beauty;
                }

                public XqBeanXXXX getXq() {
                    return xq;
                }

                public void setXq(XqBeanXXXX xq) {
                    this.xq = xq;
                }

                public HcBeanXXXX getHc() {
                    return hc;
                }

                public void setHc(HcBeanXXXX hc) {
                    this.hc = hc;
                }

                public ZsBeanXXXX getZs() {
                    return zs;
                }

                public void setZs(ZsBeanXXXX zs) {
                    this.zs = zs;
                }

                public ColdBeanXXXX getCold() {
                    return cold;
                }

                public void setCold(ColdBeanXXXX cold) {
                    this.cold = cold;
                }

                public GjBeanXXXX getGj() {
                    return gj;
                }

                public void setGj(GjBeanXXXX gj) {
                    this.gj = gj;
                }

                public ComfortBeanXXXX getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBeanXXXX comfort) {
                    this.comfort = comfort;
                }

                public UvBeanXXXX getUv() {
                    return uv;
                }

                public void setUv(UvBeanXXXX uv) {
                    this.uv = uv;
                }

                public ClBeanXXXX getCl() {
                    return cl;
                }

                public void setCl(ClBeanXXXX cl) {
                    this.cl = cl;
                }

                public GlassBeanXXXX getGlass() {
                    return glass;
                }

                public void setGlass(GlassBeanXXXX glass) {
                    this.glass = glass;
                }

                public AqiBeanXXXX getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBeanXXXX aqi) {
                    this.aqi = aqi;
                }

                public AcBeanXXXX getAc() {
                    return ac;
                }

                public void setAc(AcBeanXXXX ac) {
                    this.ac = ac;
                }

                public WashCarBeanXXXX getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBeanXXXX wash_car) {
                    this.wash_car = wash_car;
                }

                public MfBeanXXXX getMf() {
                    return mf;
                }

                public void setMf(MfBeanXXXX mf) {
                    this.mf = mf;
                }

                public AgBeanXXXX getAg() {
                    return ag;
                }

                public void setAg(AgBeanXXXX ag) {
                    this.ag = ag;
                }

                public PjBeanXXXX getPj() {
                    return pj;
                }

                public void setPj(PjBeanXXXX pj) {
                    this.pj = pj;
                }

                public NlBeanXXXX getNl() {
                    return nl;
                }

                public void setNl(NlBeanXXXX nl) {
                    this.nl = nl;
                }

                public PkBeanXXXX getPk() {
                    return pk;
                }

                public void setPk(PkBeanXXXX pk) {
                    this.pk = pk;
                }

                public static class YhBeanXXXX {
                    /**
                     * title : 较不适宜
                     * desc : 建议尽量不要去室外约会。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class LsBeanXXXX {
                    /**
                     * title : 不适宜
                     * desc : 有降水会淋湿衣物，不适宜晾晒。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBeanXXXX {
                    /**
                     * title : 热
                     * desc : 适合穿T恤、短薄外套等夏季服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DyBeanXXXX {
                    /**
                     * title : 不适宜钓鱼
                     * desc : 天气不好，不适合垂钓
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class SportsBeanXXXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBeanXXXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水气温高，注意防暑降温携带雨具。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class BeautyBeanXXXX {
                    /**
                     * title : 保湿
                     * desc : 请选用保湿型霜类化妆品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class XqBeanXXXX {
                    /**
                     * title : 较差
                     * desc : 天气热，容易烦躁
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class HcBeanXXXX {
                    /**
                     * title : 不适宜
                     * desc : 天气不好，建议选择别的娱乐方式。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ZsBeanXXXX {
                    /**
                     * title : 可能中暑
                     * desc : 气温较高，易中暑人群注意阴凉休息。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdBeanXXXX {
                    /**
                     * title : 少发
                     * desc : 感冒机率较低，避免长期处于空调屋中。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GjBeanXXXX {
                    /**
                     * title : 不适宜
                     * desc : 有降水，出门带雨具并注意防雷。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBeanXXXX {
                    /**
                     * title : 较差
                     * desc : 偏热或较热，部分人感觉不舒适
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBeanXXXX {
                    /**
                     * title : 弱
                     * desc : 辐射较弱，涂擦SPF12-15、PA+护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClBeanXXXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GlassBeanXXXX {
                    /**
                     * title : 不需要
                     * desc : 不需要佩戴
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBeanXXXX {
                    /**
                     * title : 优质
                     * desc : 空气很好，可以外出活动，呼吸新鲜空气
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AcBeanXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBeanXXXX {
                    /**
                     * title : 不适宜
                     * desc : 有雨，雨水和泥水会弄脏爱车。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class MfBeanXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AgBeanXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PjBeanXXXX {
                    /**
                     * title : 适宜
                     * desc : 天热潮湿，可饮用清凉的啤酒，不要贪杯。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class NlBeanXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PkBeanXXXX {
                    /**
                     * title : 不宜
                     * desc : 天气酷热，不适宜放风筝。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class _$3hourForcastBeanXXXX {
                /**
                 * wind_direction : 东北风
                 * temperature_max : 30
                 * wind_power : 微风,3
                 * weather : 雷阵雨
                 * weather_pic : http://app1.showapi.com/weather/icon/day/04.png
                 * temperature_min : 26
                 * hour : 8时-11时
                 * temperature : 28
                 */

                private String wind_direction;
                private String temperature_max;
                private String wind_power;
                private String weather;
                private String weather_pic;
                private String temperature_min;
                private String hour;
                private String temperature;

                public String getWind_direction() {
                    return wind_direction;
                }

                public void setWind_direction(String wind_direction) {
                    this.wind_direction = wind_direction;
                }

                public String getTemperature_max() {
                    return temperature_max;
                }

                public void setTemperature_max(String temperature_max) {
                    this.temperature_max = temperature_max;
                }

                public String getWind_power() {
                    return wind_power;
                }

                public void setWind_power(String wind_power) {
                    this.wind_power = wind_power;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getWeather_pic() {
                    return weather_pic;
                }

                public void setWeather_pic(String weather_pic) {
                    this.weather_pic = weather_pic;
                }

                public String getTemperature_min() {
                    return temperature_min;
                }

                public void setTemperature_min(String temperature_min) {
                    this.temperature_min = temperature_min;
                }

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class F5Bean {
            /**
             * day_weather : 小雨
             * night_weather : 大雨
             * night_weather_code : 09
             * index : {"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"},"sports":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"travel":{"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"},"beauty":{"title":"保湿","desc":"请选用保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"易发","desc":"天冷湿度大，注意增加衣服。"},"gj":{"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"},"comfort":{"title":"较差","desc":"热，感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}}
             * air_press : 1008 hPa
             * jiangshui : 72%
             * night_wind_power : 3-4级 5.5~7.9m/s
             * day_wind_power : 4-5级 8.0~10.7m/s
             * day_weather_code : 07
             * 3hourForcast : [{"wind_direction":"西南风","temperature_max":"32","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"28","hour":"8时-14时","temperature":"29"},{"wind_direction":"东北风","temperature_max":"32","wind_power":"3-4级,3","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/day/08.png","temperature_min":"27","hour":"14时-20时","temperature":"32"},{"wind_direction":"东北风","temperature_max":"32","wind_power":"4-5级,0","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/night/08.png","temperature_min":"26","hour":"20时-2时","temperature":"27"},{"wind_direction":"东北风","temperature_max":"27","wind_power":"微风,0","weather":"中雨","weather_pic":"http://app1.showapi.com/weather/icon/night/08.png","temperature_min":"26","hour":"2时-8时","temperature":"26"}]
             * sun_begin_end : 05:28|18:22
             * ziwaixian : 很强
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/07.png
             * weekday : 2
             * night_air_temperature : 25
             * day_air_temperature : 32
             * day_wind_direction : 东北风
             * day : 20170829
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/09.png
             * night_wind_direction : 东北风
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBeanXXXXX index;
            private String air_press;
            private String jiangshui;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String ziwaixian;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;
            @SerializedName("3hourForcast")
            private List<_$3hourForcastBeanXXXXX> _$3hourForcast;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBeanXXXXX getIndex() {
                return index;
            }

            public void setIndex(IndexBeanXXXXX index) {
                this.index = index;
            }

            public String getAir_press() {
                return air_press;
            }

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public List<_$3hourForcastBeanXXXXX> get_$3hourForcast() {
                return _$3hourForcast;
            }

            public void set_$3hourForcast(List<_$3hourForcastBeanXXXXX> _$3hourForcast) {
                this._$3hourForcast = _$3hourForcast;
            }

            public static class IndexBeanXXXXX {
                /**
                 * yh : {"title":"较不适宜","desc":"建议尽量不要去室外约会。"}
                 * ls : {"title":"不适宜","desc":"有降水会淋湿衣物，不适宜晾晒。"}
                 * clothes : {"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"}
                 * dy : {"title":"不适宜钓鱼","desc":"天气不好，不适合垂钓"}
                 * sports : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * travel : {"title":"较不宜","desc":"有降水气温高，注意防暑降温携带雨具。"}
                 * beauty : {"title":"保湿","desc":"请选用保湿型霜类化妆品。"}
                 * xq : {"title":"较差","desc":"天气热，容易烦躁"}
                 * hc : {"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"}
                 * zs : {"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"}
                 * cold : {"title":"易发","desc":"天冷湿度大，注意增加衣服。"}
                 * gj : {"title":"不适宜","desc":"有降水，出门带雨具并注意防雷。"}
                 * comfort : {"title":"较差","desc":"热，感觉不舒适"}
                 * uv : {"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"}
                 * cl : {"title":"较不宜","desc":"有降水,推荐您在室内进行休闲运动。"}
                 * glass : {"title":"不需要","desc":"不需要佩戴"}
                 * aqi : {"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"}
                 * ac : {"title":"暂缺","desc":"暂缺"}
                 * wash_car : {"title":"不适宜","desc":"有雨，雨水和泥水会弄脏爱车。"}
                 * mf : {"title":"暂缺","desc":"暂缺"}
                 * ag : {"title":"暂缺","desc":"暂缺"}
                 * pj : {"title":"适宜","desc":"天热潮湿，可饮用清凉的啤酒，不要贪杯。"}
                 * nl : {"title":"暂缺","desc":"暂缺"}
                 * pk : {"title":"不宜","desc":"天气酷热，不适宜放风筝。"}
                 */

                private YhBeanXXXXX yh;
                private LsBeanXXXXX ls;
                private ClothesBeanXXXXX clothes;
                private DyBeanXXXXX dy;
                private SportsBeanXXXXX sports;
                private TravelBeanXXXXX travel;
                private BeautyBeanXXXXX beauty;
                private XqBeanXXXXX xq;
                private HcBeanXXXXX hc;
                private ZsBeanXXXXX zs;
                private ColdBeanXXXXX cold;
                private GjBeanXXXXX gj;
                private ComfortBeanXXXXX comfort;
                private UvBeanXXXXX uv;
                private ClBeanXXXXX cl;
                private GlassBeanXXXXX glass;
                private AqiBeanXXXXX aqi;
                private AcBeanXXXXX ac;
                private WashCarBeanXXXXX wash_car;
                private MfBeanXXXXX mf;
                private AgBeanXXXXX ag;
                private PjBeanXXXXX pj;
                private NlBeanXXXXX nl;
                private PkBeanXXXXX pk;

                public YhBeanXXXXX getYh() {
                    return yh;
                }

                public void setYh(YhBeanXXXXX yh) {
                    this.yh = yh;
                }

                public LsBeanXXXXX getLs() {
                    return ls;
                }

                public void setLs(LsBeanXXXXX ls) {
                    this.ls = ls;
                }

                public ClothesBeanXXXXX getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBeanXXXXX clothes) {
                    this.clothes = clothes;
                }

                public DyBeanXXXXX getDy() {
                    return dy;
                }

                public void setDy(DyBeanXXXXX dy) {
                    this.dy = dy;
                }

                public SportsBeanXXXXX getSports() {
                    return sports;
                }

                public void setSports(SportsBeanXXXXX sports) {
                    this.sports = sports;
                }

                public TravelBeanXXXXX getTravel() {
                    return travel;
                }

                public void setTravel(TravelBeanXXXXX travel) {
                    this.travel = travel;
                }

                public BeautyBeanXXXXX getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyBeanXXXXX beauty) {
                    this.beauty = beauty;
                }

                public XqBeanXXXXX getXq() {
                    return xq;
                }

                public void setXq(XqBeanXXXXX xq) {
                    this.xq = xq;
                }

                public HcBeanXXXXX getHc() {
                    return hc;
                }

                public void setHc(HcBeanXXXXX hc) {
                    this.hc = hc;
                }

                public ZsBeanXXXXX getZs() {
                    return zs;
                }

                public void setZs(ZsBeanXXXXX zs) {
                    this.zs = zs;
                }

                public ColdBeanXXXXX getCold() {
                    return cold;
                }

                public void setCold(ColdBeanXXXXX cold) {
                    this.cold = cold;
                }

                public GjBeanXXXXX getGj() {
                    return gj;
                }

                public void setGj(GjBeanXXXXX gj) {
                    this.gj = gj;
                }

                public ComfortBeanXXXXX getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBeanXXXXX comfort) {
                    this.comfort = comfort;
                }

                public UvBeanXXXXX getUv() {
                    return uv;
                }

                public void setUv(UvBeanXXXXX uv) {
                    this.uv = uv;
                }

                public ClBeanXXXXX getCl() {
                    return cl;
                }

                public void setCl(ClBeanXXXXX cl) {
                    this.cl = cl;
                }

                public GlassBeanXXXXX getGlass() {
                    return glass;
                }

                public void setGlass(GlassBeanXXXXX glass) {
                    this.glass = glass;
                }

                public AqiBeanXXXXX getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBeanXXXXX aqi) {
                    this.aqi = aqi;
                }

                public AcBeanXXXXX getAc() {
                    return ac;
                }

                public void setAc(AcBeanXXXXX ac) {
                    this.ac = ac;
                }

                public WashCarBeanXXXXX getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBeanXXXXX wash_car) {
                    this.wash_car = wash_car;
                }

                public MfBeanXXXXX getMf() {
                    return mf;
                }

                public void setMf(MfBeanXXXXX mf) {
                    this.mf = mf;
                }

                public AgBeanXXXXX getAg() {
                    return ag;
                }

                public void setAg(AgBeanXXXXX ag) {
                    this.ag = ag;
                }

                public PjBeanXXXXX getPj() {
                    return pj;
                }

                public void setPj(PjBeanXXXXX pj) {
                    this.pj = pj;
                }

                public NlBeanXXXXX getNl() {
                    return nl;
                }

                public void setNl(NlBeanXXXXX nl) {
                    this.nl = nl;
                }

                public PkBeanXXXXX getPk() {
                    return pk;
                }

                public void setPk(PkBeanXXXXX pk) {
                    this.pk = pk;
                }

                public static class YhBeanXXXXX {
                    /**
                     * title : 较不适宜
                     * desc : 建议尽量不要去室外约会。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class LsBeanXXXXX {
                    /**
                     * title : 不适宜
                     * desc : 有降水会淋湿衣物，不适宜晾晒。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBeanXXXXX {
                    /**
                     * title : 热
                     * desc : 适合穿T恤、短薄外套等夏季服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DyBeanXXXXX {
                    /**
                     * title : 不适宜钓鱼
                     * desc : 天气不好，不适合垂钓
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class SportsBeanXXXXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBeanXXXXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水气温高，注意防暑降温携带雨具。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class BeautyBeanXXXXX {
                    /**
                     * title : 保湿
                     * desc : 请选用保湿型霜类化妆品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class XqBeanXXXXX {
                    /**
                     * title : 较差
                     * desc : 天气热，容易烦躁
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class HcBeanXXXXX {
                    /**
                     * title : 不适宜
                     * desc : 天气不好，建议选择别的娱乐方式。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ZsBeanXXXXX {
                    /**
                     * title : 可能中暑
                     * desc : 气温较高，易中暑人群注意阴凉休息。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdBeanXXXXX {
                    /**
                     * title : 易发
                     * desc : 天冷湿度大，注意增加衣服。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GjBeanXXXXX {
                    /**
                     * title : 不适宜
                     * desc : 有降水，出门带雨具并注意防雷。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBeanXXXXX {
                    /**
                     * title : 较差
                     * desc : 热，感觉不舒适
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBeanXXXXX {
                    /**
                     * title : 弱
                     * desc : 辐射较弱，涂擦SPF12-15、PA+护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClBeanXXXXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水,推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GlassBeanXXXXX {
                    /**
                     * title : 不需要
                     * desc : 不需要佩戴
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBeanXXXXX {
                    /**
                     * title : 优质
                     * desc : 空气很好，可以外出活动，呼吸新鲜空气
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AcBeanXXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBeanXXXXX {
                    /**
                     * title : 不适宜
                     * desc : 有雨，雨水和泥水会弄脏爱车。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class MfBeanXXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AgBeanXXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PjBeanXXXXX {
                    /**
                     * title : 适宜
                     * desc : 天热潮湿，可饮用清凉的啤酒，不要贪杯。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class NlBeanXXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PkBeanXXXXX {
                    /**
                     * title : 不宜
                     * desc : 天气酷热，不适宜放风筝。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class _$3hourForcastBeanXXXXX {
                /**
                 * wind_direction : 西南风
                 * temperature_max : 32
                 * wind_power : 微风,2
                 * weather : 多云
                 * weather_pic : http://app1.showapi.com/weather/icon/day/01.png
                 * temperature_min : 28
                 * hour : 8时-14时
                 * temperature : 29
                 */

                private String wind_direction;
                private String temperature_max;
                private String wind_power;
                private String weather;
                private String weather_pic;
                private String temperature_min;
                private String hour;
                private String temperature;

                public String getWind_direction() {
                    return wind_direction;
                }

                public void setWind_direction(String wind_direction) {
                    this.wind_direction = wind_direction;
                }

                public String getTemperature_max() {
                    return temperature_max;
                }

                public void setTemperature_max(String temperature_max) {
                    this.temperature_max = temperature_max;
                }

                public String getWind_power() {
                    return wind_power;
                }

                public void setWind_power(String wind_power) {
                    this.wind_power = wind_power;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getWeather_pic() {
                    return weather_pic;
                }

                public void setWeather_pic(String weather_pic) {
                    this.weather_pic = weather_pic;
                }

                public String getTemperature_min() {
                    return temperature_min;
                }

                public void setTemperature_min(String temperature_min) {
                    this.temperature_min = temperature_min;
                }

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class F4Bean {
            /**
             * day_weather : 晴
             * night_weather : 多云
             * night_weather_code : 01
             * index : {"yh":{"title":"较适宜","desc":"不用担心天气来调皮捣乱而影响了兴致。 "},"ls":{"title":"较适宜","desc":"天气不错，抓紧时机让衣物晒太阳吧。"},"clothes":{"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"},"dy":{"title":"适宜钓鱼","desc":"风和日丽，适宜钓鱼。"},"sports":{"title":"适宜","desc":"适当减少运动时间并降低运动强度。"},"travel":{"title":"较不宜","desc":"天气很热，如外出可选择水上娱乐项目。"},"beauty":{"title":"去油","desc":"请选用露质面霜打底，水质无油粉底霜。"},"xq":{"title":"较差","desc":"天气热，容易烦躁"},"hc":{"title":"适宜","desc":"天气较好，适宜划船及嬉玩水上运动。"},"zs":{"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"},"cold":{"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"},"gj":{"title":"适宜","desc":"这种好天气去逛街可使身心畅快放松。"},"comfort":{"title":"较差","desc":"偏热或较热，部分人感觉不舒适"},"uv":{"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"},"cl":{"title":"适宜","desc":"适当减少运动时间并降低运动强度。"},"glass":{"title":"不需要","desc":"不需要佩戴"},"aqi":{"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"},"ac":{"title":"暂缺","desc":"暂缺"},"wash_car":{"title":"适宜","desc":"无雨且风力较小，易保持清洁度。"},"mf":{"title":"暂缺","desc":"暂缺"},"ag":{"title":"暂缺","desc":"暂缺"},"pj":{"title":"适宜","desc":"炎热干燥，适宜饮用冰镇啤酒，不要贪杯。"},"nl":{"title":"暂缺","desc":"暂缺"},"pk":{"title":"不宜","desc":"天气酷热，不适宜放风筝。"}}
             * air_press : 1008 hPa
             * jiangshui : 0%
             * night_wind_power : 微风 <5.4m/s
             * day_wind_power : 微风 <5.4m/s
             * day_weather_code : 00
             * 3hourForcast : [{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,2","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","temperature_min":"27","hour":"8时-14时","temperature":"30"},{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,1","weather":"晴","weather_pic":"http://app1.showapi.com/weather/icon/day/00.png","temperature_min":"29","hour":"14时-20时","temperature":"33"},{"wind_direction":"东南风","temperature_max":"33","wind_power":"微风,0","weather":"晴","weather_pic":"http://app1.showapi.com/weather/icon/night/00.png","temperature_min":"28","hour":"20时-2时","temperature":"29"},{"wind_direction":"西南风","temperature_max":"29","wind_power":"微风,0","weather":"多云","weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","temperature_min":"28","hour":"2时-8时","temperature":"28"}]
             * sun_begin_end : 05:27|18:23
             * ziwaixian : 很强
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/00.png
             * weekday : 1
             * night_air_temperature : 27
             * day_air_temperature : 33
             * day_wind_direction : 东南风
             * day : 20170828
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/01.png
             * night_wind_direction : 西南风
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBeanXXXXXX index;
            private String air_press;
            private String jiangshui;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String ziwaixian;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;
            @SerializedName("3hourForcast")
            private List<_$3hourForcastBeanXXXXXX> _$3hourForcast;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBeanXXXXXX getIndex() {
                return index;
            }

            public void setIndex(IndexBeanXXXXXX index) {
                this.index = index;
            }

            public String getAir_press() {
                return air_press;
            }

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public List<_$3hourForcastBeanXXXXXX> get_$3hourForcast() {
                return _$3hourForcast;
            }

            public void set_$3hourForcast(List<_$3hourForcastBeanXXXXXX> _$3hourForcast) {
                this._$3hourForcast = _$3hourForcast;
            }

            public static class IndexBeanXXXXXX {
                /**
                 * yh : {"title":"较适宜","desc":"不用担心天气来调皮捣乱而影响了兴致。 "}
                 * ls : {"title":"较适宜","desc":"天气不错，抓紧时机让衣物晒太阳吧。"}
                 * clothes : {"title":"热","desc":"适合穿T恤、短薄外套等夏季服装。"}
                 * dy : {"title":"适宜钓鱼","desc":"风和日丽，适宜钓鱼。"}
                 * sports : {"title":"适宜","desc":"适当减少运动时间并降低运动强度。"}
                 * travel : {"title":"较不宜","desc":"天气很热，如外出可选择水上娱乐项目。"}
                 * beauty : {"title":"去油","desc":"请选用露质面霜打底，水质无油粉底霜。"}
                 * xq : {"title":"较差","desc":"天气热，容易烦躁"}
                 * hc : {"title":"适宜","desc":"天气较好，适宜划船及嬉玩水上运动。"}
                 * zs : {"title":"可能中暑","desc":"气温较高，易中暑人群注意阴凉休息。"}
                 * cold : {"title":"少发","desc":"感冒机率较低，避免长期处于空调屋中。"}
                 * gj : {"title":"适宜","desc":"这种好天气去逛街可使身心畅快放松。"}
                 * comfort : {"title":"较差","desc":"偏热或较热，部分人感觉不舒适"}
                 * uv : {"title":"弱","desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。"}
                 * cl : {"title":"适宜","desc":"适当减少运动时间并降低运动强度。"}
                 * glass : {"title":"不需要","desc":"不需要佩戴"}
                 * aqi : {"title":"优质","desc":"空气很好，可以外出活动，呼吸新鲜空气"}
                 * ac : {"title":"暂缺","desc":"暂缺"}
                 * wash_car : {"title":"适宜","desc":"无雨且风力较小，易保持清洁度。"}
                 * mf : {"title":"暂缺","desc":"暂缺"}
                 * ag : {"title":"暂缺","desc":"暂缺"}
                 * pj : {"title":"适宜","desc":"炎热干燥，适宜饮用冰镇啤酒，不要贪杯。"}
                 * nl : {"title":"暂缺","desc":"暂缺"}
                 * pk : {"title":"不宜","desc":"天气酷热，不适宜放风筝。"}
                 */

                private YhBeanXXXXXX yh;
                private LsBeanXXXXXX ls;
                private ClothesBeanXXXXXX clothes;
                private DyBeanXXXXXX dy;
                private SportsBeanXXXXXX sports;
                private TravelBeanXXXXXX travel;
                private BeautyBeanXXXXXX beauty;
                private XqBeanXXXXXX xq;
                private HcBeanXXXXXX hc;
                private ZsBeanXXXXXX zs;
                private ColdBeanXXXXXX cold;
                private GjBeanXXXXXX gj;
                private ComfortBeanXXXXXX comfort;
                private UvBeanXXXXXX uv;
                private ClBeanXXXXXX cl;
                private GlassBeanXXXXXX glass;
                private AqiBeanXXXXXX aqi;
                private AcBeanXXXXXX ac;
                private WashCarBeanXXXXXX wash_car;
                private MfBeanXXXXXX mf;
                private AgBeanXXXXXX ag;
                private PjBeanXXXXXX pj;
                private NlBeanXXXXXX nl;
                private PkBeanXXXXXX pk;

                public YhBeanXXXXXX getYh() {
                    return yh;
                }

                public void setYh(YhBeanXXXXXX yh) {
                    this.yh = yh;
                }

                public LsBeanXXXXXX getLs() {
                    return ls;
                }

                public void setLs(LsBeanXXXXXX ls) {
                    this.ls = ls;
                }

                public ClothesBeanXXXXXX getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBeanXXXXXX clothes) {
                    this.clothes = clothes;
                }

                public DyBeanXXXXXX getDy() {
                    return dy;
                }

                public void setDy(DyBeanXXXXXX dy) {
                    this.dy = dy;
                }

                public SportsBeanXXXXXX getSports() {
                    return sports;
                }

                public void setSports(SportsBeanXXXXXX sports) {
                    this.sports = sports;
                }

                public TravelBeanXXXXXX getTravel() {
                    return travel;
                }

                public void setTravel(TravelBeanXXXXXX travel) {
                    this.travel = travel;
                }

                public BeautyBeanXXXXXX getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyBeanXXXXXX beauty) {
                    this.beauty = beauty;
                }

                public XqBeanXXXXXX getXq() {
                    return xq;
                }

                public void setXq(XqBeanXXXXXX xq) {
                    this.xq = xq;
                }

                public HcBeanXXXXXX getHc() {
                    return hc;
                }

                public void setHc(HcBeanXXXXXX hc) {
                    this.hc = hc;
                }

                public ZsBeanXXXXXX getZs() {
                    return zs;
                }

                public void setZs(ZsBeanXXXXXX zs) {
                    this.zs = zs;
                }

                public ColdBeanXXXXXX getCold() {
                    return cold;
                }

                public void setCold(ColdBeanXXXXXX cold) {
                    this.cold = cold;
                }

                public GjBeanXXXXXX getGj() {
                    return gj;
                }

                public void setGj(GjBeanXXXXXX gj) {
                    this.gj = gj;
                }

                public ComfortBeanXXXXXX getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBeanXXXXXX comfort) {
                    this.comfort = comfort;
                }

                public UvBeanXXXXXX getUv() {
                    return uv;
                }

                public void setUv(UvBeanXXXXXX uv) {
                    this.uv = uv;
                }

                public ClBeanXXXXXX getCl() {
                    return cl;
                }

                public void setCl(ClBeanXXXXXX cl) {
                    this.cl = cl;
                }

                public GlassBeanXXXXXX getGlass() {
                    return glass;
                }

                public void setGlass(GlassBeanXXXXXX glass) {
                    this.glass = glass;
                }

                public AqiBeanXXXXXX getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBeanXXXXXX aqi) {
                    this.aqi = aqi;
                }

                public AcBeanXXXXXX getAc() {
                    return ac;
                }

                public void setAc(AcBeanXXXXXX ac) {
                    this.ac = ac;
                }

                public WashCarBeanXXXXXX getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBeanXXXXXX wash_car) {
                    this.wash_car = wash_car;
                }

                public MfBeanXXXXXX getMf() {
                    return mf;
                }

                public void setMf(MfBeanXXXXXX mf) {
                    this.mf = mf;
                }

                public AgBeanXXXXXX getAg() {
                    return ag;
                }

                public void setAg(AgBeanXXXXXX ag) {
                    this.ag = ag;
                }

                public PjBeanXXXXXX getPj() {
                    return pj;
                }

                public void setPj(PjBeanXXXXXX pj) {
                    this.pj = pj;
                }

                public NlBeanXXXXXX getNl() {
                    return nl;
                }

                public void setNl(NlBeanXXXXXX nl) {
                    this.nl = nl;
                }

                public PkBeanXXXXXX getPk() {
                    return pk;
                }

                public void setPk(PkBeanXXXXXX pk) {
                    this.pk = pk;
                }

                public static class YhBeanXXXXXX {
                    /**
                     * title : 较适宜
                     * desc : 不用担心天气来调皮捣乱而影响了兴致。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class LsBeanXXXXXX {
                    /**
                     * title : 较适宜
                     * desc : 天气不错，抓紧时机让衣物晒太阳吧。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBeanXXXXXX {
                    /**
                     * title : 热
                     * desc : 适合穿T恤、短薄外套等夏季服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DyBeanXXXXXX {
                    /**
                     * title : 适宜钓鱼
                     * desc : 风和日丽，适宜钓鱼。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class SportsBeanXXXXXX {
                    /**
                     * title : 适宜
                     * desc : 适当减少运动时间并降低运动强度。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBeanXXXXXX {
                    /**
                     * title : 较不宜
                     * desc : 天气很热，如外出可选择水上娱乐项目。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class BeautyBeanXXXXXX {
                    /**
                     * title : 去油
                     * desc : 请选用露质面霜打底，水质无油粉底霜。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class XqBeanXXXXXX {
                    /**
                     * title : 较差
                     * desc : 天气热，容易烦躁
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class HcBeanXXXXXX {
                    /**
                     * title : 适宜
                     * desc : 天气较好，适宜划船及嬉玩水上运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ZsBeanXXXXXX {
                    /**
                     * title : 可能中暑
                     * desc : 气温较高，易中暑人群注意阴凉休息。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdBeanXXXXXX {
                    /**
                     * title : 少发
                     * desc : 感冒机率较低，避免长期处于空调屋中。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GjBeanXXXXXX {
                    /**
                     * title : 适宜
                     * desc : 这种好天气去逛街可使身心畅快放松。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBeanXXXXXX {
                    /**
                     * title : 较差
                     * desc : 偏热或较热，部分人感觉不舒适
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBeanXXXXXX {
                    /**
                     * title : 弱
                     * desc : 辐射较弱，涂擦SPF12-15、PA+护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClBeanXXXXXX {
                    /**
                     * title : 适宜
                     * desc : 适当减少运动时间并降低运动强度。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GlassBeanXXXXXX {
                    /**
                     * title : 不需要
                     * desc : 不需要佩戴
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBeanXXXXXX {
                    /**
                     * title : 优质
                     * desc : 空气很好，可以外出活动，呼吸新鲜空气
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AcBeanXXXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBeanXXXXXX {
                    /**
                     * title : 适宜
                     * desc : 无雨且风力较小，易保持清洁度。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class MfBeanXXXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AgBeanXXXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PjBeanXXXXXX {
                    /**
                     * title : 适宜
                     * desc : 炎热干燥，适宜饮用冰镇啤酒，不要贪杯。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class NlBeanXXXXXX {
                    /**
                     * title : 暂缺
                     * desc : 暂缺
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PkBeanXXXXXX {
                    /**
                     * title : 不宜
                     * desc : 天气酷热，不适宜放风筝。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class _$3hourForcastBeanXXXXXX {
                /**
                 * wind_direction : 东南风
                 * temperature_max : 33
                 * wind_power : 微风,2
                 * weather : 多云
                 * weather_pic : http://app1.showapi.com/weather/icon/day/01.png
                 * temperature_min : 27
                 * hour : 8时-14时
                 * temperature : 30
                 */

                private String wind_direction;
                private String temperature_max;
                private String wind_power;
                private String weather;
                private String weather_pic;
                private String temperature_min;
                private String hour;
                private String temperature;

                public String getWind_direction() {
                    return wind_direction;
                }

                public void setWind_direction(String wind_direction) {
                    this.wind_direction = wind_direction;
                }

                public String getTemperature_max() {
                    return temperature_max;
                }

                public void setTemperature_max(String temperature_max) {
                    this.temperature_max = temperature_max;
                }

                public String getWind_power() {
                    return wind_power;
                }

                public void setWind_power(String wind_power) {
                    this.wind_power = wind_power;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getWeather_pic() {
                    return weather_pic;
                }

                public void setWeather_pic(String weather_pic) {
                    this.weather_pic = weather_pic;
                }

                public String getTemperature_min() {
                    return temperature_min;
                }

                public void setTemperature_min(String temperature_min) {
                    this.temperature_min = temperature_min;
                }

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class AlarmListBean {
            /**
             * signalLevel : 黄色
             * issueContent : 上海中心气象台2017年08月25日01时45分发布雷电黄色预警[Ⅲ级/较重]：预计3小时内松江、青浦、金山等地将发生雷电活动，可能会造成雷电灾害事故，并伴有1小时20毫米左右的短时强降水。
             * issueTime : 2017-08-25 01:45:00
             * province : 上海市
             * signalType : 雷电
             * city :
             */

            private String signalLevel;
            private String issueContent;
            private String issueTime;
            private String province;
            private String signalType;
            private String city;

            public String getSignalLevel() {
                return signalLevel;
            }

            public void setSignalLevel(String signalLevel) {
                this.signalLevel = signalLevel;
            }

            public String getIssueContent() {
                return issueContent;
            }

            public void setIssueContent(String issueContent) {
                this.issueContent = issueContent;
            }

            public String getIssueTime() {
                return issueTime;
            }

            public void setIssueTime(String issueTime) {
                this.issueTime = issueTime;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getSignalType() {
                return signalType;
            }

            public void setSignalType(String signalType) {
                this.signalType = signalType;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }
        }
    }
}
