package com.lunabee.leaguewiki.android

import android.app.Application
import com.lunabee.leaguewiki.domainModule
import com.lunabee.leaguewiki.localeModule
import com.lunabee.leaguewiki.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LeagueWikiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LeagueWikiApp)
            modules(remoteModule, localeModule, domainModule, viewModelModule)
        }
    }
}