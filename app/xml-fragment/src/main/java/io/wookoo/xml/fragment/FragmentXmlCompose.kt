package io.wookoo.xml.fragment

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.os.bundleOf
import androidx.fragment.compose.AndroidFragment
import androidx.fragment.compose.rememberFragmentState
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import io.wookoo.xml.fragment.FragmentXml.Companion.ARG
import kotlinx.serialization.Serializable

@Serializable
data class FragmentXmlComposeRoute(
    val arg: String,
)

fun NavGraphBuilder.fragmentXmlCompose(
    onClick: () -> Unit,
) {
    composable<FragmentXmlComposeRoute> {
        FragmentXmlCompose(
            onClick = onClick,
            navBackStackEntry = it,
        )
    }
}

fun NavHostController.navigateFragmentXmlCompose(
    arg: String,
) {
    navigate(FragmentXmlComposeRoute(arg))
}

@Composable
fun FragmentXmlCompose(
    onClick: () -> Unit,
    navBackStackEntry: NavBackStackEntry,
) {
    val state = rememberFragmentState()
    val args = navBackStackEntry.toRoute<FragmentXmlComposeRoute>()

    AndroidFragment<FragmentXml>(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        fragmentState = state,
        arguments = bundleOf(ARG to args.arg)
    ) { fragment ->
        fragment.setOnBackIconClickListener(onClick)
    }
}
