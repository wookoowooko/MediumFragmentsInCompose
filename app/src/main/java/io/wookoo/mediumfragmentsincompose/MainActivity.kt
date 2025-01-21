package io.wookoo.mediumfragmentsincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.wookoo.compose.fragment.ComposeFragmentRoute
import io.wookoo.compose.fragment.composeFragment
import io.wookoo.mediumfragmentsincompose.ui.theme.MediumFragmentsInComposeTheme
import io.wookoo.xml.fragment.fragmentXmlCompose
import io.wookoo.xml.fragment.navigateFragmentXmlCompose

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MediumFragmentsInComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val controller = rememberNavController()

                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = controller,
                        startDestination = ComposeFragmentRoute
                    ) {
                        composeFragment(
                            onClick = { arg ->
                                controller.navigateFragmentXmlCompose(arg)
                            }
                        )
                        fragmentXmlCompose(
                            onClick = { controller.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}