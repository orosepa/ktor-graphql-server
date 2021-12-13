package com.example.plugins

import com.apurebase.kgraphql.GraphQL
import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.models.Book
import com.example.models.InputBook
import com.example.repository.BookRepository
import com.example.repository.IBookRepository
import io.ktor.application.*
import java.util.*

fun Application.configureSchema() {
    install(GraphQL) {
        playground = true
        schema {
            librarySchema()
        }
    }
}

fun SchemaBuilder.librarySchema() {

    val repository: IBookRepository = BookRepository()

    mutation("create") {
        description = "Create a new book"
        resolver { inputBook: InputBook ->
            try {
                val id = UUID.randomUUID().toString()
                val book = Book(id, inputBook.title, inputBook.genre, inputBook.author)
                repository.createBook(book)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    query("books") {
        description = "Retrieve all books"
        resolver { ->
            try {
                repository.bookList()
            } catch (e: Exception) {
                emptyList<Book>()
            }
        }
    }

    mutation("update") {
        description = "Update book's info"
        resolver { id: String, inputBook: InputBook ->
            try {
                repository.updateBook(id, inputBook)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    mutation("delete") {
        description = "Deletes a book by id"
        resolver { id: String ->
            try {
                repository.deleteBook(id)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    query("booksByAuthor") {
        description = "Retrieve list of books of specific author"
        resolver { author: String ->
            try {
                repository.filterBooksByAuthor(author)
            } catch (e: Exception) {
                emptyList<Book>()
            }
        }
    }

    query("booksByGenre") {
        description = "Retrieve list of books of specific genre"
        resolver { genre: String ->
            try {
                repository.filterBooksByGenre(genre)
            } catch (e: Exception) {
                emptyList<Book>()
            }
        }
    }

    type<Book> {
        description = "Book object with the attributes id, title, genre and author"
    }
    inputType<InputBook> {
        description = "Book object without identifier"
    }
}
