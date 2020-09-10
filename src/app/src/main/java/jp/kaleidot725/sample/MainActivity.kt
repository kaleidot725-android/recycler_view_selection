package jp.kaleidot725.sample

import android.app.usage.StorageStats
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutManager = LinearLayoutManager(applicationContext)
        val customAdapter =  NumberAdapter().apply { data = createNumbers() }
        val tracker = SelectionTracker.Builder<Number>(
            "my-selection-id",
            recycler_view,
            NumberKeyProvider(customAdapter),
            NumberDetailsLookup(recycler_view),
            StorageStrategy.createParcelableStorage(Number::class.java)
        ).build()

        recycler_view.also { view ->
            view.adapter = customAdapter
            view.layoutManager = layoutManager
            view.setHasFixedSize(true)
        }
    }

    private fun createNumbers() = (0..100).mapIndexed { index, number ->
        Number(index, number.toString())
    }
}
