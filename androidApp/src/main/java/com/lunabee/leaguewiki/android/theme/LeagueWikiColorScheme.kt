package com.lunabee.leaguewiki.android.theme

import androidx.compose.ui.graphics.Color

interface LeagueWikiColorScheme {
    val background: Color
    val backgroundSecondary: Color
    val primary: Color
    val secondary: Color
    val contentPrimary: Color
    val contentSecondary: Color
    val contentOnPrimary: Color
}

object LWLightColorScheme : LeagueWikiColorScheme {
    override val background: Color = Color.White
    override val backgroundSecondary: Color = Color(0x0D002447)
    override val primary: Color = Color(0xFF061F29)
    override val secondary: Color = Color(0xFFC28F2C)
    override val contentPrimary: Color = Color(0xFF11181C)
    override val contentSecondary: Color = Color(0xFF687076)
    override val contentOnPrimary: Color = Color.White
}

object LWDarkColorScheme : LeagueWikiColorScheme {
    override val background: Color = Color.Black
    override val backgroundSecondary: Color = Color(0x0EFFFFFF)
    override val primary: Color = Color(0xFF0E3A4C)
    override val secondary: Color = Color(0xFFC28F2C)
    override val contentPrimary: Color = Color(0xFFEDEDED)
    override val contentSecondary: Color = Color(0xFFA0A0A0)
    override val contentOnPrimary: Color = Color.White
}