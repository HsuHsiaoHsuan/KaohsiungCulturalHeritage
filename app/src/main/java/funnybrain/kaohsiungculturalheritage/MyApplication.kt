package funnybrain.kaohsiungculturalheritage

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.facebook.cache.disk.DiskCacheConfig
import com.facebook.common.util.ByteConstants
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.Logger.addLogAdapter



class MyApplication() : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        val diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryPathSupplier { applicationContext.cacheDir }
                .setBaseDirectoryName("image_cache")
                .setMaxCacheSize((20 * ByteConstants.MB).toLong())
                .setMaxCacheSizeOnLowDiskSpace((10 * ByteConstants.MB).toLong())
                .setMaxCacheSizeOnVeryLowDiskSpace((2 * ByteConstants.MB).toLong()).build()

        val frescoConfig = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build()

        Fresco.initialize(this, frescoConfig)

        Logger.addLogAdapter(AndroidLogAdapter())
    }

    override fun onLowMemory() {
        super.onLowMemory()
        clearFresco()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        clearFresco()
    }

    override fun onTerminate() {
        super.onTerminate()
        clearFresco()
    }

    private fun clearFresco() {
        val pipeline = Fresco.getImagePipeline()
        pipeline.clearCaches()
    }
}