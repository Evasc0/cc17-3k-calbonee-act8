import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookshelfapp.R

class BooksAdapter(private val books: List<BookItem>) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    // ViewHolder for each book item
    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.recyclerView)
        val titleView: TextView = view.findViewById(R.id.recyclerView)
    }

    // Called when a new ViewHolder is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        // Inflate the item_book layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    // Bind the data to the views
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]

        // Set the book title
        holder.titleView.text = book.volumeInfo.title

        // Load the book image (using Glide to download the image)
        Glide.with(holder.imageView.context)
            .load(book.volumeInfo.imageLinks?.thumbnail?.replace("http", "https"))
            .into(holder.imageView)
    }

    // Return the number of items in the list
    override fun getItemCount() = books.size
}
