import { Component, OnInit } from '@angular/core';
import { BookApi, Book } from '../book-api';

@Component({
  selector: 'user-booklist',
  templateUrl: './user-booklist.html',
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
