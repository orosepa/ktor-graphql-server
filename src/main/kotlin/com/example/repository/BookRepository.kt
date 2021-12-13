package com.example.repository

import com.example.db.books
import com.example.models.Book
import com.example.models.InputBook

class BookRepository : IBookRepository {
    override fun createBook(book: Book){
        books.add(book)
    }

    override fun bookList(): List<Book> {
        return books
    }

    override fun updateBook(id: String, inputBook: InputBook) {
        books.find { it.id == id }?.apply {
            this.title = inputBook.title
            this.genre = inputBook.genre
            this.author = inputBook.author
        }
    }

    override fun deleteBook(id: String) {
        books.removeIf { it.id == id }
    }

    override fun filterBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author == author }
    }

    override fun filterBooksByGenre(genre: String): List<Book> {
        return books.filter { it.genre == genre }
    }
}