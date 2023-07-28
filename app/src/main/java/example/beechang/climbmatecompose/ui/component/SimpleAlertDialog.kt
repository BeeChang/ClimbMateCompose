package example.beechang.climbmatecompose.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimpleAlertDialog(
    onConfirm: () -> Unit = {},
    onDismiss: () -> Unit = {},
    titleText: String = "",
    contentText: String = "",
    confirmButtonText: String = "OK",
    dismissButtonText: String = "Cancel",
    showDialog: MutableState<Boolean> = rememberSaveable { mutableStateOf(true) },
) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            title = {
                Text(text = titleText)
            },
            text = {
                Text(contentText)
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm()
                        showDialog.value = false
                    }) {
                    Text(confirmButtonText)
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        onDismiss()
                        showDialog.value = false
                    }) {
                    Text(dismissButtonText)
                }
            }
        )
    }
}


@Preview(showBackground = true, name = "Light Mode")
@Composable
fun SimpleAlertDialogLightPreview() {
    MaterialTheme {
        SimpleAlertDialog(
            titleText = "Light Mode",
            contentText = "This is a simple alert dialog in light mode."
        )
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun SimpleAlertDialogDarkPreview() {
    MaterialTheme {
        SimpleAlertDialog(
            titleText = "Dark Mode",
            contentText = "This is a simple alert dialog in dark mode."
        )
    }
}