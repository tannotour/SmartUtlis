package com.mitnick.tannotour.smartutlis.gaea.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaea_login_activity)
        val isFinish = intent.getBooleanExtra("isFinish", false)
        loginButton.setOnClickListener {
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
        }
    }

}