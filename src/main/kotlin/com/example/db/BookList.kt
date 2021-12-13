package com.example.db

import com.example.models.Book
import java.util.*

val books = mutableListOf<Book>(
    Book(UUID.randomUUID().toString(), "Book1", "Genre1", "Author3"),
    Book(UUID.randomUUID().toString(), "Book2", "Genre2", "Author2"),
    Book(UUID.randomUUID().toString(), "Book3", "Genre3", "Author1"),
    Book(UUID.randomUUID().toString(), "Book4", "Genre1", "Author3"),
    Book(UUID.randomUUID().toString(), "Book5", "Genre2", "Author2"),
    Book(UUID.randomUUID().toString(), "Book6", "Genre3", "Author1"),
    Book(UUID.randomUUID().toString(), "Book7", "Genre1", "Author3"),
    Book(UUID.randomUUID().toString(), "Book8", "Genre2", "Author2"),
    Book(UUID.randomUUID().toString(), "Book9", "Genre3", "Author1"),
    Book(UUID.randomUUID().toString(), "Book10", "Genre1", "Author3"),
    Book(UUID.randomUUID().toString(), "Book11", "Genre2", "Author2"),
    Book(UUID.randomUUID().toString(), "Book12", "Genre3", "Author1"),
    Book(UUID.randomUUID().toString(), "Book13", "Genre1", "Author3"),
    Book(UUID.randomUUID().toString(), "Book14", "Genre2", "Author2"),
    Book(UUID.randomUUID().toString(), "Book15", "Genre3", "Author1"),
)