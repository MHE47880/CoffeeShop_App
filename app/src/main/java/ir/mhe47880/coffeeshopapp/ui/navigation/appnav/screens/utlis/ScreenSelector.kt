package ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens.utlis

import android.content.Context
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.mhe47880.coffeeshopapp.model.local.ds.Keys
import ir.mhe47880.coffeeshopapp.model.local.ds.dataStore
import ir.mhe47880.coffeeshopapp.model.local.ds.isFirstLaunch
import ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens.Screens

suspend fun screenSelector(
    @ApplicationContext context: Context
): Screens {

    return if (context.isFirstLaunch()) {
        context.dataStore.edit { preferences ->
            preferences[Keys.IS_FIRST_LAUNCH] = false
        }
        Screens.WelcomeScreen
    } else
        Screens.MainScreen

}
