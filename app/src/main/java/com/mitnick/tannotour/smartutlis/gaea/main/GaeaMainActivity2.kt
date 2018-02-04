package com.mitnick.tannotour.smartutlis.gaea.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mitnick.tannotour.easylib.cache.CacheKey
import com.mitnick.tannotour.easylib.cache.value.CacheValueObserver
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.HttpHost
import com.mitnick.tannotour.smartutlis.gaea.coterie.GaeaCoterieFragment
import com.mitnick.tannotour.smartutlis.gaea.coterie.send.GaeaCoterieSendActivity
import com.mitnick.tannotour.smartutlis.gaea.dynamic.GaeaDynamicFragment
import com.mitnick.tannotour.smartutlis.gaea.dynamic.send.GaeaFieldDynamicSendActivity
import com.mitnick.tannotour.smartutlis.gaea.login.GaeaLoginActivity
import com.mitnick.tannotour.smartutlis.gaea.login.UserBean
import com.mitnick.tannotour.smartutlis.gaea.me.GaeaMeFragment
import com.mitnick.tannotour.smartutlis.gaea.tools.GlideCircleTransform
import kotlinx.android.synthetic.main.activity_gaea_main2.*
import kotlinx.android.synthetic.main.app_bar_gaea_main2.*
import org.jetbrains.anko.image

@CacheKey(keys = arrayOf(UserBean::class))
class GaeaMainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, CacheValueObserver {

    val fragments: ArrayList<Fragment> = ArrayList()
    var oldIndex = -1
    var isLogined = false

    override fun onNotify(key: Class<*>, newValue: Any) {
        when(key.name){
            UserBean::class.java.name -> {
                val user: UserBean = newValue as UserBean
                isLogined = user.isLogined
                if(isLogined){
                    Glide.with(this).load("${HttpHost.IMG_BASE_URL}${user.headerImg}").placeholder(R.mipmap.ic_launcher).transform(GlideCircleTransform(this)).into(nav_view.getHeaderView(0).findViewById<ImageView>(R.id.gaeaMain2UserHeaderImg))
                    nav_view.getHeaderView(0).findViewById<TextView>(R.id.gaeaMain2UserName).text = user.userName
                    nav_view.getHeaderView(0).findViewById<TextView>(R.id.gaeaMain2UserRecent).text = "当前积分：${user.integral}"
                    nav_view.getHeaderView(0).findViewById<ImageView>(R.id.gaeaMain2UserHeaderImg).setOnClickListener {
                        switchFragment(2)
                        drawer_layout.closeDrawer(GravityCompat.START)
                        gaeaMain2Fab.visibility = View.GONE
                    }
                }else{
                    nav_view.getHeaderView(0).findViewById<ImageView>(R.id.gaeaMain2UserHeaderImg).image = resources.getDrawable(R.mipmap.ic_launcher)
                    nav_view.getHeaderView(0).findViewById<TextView>(R.id.gaeaMain2UserName).text = "游客"
                    nav_view.getHeaderView(0).findViewById<TextView>(R.id.gaeaMain2UserRecent).text = ""
                    nav_view.getHeaderView(0).findViewById<ImageView>(R.id.gaeaMain2UserHeaderImg).setOnClickListener {
                        val intent = Intent(this, GaeaLoginActivity::class.java)
                        intent.putExtra("isFinish", true)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaea_main2)
        nav_view.setNavigationItemSelectedListener(this)
        fragments.add(GaeaDynamicFragment())
        fragments.add(GaeaCoterieFragment())
        fragments.add(GaeaMeFragment())
        switchFragment(0)
        gaeaMain2Fab.setOnClickListener { view ->
            if(isLogined){
                when(oldIndex){
                    0 -> {
                        startActivity(Intent(this, GaeaFieldDynamicSendActivity::class.java))
                    }
                    1 -> {
                        startActivity(Intent(this, GaeaCoterieSendActivity::class.java))
                    }
                }
            }else{
                Snackbar.make(view, "还未登录，登录后可体验更多功能。", Snackbar.LENGTH_LONG)
                        .setAction(
                                "去登录",
                                {
                                    val intent = Intent(this, GaeaLoginActivity::class.java)
                                    intent.putExtra("isFinish", true)
                                    startActivity(intent)
                                }
                        ).show()
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {
                switchFragment(0)
                gaeaMain2Fab.visibility = View.VISIBLE
            }
            R.id.nav_manage -> {
                switchFragment(1)
                gaeaMain2Fab.visibility = View.VISIBLE
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun switchFragment(to: Int) {
        if(to == oldIndex){
            return
        }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        if(oldIndex == -1){
            transaction.add(R.id.gaeaMain2Content, fragments[to]).commit()
        }else if (!fragments[to].isAdded) {
            // 隐藏当前的fragment，add下一个到Activity中
            transaction.hide(fragments[oldIndex]).add(R.id.gaeaMain2Content, fragments[to]).commit()
        } else {
            // 隐藏当前的fragment，显示下一个
            transaction.hide(fragments[oldIndex]).show(fragments[to]).commit()
        }
        oldIndex = to
    }
}
