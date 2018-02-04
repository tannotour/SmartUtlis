package com.mitnick.tannotour.smartutlis.gaea.tools

import android.view.View
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog

/**
 * Created by mitnick on 2018/2/4.
 * Description
 */
object TipDialog {

    fun showTip(
            view: View,
            type: Int,
            tip: String,
            delayMillis: Long = 1500,
            autoDismiss: Boolean = true
    ): QMUITipDialog{
        val tipDialog = QMUITipDialog.Builder(view.context)
                .setIconType(type)
                .setTipWord(tip)
                .create()
        tipDialog.show()
        if(autoDismiss){
            view.postDelayed(
                    {
                        tipDialog.dismiss()
                    }, delayMillis
            )
        }
        return tipDialog
    }
}