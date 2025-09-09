package ir.mhe47880.coffeeshopapp.model.local.ds

import android.content.Context
import kotlinx.coroutines.flow.first

suspend fun Context.isFirstLaunch(): Boolean {

    val pref = dataStore.data.first()

    return pref[Keys.IS_FIRST_LAUNCH] ?: true

}