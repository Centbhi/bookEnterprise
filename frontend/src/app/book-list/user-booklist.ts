import { Component, OnInit } from '@angular/core';
import { BookApi, Book } from '../book-api';
import { BookCard } from '../book-card/book-card'

@Component({
  selector: 'user-booklist',
  templateUrl: './user-booklist.html',
  imports: [BookCard],
  styleUrl: './booklist.css'
})

export class UserBookList implements OnInit{
  books: Book[] = [];
  constructor (private api:BookApi) {}

  ngOnInit(): void {
    this.api.getBooks().subscribe({
      next: (data) => {
        this.books = data;
      },
      error: (err) => console.error('API Error', err)
    });
  }

}
