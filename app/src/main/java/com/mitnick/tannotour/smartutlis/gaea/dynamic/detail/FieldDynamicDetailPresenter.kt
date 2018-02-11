package com.mitnick.tannotour.smartutlis.gaea.dynamic.detail

import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.easylib.cache.Cache
import com.mitnick.tannotour.easylib.net.INet
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicBean
import com.mitnick.tannotour.smartutlis.gaea.dynamic.bean.FieldDynamicCacheBean
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import java.util.*

/**
 * Created by mitnick on 2018/1/31.
 * Description
 */
class FieldDynamicDetailPresenter: INet {

//    "90704b00-1853-11e7-9fee-3dc67b13fe13"

    val userCache: UserBean = Cache.get(UserBean::class.java).clone() as UserBean

    fun thumbUp(type: String, eventId: String): STATE{
        var state: STATE = STATE.FAILED
        val result = get<ThumbNetBean> {
            url = "${HttpHost.API_URL}liveevent/v1/thumbUp"
            params.put("userId", userCache.uuid)
            params.put("eventId", eventId)
        }.convert(ThumbNetBean::class.java){
            true
        }?.body?.ok
        if(result != null && result){
            state = STATE.SUCCESS
            Cache.use(FieldDynamicCacheBean::class.java, type){
                findByCondition {
                    this.id == eventId
                }.forEach {
                    val user = FieldDynamicBean.UserBean()
//                    user.headerImg = "/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg"
//                    user.userName = "tannotour"
//                    user.userId = "90704b00-1853-11e7-9fee-3dc67b13fe13"
                    user.headerImg = userCache.headerImg
                    user.userName = userCache.userName
                    user.userId = userCache.uuid
                    val thumb = FieldDynamicBean.ThumbsBean()
                    thumb.eventId = eventId
                    thumb.type = "0"
                    thumb.user = user
                    val cache = this[it]
                    cache.thumbs.add(thumb)
                    this.set(it, cache)
                }
            }
        }
        return state
    }

    fun thumbDown(type: String, eventId: String): STATE{
        var state: STATE = STATE.FAILED
        val result = get<ThumbNetBean> {
            url = "${HttpHost.API_URL}liveevent/v1/thumbDown"
            params.put("userId", userCache.uuid)
            params.put("eventId", eventId)
        }.convert(ThumbNetBean::class.java){
            true
        }?.body?.ok
        if(result != null && result){
            state = STATE.SUCCESS
            Cache.use(FieldDynamicCacheBean::class.java, type){
                findByCondition {
                    this.id == eventId
                }.forEach {
                    val user = FieldDynamicBean.UserBean()
//                    user.headerImg = "/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg"
//                    user.userName = "tannotour"
//                    user.userId = "90704b00-1853-11e7-9fee-3dc67b13fe13"
                    user.headerImg = userCache.headerImg
                    user.userName = userCache.userName
                    user.userId = userCache.uuid
                    val thumb = FieldDynamicBean.ThumbsBean()
                    thumb.eventId = eventId
                    thumb.type = "1"
                    thumb.user = user
                    val cache = this[it]
                    cache.thumbs.add(thumb)
                    this.set(it, cache)
                }
            }
        }
        return state
    }

    fun comment(type: String, eventId: String, message: String): STATE{
        var state: STATE = STATE.FAILED
        val result = post<CommentNetBean> {
            url = "${HttpHost.API_URL}liveevent/v1/comment"
            params.put("userId", userCache.uuid)
            data.put("eventId", eventId)
            data.put("message", message)
        }.convert(CommentNetBean::class.java){
            true
        }?.body
        if(result != null && result.ok){
            state = STATE.SUCCESS
            Cache.use(FieldDynamicCacheBean::class.java, type){
                findByCondition {
                    this.id == eventId
                }.forEach {
                    val comment = result.data
                    val cache = this[it]
                    cache.comments.add(comment)
                    this.set(it, cache)
                }
            }
        }
        return state
    }

    fun report(type: String, eventId: String, content: String): STATE{
        var state: STATE = STATE.FAILED
        val result = get<ThumbNetBean> {
            url = "${HttpHost.API_URL}v1/user/tipOff/live"
            params.put("userId", userCache.uuid)
            params.put("liveId", eventId)
            params.put("content", content)
            params.put("date", Date().time.toString())
        }.convert(ThumbNetBean::class.java){
            true
        }?.body?.ok
        if(result != null && result){
            state = STATE.SUCCESS
        }
        return state
    }

    class ThumbNetBean{
        var code: String = ""
        var desc: String = ""
        var data: String = ""
        val ok: Boolean = false
    }

    class CommentNetBean{
        var code: String = ""
        var desc: String = ""
        var data: FieldDynamicBean.CommentsBean? = null
        val ok: Boolean = false
    }
}