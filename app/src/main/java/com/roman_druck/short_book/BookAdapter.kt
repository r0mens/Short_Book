package com.roman_druck.short_book


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BookAdapter (listArray: ArrayList<Book>, context: Context): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context



    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvAutor = view.findViewById<TextView>(R.id.tvTitle)
        val tvName = view.findViewById<TextView>(R.id.tVname)
        val tvContext = view.findViewById<TextView>(R.id.short_tV)


        fun bind(listItem: Book, context: Context){
            tvAutor.text = listItem.autor
            tvName.text = listItem.name_book
            tvContext.text = listItem.contentText
            itemView.setOnClickListener(){
                Toast.makeText(context, "Нажали ${tvAutor.text}", Toast.LENGTH_SHORT).show()
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.book_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }
}


