package com.roman_druck.short_book


import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.roman_druck.short_book.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.book_content.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var list = ArrayList<Book>()
        list.add(Book("Л.Н.Толстой", "Война и мир", ""))
        list.add(Book("А.С.Пушкин", "Руслан и Людмила", ""))
        list.add(Book("Н.В.Гоголь", "Ревизор", ""))
        list.add(Book("Ф.М.Достоевский", "Идиот", ""))
        list.add(Book("А.П.Чехов", "Вишнёвый сад", ""))
        list.add(Book("В.В.Маяковский", "Утро помещика", ""))
        list.add(Book("М.А.Булгаков", "Мастер и Маргарита", ""))
        list.add(Book("М.Ю.Лермонтов", "Бородино", ""))
        list.add(Book("В.Я.Брюсов", "Войни мир", ""))
        list.add(Book("А.А.Блок", "Вна и мир", ""))
        list.add(Book("М.Е.Салтыков-Щедрин", "Война иир", ""))

        rcView.adapter = BookAdapter(list,this)






        binding.apply {
            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.classika -> Toast.makeText(this@MainActivity,
                        "Id classika",
                        Toast.LENGTH_SHORT).show()
                    R.id.military -> Toast.makeText(this@MainActivity,
                        "Id military",
                        Toast.LENGTH_SHORT).show()
                    R.id.historical -> Toast.makeText(this@MainActivity,
                        "Id historical",
                        Toast.LENGTH_SHORT)
                        .show()
                    R.id.detectives -> Toast.makeText(this@MainActivity,
                        "Id detectives",
                        Toast.LENGTH_SHORT)
                        .show()
                    R.id.fantasy -> Toast.makeText(this@MainActivity,
                        "Id fantasy",
                        Toast.LENGTH_SHORT).show()
                    R.id.children -> Toast.makeText(this@MainActivity,
                        "Id children",
                        Toast.LENGTH_SHORT).show()
                    R.id.adventure -> Toast.makeText(this@MainActivity,
                        "Id adventure",
                        Toast.LENGTH_SHORT)
                        .show()
                    R.id.poesy -> Toast.makeText(this@MainActivity, "Id poesy", Toast.LENGTH_SHORT)
                        .show()
                    R.id.love -> Toast.makeText(this@MainActivity, "Id love", Toast.LENGTH_SHORT)
                        .show()
                }
                drawer.closeDrawer(GravityCompat.START)
                true

            }


        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}