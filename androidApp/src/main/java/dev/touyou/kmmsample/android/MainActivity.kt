package dev.touyou.kmmsample.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.google.android.material.composethemeadapter3.Mdc3Theme
import dev.touyou.kmmsample.NoteAPI
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            NoteAPI().fetchNotes {
                runOnUiThread {
                    val greeting = findViewById<ComposeView>(R.id.greeting)
                    greeting.apply {
                        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                        setContent {
                            Mdc3Theme {
                                GreetingView(it.map { it.name }.joinToString("\n"))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun GreetingView(text: String = "Hello") {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
