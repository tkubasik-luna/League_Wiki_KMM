package com.lunabee.leaguewiki

object SharedConstants {
    object Url {
        const val BASE_URL: String = "https://ddragon.leagueoflegends.com/"
        const val IMAGE_SPLASH_URL: String = "cdn/img/champion/splash/%s_%d.jpg"
        const val IMAGE_CHAMP_URL: String = "cdn/%s/img/champion/%s.png"
        const val IMAGE_SPELL_URL: String = "cdn/%s/img/spell/%s"
        const val IMAGE_PASSIVE_URL: String = "cdn/%s/img/passive/%s"
        const val VIDEO_URL_PASSIVE: String = "https://d28xe8vt774jo5.cloudfront.net/champion-abilities/%s/ability_%s_%s1.webm"
    }

    object HomeDimens {
        const val ChampionImageSize: Int = 72
    }

    object DetailDimens {
        const val SpellImageSize: Int = 40
        const val SkinImageAspectRatio: Float = 16f / 9f
    }
}