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
    var adapter: BookAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var list = ArrayList<Book>()
        list.addAll(fillArras(resources.getStringArray(R.array.autor_book_classika),
                              resources.getStringArray(R.array.name_book_classika),
                              resources.getStringArray(R.array.context_book_classika)))



        adapter = BookAdapter(list, this)
        rcView.adapter = BookAdapter(list,this)






        binding.apply {
            navView.setNavigationItemSelectedListener {
                when (it.itemId) {

                    R.id.classika ->{
                        adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.autor_book_classika),
                            resources.getStringArray(R.array.name_book_classika),
                            resources.getStringArray(R.array.context_book_classika)))
                        Toast.makeText(this@MainActivity, "Id classika", Toast.LENGTH_SHORT).show()

                    }
                    R.id.military -> {
                        adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.autor_book_militari),
                            resources.getStringArray(R.array.name_book_militari),
                            resources.getStringArray(R.array.context_book_militari)))

                        Toast.makeText(this@MainActivity, "Id military", Toast.LENGTH_SHORT).show()
                    }
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
    fun fillArras(titleArray:Array<String>, nameArray:Array<String>, contentArray:Array<String>):List<Book>
    {
        var listItemArray = ArrayList<Book>()
          for (n in 0..titleArray.size -1)
          {
              var listItem = Book(titleArray[n], nameArray[n], contentArray[n])
              listItemArray.add(listItem)
          }
        return listItemArray

    }
}