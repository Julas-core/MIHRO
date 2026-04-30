package com.mihro.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = MihroGreen,
    onPrimary = MihroCream,
    primaryContainer = MihroSand,
    onPrimaryContainer = MihroInk,
    secondary = MihroGold,
    onSecondary = MihroInk,
    tertiary = MihroRed,
    onTertiary = MihroCream,
    background = MihroCream,
    onBackground = MihroInk,
    surface = MihroSurface,
    onSurface = MihroInk,
    outline = MihroMuted
)

private val DarkColors = darkColorScheme(
    primary = MihroGold,
    onPrimary = MihroInk,
    primaryContainer = MihroGreenDark,
    onPrimaryContainer = MihroCream,
    secondary = MihroGreen,
    onSecondary = MihroCream,
    tertiary = MihroRed,
    onTertiary = MihroCream,
    background = ColorTokens.darkBackground,
    onBackground = MihroCream,
    surface = ColorTokens.darkSurface,
    onSurface = MihroCream,
    outline = ColorTokens.darkOutline
)

private object ColorTokens {
    val darkBackground = androidx.compose.ui.graphics.Color(0xFF111714)
    val darkSurface = androidx.compose.ui.graphics.Color(0xFF1A241F)
    val darkOutline = androidx.compose.ui.graphics.Color(0xFF8DAA9D)
}

@Composable
fun MihroTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MihroTypography,
        content = content
    )
}
