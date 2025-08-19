package fr.wakuir.kanjimastery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.wakuir.kanjimastery.ui.theme.KanjiMasteryTheme
import fr.wakuir.kanjimastery.ui.theme.Typography

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KanjiMasteryTheme {
                KanjiApp()
            }
        }
    }
}

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
fun KanjiApp() {
    Scaffold(
        bottomBar = {
            NavBar()
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(R.dimen.default_spacing))
            ) {
                Row {
                    Text(
                        text = stringResource(R.string.greeting_message, "Alex"),
                        style = Typography.titleLarge,
                        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.default_spacing))
                    )

                    Spacer(Modifier.weight(1f))

                    Icon(
                        painter = painterResource(R.drawable.account),
                        contentDescription = stringResource(R.string.account_settings_description),
                        modifier = Modifier.size(dimensionResource(R.dimen.title_icon_size))
                    )
                }

                Text(
                    text = stringResource(R.string.progress_section_title),
                    style = Typography.titleSmall,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.small_spacing))
                )

                Row {
                    Text(
                        text = stringResource(R.string.progress_section_kanji_learned, 32)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = stringResource(R.string.progress_section_radicals_learned, 8),
                        style = Typography.bodyMedium
                    )
                }

                LinearProgressIndicator(
                    modifier = Modifier
                        .padding(
                            top = dimensionResource(R.dimen.very_small_spacing),
                            bottom = dimensionResource(R.dimen.small_spacing)
                        )
                        .fillMaxWidth(),
                    progress = { .3F },
                    drawStopIndicator = {},
                    gapSize = 0.dp,
                )

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(dimensionResource(R.dimen.default_rounding)),
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.small_spacing))
                        .fillMaxWidth(),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.small_spacing))
                    ) {
                        Text(
                            text = stringResource(R.string.quick_start_button_label),
                            fontSize = dimensionResource(R.dimen.button_content).value.sp,
                            modifier = Modifier.padding(end = dimensionResource(R.dimen.small_spacing))
                        )

                        Icon(
                            painter = painterResource(R.drawable.play_icon),
                            contentDescription = stringResource(R.string.quick_start_button_label),
                            modifier = Modifier.size(dimensionResource(R.dimen.button_content))
                        )
                    }
                }

                Text(
                    text = stringResource(R.string.daily_kanji_section_title),
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.default_spacing))
                )

                Row(
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.small_spacing),
                        bottom = dimensionResource(R.dimen.small_spacing)
                    )
                ) {
                    Text(
                        text = "刀", fontSize = 45.sp, modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.small_spacing),
                            end = dimensionResource(R.dimen.default_spacing)
                        )
                    )

                    Column {
                        Text(
                            text = "Blade / Sword",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(
                                bottom = dimensionResource(R.dimen.very_small_spacing)
                            )
                        )

                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(dimensionResource(R.dimen.default_rounding)),
                        ) {
                            Text(
                                text = stringResource(R.string.daily_kanji_section_learn_button_label),
                                style = Typography.bodyLarge,
                                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.small_spacing))
                            )
                        }
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.default_spacing),
                    ),
                ) {
                    Box(
                        modifier = Modifier.padding(end = dimensionResource(R.dimen.small_spacing))
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.goals_icon),
                            contentDescription = stringResource(R.string.daily_goal_section_title),
                            modifier = Modifier.size(dimensionResource(R.dimen.title_icon_size))
                        )
                    }

                    Text(
                        text = stringResource(R.string.daily_goal_section_title),
                        style = Typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = dimensionResource(R.dimen.small_spacing))
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        GoalCard(
                            true,
                            "Learn 2 new Kanji",
                            modifier = Modifier.padding(top = dimensionResource(R.dimen.very_small_spacing))
                        )

                        GoalCard(true, "Review 5 radicals")
                        GoalCard(false, "Complete Daily Quiz")
                    }
                }

                Row(
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.default_spacing))
                ) {
                    SectionCard(
                        destination = Destination.Learn,
                        modifier = Modifier
                            .padding(end = dimensionResource(R.dimen.very_small_spacing))
                            .weight(1f)
                    )

                    SectionCard(
                        destination = Destination.Radicals,
                        modifier = Modifier
                            .padding(start = dimensionResource(R.dimen.very_small_spacing))
                            .weight(1f)
                    )
                }

                Row(
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.default_spacing))
                ) {
                    SectionCard(
                        destination = Destination.Lab,
                        modifier = Modifier
                            .padding(end = dimensionResource(R.dimen.very_small_spacing))
                            .weight(1f)
                    )

                    SectionCard(
                        destination = Destination.Library,
                        modifier = Modifier
                            .padding(start = dimensionResource(R.dimen.very_small_spacing))
                            .weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun GoalCard(
    checked: Boolean, label: String, modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(bottom = dimensionResource(R.dimen.very_small_spacing))
    ) {
        Box(
            modifier = Modifier.padding(end = dimensionResource(R.dimen.very_small_spacing))
        ) {
            Icon(
                painter = painterResource(if (checked) R.drawable.checked else R.drawable.unchecked),
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(R.dimen.title_icon_size))
            )
        }

        Text(
            text = label
        )
    }
}

@Composable
fun SectionCard(
    destination: Destination, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(dimensionResource(R.dimen.section_card_size))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .padding(dimensionResource(R.dimen.small_spacing))
        ) {
            Box(
                modifier = Modifier.padding(end = dimensionResource(R.dimen.small_spacing))
            ) {
                Icon (
                    painter = painterResource(destination.defaultIcon),
                    contentDescription = stringResource(destination.prompt!!),
                    modifier = Modifier.size(dimensionResource(R.dimen.section_card_icon_size))
                )
            }

            Text(
                text = stringResource(destination.prompt!!),
                textAlign = TextAlign.Center,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun NavBar() {
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar {
        Destination.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(if (selectedItem == index) destination.selectedIcon else destination.defaultIcon),
                        contentDescription = destination.name,
                        modifier = Modifier.size(dimensionResource(R.dimen.section_card_icon_size))
                    )
                },
                label = {
                    Text(
                        text = destination.name,
                    )
                },
                selected = selectedItem == index,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                onClick = { selectedItem = index },

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KanjiAppPreviewLight() {
    KanjiMasteryTheme {
        KanjiApp()
    }
}

@Preview(showBackground = true)
@Composable
fun KanjiAppPreviewDark() {
    KanjiMasteryTheme(darkTheme = true) {
        KanjiApp()
    }
}