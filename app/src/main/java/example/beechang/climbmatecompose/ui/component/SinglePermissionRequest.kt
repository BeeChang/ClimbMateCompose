package example.beechang.climbmatecompose.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SinglePermissionRequest(
    permissionState: PermissionState,
    onGrant: () -> Unit = {},
    onShowRationalAlert: () -> Unit = {},
    onSelectedDisAgree: () -> Unit = {},
    onDisAgree: () -> Unit = {},
    permissionAlertData: PermissionAlertData = PermissionAlertData("", "", null, null)

) {
    var isSowExplainUsingPermissionAlert by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true){}
//    if (isSowExplainUsingPermissionAlert) {
//        Timber.e("SimpleAlertDialog")
//        SimpleAlertDialog(
//            titleText = permissionAlertData.title,
//            contentText = permissionAlertData.content,
//            onConfirm = {
//                permissionState.launchPermissionRequest()
//            },
//            onDismiss = {
//                onDisAgree()
//            },
//         )
//    }


    LaunchedEffect(permissionState.status) {
        when (val state = permissionState.status) {
            is PermissionStatus.Granted -> {
                onGrant()
            }

            is PermissionStatus.Denied -> {
                 if (state.shouldShowRationale) {
                    onShowRationalAlert()
                    isSowExplainUsingPermissionAlert = true
                } else {
                    permissionState.launchPermissionRequest()
                    onDisAgree()
                }
            }

            else -> {
            }
        }
    }
}

data class PermissionAlertData(
    val title: String = "",
    val content: String = "",
    val confirmButtonText: String?,
    val dismissButtonText: String?,
    val onConfirm: () -> Unit = {},
    val onDismiss: () -> Unit = {},
)
