package example.beechang.climbmatecompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import example.beechang.climbmatecompose.uilts.TimberCustom
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(TimberCustom())
        }
    }

}