package com.roman_druck.short_book



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class BookAdapter (listArray: ArrayList<Book>, context: Context, val listener: Listener): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvAutor = view.findViewById<TextView>(R.id.tvTitle)
        val tvName = view.findViewById<TextView>(R.id.tVname)
        val tvContext = view.findViewById<TextView>(R.id.short_tV)


        fun bind(listItem: Book, context: Context,listener: Listener){
            tvAutor.text = listItem.autor
            tvName.text = listItem.name_book
            tvContext.text = listItem.contentText
            itemView.setOnClickListener{
                listener.onClickItem(listItem)
                Toast.makeText(context, "Нажали ${tvAutor.text}", Toast.LENGTH_SHORT).show()

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.book_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayR[position]
        holder.bind(listItem, contextR, listener)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    class BookDiffCallback(private val oldList: List<Book>, private val newList: List<Book>) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].autor == newList[newItemPosition].autor
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
    fun updateAdapter(newList: List<Book>) {
        val diffCallback = BookDiffCallback(listArrayR, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listArrayR.clear()
        listArrayR.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
    interface Listener{
        fun onClickItem(listItem: Book)

    }

}