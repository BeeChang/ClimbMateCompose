package example.beechang.climbmatecompose.uilts

import android.util.Log
import timber.log.Timber

class TimberCustom : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "${element.fileName} : line(${element.lineNumber}) # ${element.methodName} "
    }
}
