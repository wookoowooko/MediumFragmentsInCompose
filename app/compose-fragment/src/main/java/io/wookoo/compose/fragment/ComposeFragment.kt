package io.wookoo.compose.fragment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ComposeFragmentRoute

fun NavGraphBuilder.composeFragment(
    onClick: (arg: String) -> Unit,
) {
    composable<ComposeFragmentRoute> {
        ComposeFragment(
            onClick = onClick
        )
    }
}

@Composable
fun ComposeFragment(
    onClick: (arg: String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Compose Fragment")
        Button(onClick = {
            onClick("I'm Parameter from Compose Fragment")
        }) {
            Text(text = "Navigate To XML Fragment")
        }
    }
}