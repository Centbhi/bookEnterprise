import { Component, OnInit } from '@angular/core';
import { BookApi, Book } from '../book-api';

@Component({
  selector: 'app-genre-list',
  templateUrl: './genre-list.html',
  styleUrl: './genre-list.css'
})
export class GenreList {
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
