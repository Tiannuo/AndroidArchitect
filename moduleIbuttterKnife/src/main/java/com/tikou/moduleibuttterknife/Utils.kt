package com.tikou.moduleibuttterknife

import android.app.Activity
import android.view.View

/**

 * @Author Administrator
 * @Date 2022/6/16-10:22
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
class Utils {
    companion object {
        fun <T : View> findViewById(activity: Activity, viewId: Int): T {
            return activity.findViewById(viewId)
        }
    }
}