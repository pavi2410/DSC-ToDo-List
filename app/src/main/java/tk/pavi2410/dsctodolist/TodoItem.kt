package tk.pavi2410.dsctodolist

import android.graphics.Paint
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_todo.*

class TodoItem(private val todo: TodoModel) : Item() {

    override fun getLayout() = R.layout.item_todo

    override fun bind(viewHolder: GroupieViewHolder, pos: Int) {
        viewHolder.apply {
            cb_done.isChecked = todo.isDone
            text_msg.text = todo.msg

            cb_done.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                    text_msg.paintFlags = text_msg.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                else
                    text_msg.paintFlags = text_msg.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }

    }
}