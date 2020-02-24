package tk.pavi2410.dsctodolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_new_task.*

class NewTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)

        btn_submit.setOnClickListener {
            Snackbar.make(it, "Not Implemented", Snackbar.LENGTH_LONG).show()
        }
    }
}
