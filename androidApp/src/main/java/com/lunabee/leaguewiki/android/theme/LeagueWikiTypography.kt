package com.lunabee.leaguewiki.android.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.lunabee.leaguewiki.android.R

@Suppress("deprecation")
object IGCompat {
    fun getPlatformStyleCompat(): PlatformTextStyle {
        return PlatformTextStyle(
            includeFontPadding = false,
        )
    }
}

val FrizQuadrata: FontFamily = FontFamily(
    Font(R.font.friz_quadrata_regular, FontWeight.Light),
    Font(R.font.friz_quadrata_regular, FontWeight.Normal),
    Font(R.font.friz_quadrata_std_medium, FontWeight.Medium),
    Font(R.font.friz_quadrata_bold, FontWeight.SemiBold),
    Font(R.font.friz_quadrata_bold, FontWeight.Bold),
)

object LeagueWikiTypography {
    val text5Xl: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 48.sp,
        lineHeight = 64.sp,
        fontWeight = FontWeight.W700,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val text4Xl: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 36.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.W700,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val text3Xl: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 30.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.W700,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val text2Xl: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.W700,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textXl: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.W700,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textXlMedium: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.W500,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textLarge: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.W400,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textLargeBold: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.W700,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textBase: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.W400,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textBaseLink: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.W400,
        textDecoration = TextDecoration.Underline,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textBaseMedium: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.W500,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textBaseSemiBold: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.W600,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textSmall: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W400,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textSmallMedium: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W500,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )

    val textXs: TextStyle = TextStyle(
        fontFamily = FrizQuadrata,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W400,
        platformStyle = IGCompat.getPlatformStyleCompat(),
    )
}
