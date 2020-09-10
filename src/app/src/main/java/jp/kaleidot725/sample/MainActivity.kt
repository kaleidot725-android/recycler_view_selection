package jp.kaleidot725.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.itemanimators.ScaleUpAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutManager = LinearLayoutManager(applicationContext)
        val customAdapter =  CustomRecyclerAdapter().apply { data = createSampleData() }

        recycler_view.also { view ->
            view.adapter = customAdapter
            view.layoutManager = layoutManager
            view.setHasFixedSize(true)
        }
    }

    private fun createSampleData() = (0..100).map { it.toString() }
}
