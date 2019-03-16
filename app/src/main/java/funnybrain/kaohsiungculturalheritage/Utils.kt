package funnybrain.kaohsiungculturalheritage

import android.app.Activity
import android.util.DisplayMetrics

object Utils {

//    fun getWindowScreen(context: Context): Point {
//        val point = Point()
//        context.windowManager.defaultDisplay.getSize(point)
//        return point
//    }

    fun getWindowSize(activity: Activity) : DisplayMetrics {
        var result = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(result)
        return result
    }

}