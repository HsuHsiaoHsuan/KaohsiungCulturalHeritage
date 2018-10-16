package funnybrain.kaohsiungculturalheritage

import android.content.Context
import android.graphics.Point
import org.jetbrains.anko.windowManager

object Utils {

    fun getWindowScreen(context: Context): Point {
        val point = Point()
        context.windowManager.defaultDisplay.getSize(point)
        return point
    }
}