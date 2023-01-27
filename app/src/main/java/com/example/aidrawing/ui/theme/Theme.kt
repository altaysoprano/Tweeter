package com.example.aidrawing.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkThemeColors = darkColors(
    primary = Color(0xFF212121), // Siyah
    primaryVariant = Color(0xFF616161), // Gri
    onPrimary = Color(0xFFFFFFFF), // Beyaz
    secondary = Color(0xFF9E9E9E), // Gri
    onSecondary = Color(0xFF000000), // Siyah
    error = Color(0xFFFF0000), // Kırmızı
    background = Color(0xFF000000), // Siyah
    onBackground = Color(0xFFFFFFFF), // Beyaz
    surface = Color(0xFF616161), // Gri
    onSurface = Color(0xFFFFFFFF), // Beyaz
)

private val LightThemeColors = lightColors(
    primary = Color(0xFF000000), // Beyaz
    primaryVariant = Color(0xFFE0E0E0), // Gri
    onPrimary = Color(0xFFE0E0E0), // Siyah
    secondary = Color(0xFFE0E0E0), // Gri
    secondaryVariant = Color(0xFFFFFFFF), // Beyaz
    onSecondary = Color(0xFF000000), // Siyah
    error = Color(0xFFFF0000), // Kırmızı
    background = Color(0xFFFFFFFF), // Beyaz
    onBackground = Color(0xFF000000), // Siyah
    surface = Color(0xFFE0E0E0), // Gri
)

@Composable
fun MyAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkThemeColors
    } else {
        LightThemeColors
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
