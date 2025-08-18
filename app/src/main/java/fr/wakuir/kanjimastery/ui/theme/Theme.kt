package fr.wakuir.kanjimastery.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    background = pure_white,

    primary = light_theme_primary,
    onPrimary = light_theme_on_primary,
    secondary = light_theme_secondary,
    onSecondary = light_theme_on_secondary,
    tertiary = light_theme_tertiary,
    onTertiary = light_theme_on_tertiary,
    primaryContainer = light_theme_primary_container,
    onPrimaryContainer = light_theme_on_primary_container,
    secondaryContainer = light_theme_secondary_container,
    onSecondaryContainer = light_theme_on_secondary_container,
    tertiaryContainer = light_theme_tertiary_container,
    onTertiaryContainer = light_theme_on_tertiary_container,
    error = light_theme_error,
    onError = light_theme_on_error,
    errorContainer = light_theme_error_container,
    onErrorContainer = light_theme_on_error_container,
    surface = light_theme_surface,
    surfaceDim = light_theme_surface_dim,
    surfaceBright = light_theme_surface_bright,
    onSurface = light_theme_on_surface,
    onSurfaceVariant = light_theme_on_surface_variant,
    outline = light_theme_outline,
    outlineVariant = light_theme_outline_variant,
    surfaceContainerLowest = light_theme_surface_container_lowest,
    surfaceContainerLow = light_theme_surface_container_low,
    surfaceContainer = light_theme_surface_container,
    surfaceContainerHigh = light_theme_surface_container_high,
    surfaceContainerHighest = light_theme_surface_container_highest,
    inversePrimary = light_theme_inverse_primary,
    inverseSurface = light_theme_inverse_surface,
    inverseOnSurface = light_theme_inverse_on_surface,
    scrim = light_theme_scrim,

)

private val DarkColorScheme = darkColorScheme(
    background = pure_black,

    primary = dark_theme_primary,
    onPrimary = dark_theme_on_primary,
    secondary = dark_theme_secondary,
    onSecondary = dark_theme_on_secondary,
    tertiary = dark_theme_tertiary,
    onTertiary = dark_theme_on_tertiary,
    primaryContainer = dark_theme_primary_container,
    onPrimaryContainer = dark_theme_on_primary_container,
    secondaryContainer = dark_theme_secondary_container,
    onSecondaryContainer = dark_theme_on_secondary_container,
    tertiaryContainer = dark_theme_tertiary_container,
    onTertiaryContainer = dark_theme_on_tertiary_container,
    error = dark_theme_error,
    onError = dark_theme_on_error,
    errorContainer = dark_theme_error_container,
    onErrorContainer = dark_theme_on_error_container,
    surface = dark_theme_surface,
    surfaceDim = dark_theme_surface_dim,
    surfaceBright = dark_theme_surface_bright,
    onSurface = dark_theme_on_surface,
    onSurfaceVariant = dark_theme_on_surface_variant,
    outline = dark_theme_outline,
    outlineVariant = dark_theme_outline_variant,
    surfaceContainerLowest = dark_theme_surface_container_lowest,
    surfaceContainerLow = dark_theme_surface_container_low,
    surfaceContainer = dark_theme_surface_container,
    surfaceContainerHigh = dark_theme_surface_container_high,
    surfaceContainerHighest = dark_theme_surface_container_highest,
    inversePrimary = dark_theme_inverse_primary,
    inverseSurface = dark_theme_inverse_surface,
    inverseOnSurface = dark_theme_inverse_on_surface,
    scrim = dark_theme_scrim,
)

@Composable
fun KanjiMasteryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}