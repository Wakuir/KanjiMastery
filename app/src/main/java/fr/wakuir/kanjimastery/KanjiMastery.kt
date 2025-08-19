package fr.wakuir.kanjimastery

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.wakuir.kanjimastery.ui.HomeScreen
import fr.wakuir.kanjimastery.ui.LearnScreen
import fr.wakuir.kanjimastery.ui.LibraryScreen
import fr.wakuir.kanjimastery.ui.PracticeScreen
import fr.wakuir.kanjimastery.ui.RadicalsScreen
import fr.wakuir.kanjimastery.ui.theme.KanjiMasteryTheme

enum class Destination(
    @StringRes val prompt: Int?,
    @DrawableRes val defaultIcon: Int,
    @DrawableRes val selectedIcon: Int,
) {
    Home(null, R.drawable.home_icon, R.drawable.home_icon_selected),
    Learn(
        R.string.destination_learn_prompt,
        R.drawable.learn_kanji_icon,
        R.drawable.learn_kanji_icon_selected
    ),
    Lab(
        R.string.destination_practice_prompt,
        R.drawable.practice_icon,
        R.drawable.practice_icon_selected
    ),
    Radicals(
        R.string.destination_radicals_prompt,
        R.drawable.learn_radicals_icon,
        R.drawable.learn_radicals_icon_selected
    ),
    Library(
        R.string.destination_library_prompt,
        R.drawable.library_icon,
        R.drawable.library_icon_selected
    )
}

@Composable
fun KanjiMastery(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            NavBar(navController = navController)
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destination.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Destination.Home.name) {
                HomeScreen()
            }

            composable(route = Destination.Learn.name) {
                LearnScreen()
            }

            composable(route = Destination.Lab.name) {
                PracticeScreen()
            }

            composable(route = Destination.Radicals.name) {
                RadicalsScreen()
            }

            composable(route = Destination.Library.name) {
                LibraryScreen()
            }
        }
    }
}

@Composable
fun NavBar(
    navController: NavHostController
) {
    var currentScreen by remember { mutableStateOf(Destination.entries[0]) }

    NavigationBar {
        Destination.entries.forEachIndexed { index, destination ->
            val itemDestination = Destination.entries[index]
            val selected = itemDestination == currentScreen
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(if (selected) destination.selectedIcon else destination.defaultIcon),
                        contentDescription = destination.name,
                        modifier = Modifier.size(dimensionResource(R.dimen.section_card_icon_size))
                    )
                },
                label = {
                    Text(
                        text = destination.name,
                    )
                },
                selected = selected,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigate(itemDestination.name)
                    currentScreen = itemDestination
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KanjiAppPreviewLight() {
    KanjiMasteryTheme {
        KanjiMastery()
    }
}

@Preview(showBackground = true)
@Composable
fun KanjiAppPreviewDark() {
    KanjiMasteryTheme(darkTheme = true) {
        KanjiMastery()
    }
}