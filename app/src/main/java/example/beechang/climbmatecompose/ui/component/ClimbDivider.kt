package example.beechang.climbmatecompose.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import example.beechang.climbmatecompose.ui.theme.ClimbMateComposeTheme

@Composable
fun ClimbDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    thickness: Dp = 0.5.dp,
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness,
    )
}

@Preview("default", showBackground = true)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun DividerPreview() {
    ClimbMateComposeTheme {
        Box(Modifier.size(height = 10.dp, width = 100.dp)) {
            ClimbDivider(Modifier.align(Alignment.Center))
        }
    }
}