package funnybrain.kaohsiungculturalheritage

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.common.util.ByteConstants
import com.facebook.cache.disk.DiskCacheConfig

class MyApplication() : Application() {


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