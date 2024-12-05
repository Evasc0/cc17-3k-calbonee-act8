import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BooksViewModel(private val repository: BooksRepository) : ViewModel() {
    private val _books = MutableLiveData<List<BookItem>>()
    val books: LiveData<List<BookItem>> = _books

    fun fetchBooks(query: String) {
        viewModelScope.launch {
            try {
                _books.value = repository.searchBooks(query)
            } catch (e: Exception) {
                // Handle error (e.g., display error message)
            }
        }
    }
}
