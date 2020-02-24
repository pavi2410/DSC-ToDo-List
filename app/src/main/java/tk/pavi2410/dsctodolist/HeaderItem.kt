package tk.pavi2410.dsctodolist

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_header.*

class HeaderItem(private val title: String) : Item() {

    override fun getLayout() = R.layout.item_header

    override fun bind(viewHolder: GroupieViewHolder, pos: Int) {
        viewHolder.apply {
            text_title.text = title
        }

    }
}