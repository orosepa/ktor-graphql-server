package com.example.repository

import com.example.models.Book
import com.example.models.InputBook

interface IBookRepository {
    fun createBook(book: Book)
    fun bookList(): List<Book>
    fun updateBook(id: String, inputBook: InputBook)
    fun deleteBook(id: String)
    fun filterBooksByAuthor(author: String): List<Book>
    fun filterBooksByGenre(genre: String): List<Book>
}