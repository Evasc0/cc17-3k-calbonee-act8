data class BooksResponse(val items: List<BookItem>)
data class BookItem(val id: String, val volumeInfo: VolumeInfo)
data class VolumeInfo(val title: String, val imageLinks: ImageLinks?)
data class ImageLinks(val thumbnail: String)
