package com.ithub.todoapp.activities.main_page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ithub.todoapp.R
import com.ithub.todoapp.activities.main_page.adapters.ItemsAdapter
import com.ithub.todoapp.databinding.ActivityItemsBinding
import com.ithub.todoapp.models.Item

class ItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityItemsBinding
    private val items = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        items.add(Item(1, R.drawable.sofa, "Диван", "Элегантный и удобный диван идеально впишется в любой интерьер", "Изготовленный из прочных материалов, этот диван обеспечивает надежность и долговечность. Его удобная конструкция и мягкая обивка приглашают вас на уютные вечера перед телевизором или приятные часы в компании друзей и семьи.", 2500 ))
        items.add(Item(2, R.drawable.lamp, "Лампа", "Стильная и функциональная лампа для вашего пространства.", "Изготовленная из высококачественных материалов, эта лампа обеспечивает прочность и долговечность. Ее стильный дизайн и инновационные осветительные технологии создают приятное освещение и атмосферу в вашем доме или офисе.", 1000 ))
        items.add(Item(3, R.drawable.kitchen, "Кухня", "Практичная и стильная кухня для современного образа жизни.", "Эта кухня оборудована современной кухонной техникой высокого качества, что делает процесс приготовления еды легким и приятным. Просторные столешницы из прочных материалов обеспечивают достаточно места для работы, а удобные шкафы и ящики позволяют хранить кухонные принадлежности в порядке.", 5000 ))

        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = ItemsAdapter(items, this)
    }
}