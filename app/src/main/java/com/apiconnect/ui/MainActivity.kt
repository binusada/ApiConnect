package com.apiconnect.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.apiconnect.RandomUserApplication
import com.apiconnect.ui.screen.UserProfileListScreen
import com.apiconnect.ui.theme.RandomUserTheme
import com.apiconnect.viewmodel.UserProfileViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = (application as RandomUserApplication).appContainer
        val factory = UserProfileViewModel.Factory(appContainer.getUserProfilesUseCase)
        viewModel = ViewModelProvider(this, factory)[UserProfileViewModel::class.java]

        setContent {
            RandomUserTheme {
                UserProfileListScreen(viewModel = viewModel)
            }
        }
    }
}
