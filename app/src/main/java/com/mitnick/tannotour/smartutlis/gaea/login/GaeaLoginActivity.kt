package com.mitnick.tannotour.smartutlis.gaea.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.mitnick.tannotour.easylib.async.STATE
import com.mitnick.tannotour.smartutlis.R
import com.mitnick.tannotour.smartutlis.gaea.main.GaeaMainActivity2
import kotlinx.android.synthetic.main.gaea_login_activity.*
import org.jetbrains.anko.toast

/**
 * Created by mitnick on 2018/2/2.
 * Description
 */
class GaeaLoginActivity: AppCompatActivity(), GaeaUserFuncs {

    private var isLogin = true
    private var time = 60

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_login_activity)
        val isFinish = intent.getBooleanExtra("isFinish", false)
        loginButton.setOnClickListener {
            if(isLogin){
                login(
                        phone = loginPhone.text.toString(),
                        password = loginPassword.text.toString()
                ){
                    when(it){
                        STATE.SUCCESS -> {
                            if(!isFinish){
                                startActivity(Intent(this, GaeaMainActivity2::class.java))
                            }
                            finish()
                        }
                        else -> {
                            toast("登录失败")
                        }
                    }
                }
            }else{
                register(
                        phone = loginPhone.text.toString(),
                        password = loginPassword.text.toString(),
                        captcha = loginCode.text.toString()
                ){
                    when(it){
                        STATE.SUCCESS -> {
                            toast("注册成功，请使用新账号登录")
                            loginCode.visibility = View.GONE
                            loginPhone.text.clear()
                            loginPassword.text.clear()
                            loginButtonText.text = "登录"
                            toRegister.text = "注册"
                            isLogin = true
                        }
                        else -> {
                            toast("注册失败")
                        }
                    }
                }
            }
        }
        toRegister.setOnClickListener {
            if(isLogin){
                /* 跳转至注册 */
                loginCodeRoot.visibility = View.VISIBLE
                loginButtonText.text = "注册"
                toRegister.text = "登录"
                isLogin = false
            }else{
                loginCodeRoot.visibility = View.GONE
                loginPhone.text.clear()
                loginPassword.text.clear()
                loginButtonText.text = "登录"
                toRegister.text = "注册"
                isLogin = true
            }
        }
        loginGetCode.setOnClickListener {
            if(time == 60){
                getCaptcha(phone = loginPhone.text.toString()){
                    when(it){
                        STATE.SUCCESS -> {
                            loginGetCode.text = "${time}秒后重新获取"
                            loginGetCode.postDelayed(handler, 1000)
                        }
                        STATE.FAILED -> {
                            toast("获取短信验证码失败，请稍后再试")
                        }
                    }
                }
            }
        }
    }

    val handler = object : Runnable{
        override fun run() {
            loginGetCode.text = "${time}秒后重新获取"
            time -= 1
            if(time <= 0){
                time = 60
            }else{
                loginGetCode.postDelayed(this, 1000)
            }
        }
    }
}