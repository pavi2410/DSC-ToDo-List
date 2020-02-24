package tk.pavi2410.dsctodolist

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            val newTaskActivity = Intent(this, NewTaskActivity::class.java)
            startActivity(newTaskActivity)
        }

        // Setup recyclerview

        val groupieAdapter = GroupAdapter<GroupieViewHolder>()
        todolist.adapter = groupieAdapter
        todolist.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    // scroll down
                    fab.shrink()
                    (fab.layoutParams as CoordinatorLayout.LayoutParams).gravity =
                        Gravity.BOTTOM or Gravity.END
                } else if (dy < 0) {
                    // scroll up
                    (fab.layoutParams as CoordinatorLayout.LayoutParams).gravity =
                        Gravity.BOTTOM or Gravity.CENTER
                    fab.extend()
                }
            }
        })

        // Add placeholder todo items

        val todaySection = Section()
        val todayHeader = HeaderItem("Today")
        todaySection.setHeader(todayHeader)
        repeat(5) { i ->
            val todoModel = TodoModel("Todo $i", 0L, false)
            val todoItem = TodoItem(todoModel)
            todaySection.add(todoItem)
        }
        groupieAdapter.add(todaySection)

        val tomorrowSection = Section()
        val tomorrowHeader = HeaderItem("Tomorrow")
        tomorrowSection.setHeader(tomorrowHeader)
        repeat(5) { i ->
            val todoModel = TodoModel("Todo $i", 0L, false)
            val todoItem = TodoItem(todoModel)
            tomorrowSection.add(todoItem)
        }
        groupieAdapter.add(tomorrowSection)
    }
}
