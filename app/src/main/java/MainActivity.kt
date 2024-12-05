import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookshelfapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var booksViewModel: BooksViewModel
    private lateinit var adapter: BooksAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)  // 2 columns for grid layout

        // Initialize adapter with empty list
        adapter = BooksAdapter(emptyList())
        recyclerView.adapter = adapter

        // Initialize ViewModel
        booksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)

        // Observe the books list from ViewModel
        booksViewModel.books.observe(this, Observer { books ->
            // Update the adapter with the new list of books
            adapter = BooksAdapter(books)
            recyclerView.adapter = adapter
        })

        // Fetch books using ViewModel
        booksViewModel.fetchBooks("jazz history") // Example query
    }
}
