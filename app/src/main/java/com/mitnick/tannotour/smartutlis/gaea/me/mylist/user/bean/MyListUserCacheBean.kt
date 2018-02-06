package com.mitnick.tannotour.smartutlis.gaea.me.mylist.user.bean

import com.mitnick.tannotour.easylib.cache.CacheBean
import com.mitnick.tannotour.easylib.cache.CacheList
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean

/**
 * Created by mitnick on 2018/2/6.
 * Description
 */
@CacheBean(isList = true, secondKeys = arrayOf("关注", "粉丝", "个人排名", "城市安全系数排名"), ramOnly = true)
class MyListUserCacheBean: CacheList<MyListUserBean>()
