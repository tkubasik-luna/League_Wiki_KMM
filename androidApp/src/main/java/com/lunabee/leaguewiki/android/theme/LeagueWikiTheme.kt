package com.lunabee.leaguewiki.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

val LocalLWColor: ProvidableCompositionLocal<LeagueWikiColorScheme> = staticCompositionLocalOf { error("no provided") }
val LocalLWTypo: ProvidableCompositionLocal<LeagueWikiTypography> = staticCompositionLocalOf { error("no provided") }
val LocalLWSpacing: ProvidableCompositionLocal<LeagueWikiSpacing> = staticCompositionLocalOf { error("no provided") }
val LocalLWRadius: ProvidableCompositionLocal<LeagueWikiRadius> = staticCompositionLocalOf { error("no provided") }

@Composable
fun LeagueWikiTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val localColorScheme = if (isDarkTheme) LWDarkColorScheme else LWLightColorScheme
    CompositionLocalProvider(
        LocalLWColor provides localColorScheme,
        LocalLWTypo provides LeagueWikiTypography,
        LocalLWSpacing provides LeagueWikiSpacing,
        LocalLWRadius provides LeagueWikiRadius,
    ) {
        content()
    }
}

object LeagueWikiTheme {
    val colors: LeagueWikiColorScheme
        @Composable
        get() = LocalLWColor.current

    val typography: LeagueWikiTypography
        @Composable
        get() = LocalLWTypo.current

    val spacing: LeagueWikiSpacing
        @Composable
        get() = LocalLWSpacing.current

    val radius: LeagueWikiRadius
        @Composable
        get() = LocalLWRadius.current
}