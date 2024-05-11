package com.ithub.todoapp.activities.main_page.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ithub.todoapp.ItemActivity
import com.ithub.todoapp.R
import com.ithub.todoapp.databinding.ItemInListBinding
import com.ithub.todoapp.models.Item

class ItemsAdapter(var items: List<Item>, var context: Context) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        holder.lookBtn?.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java)

            intent.putExtra("tvTitle", items[position].title)
            intent.putExtra("tvText", items[position].text)

            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return items.count()
    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemInListBinding.bind(view)
        val lookBtn: Button? = view.findViewById(R.id.il_button)

        fun bind(item: Item) = with(binding) {
            ilTitle.text = item.title
            ilDesc.text = item.desc
            ilPrice.text = item.price.toString() + "$"
            ilImage.setImageResource(item.image)
        }

    }

}