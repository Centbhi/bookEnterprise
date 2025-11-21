import { Component, OnInit } from '@angular/core';
import { BookApi, Book } from '../book-api';
import { BookCard } from "../book-card/book-card";

@Component({
  selector: 'app-genre-list',
  templateUrl: './genre-list.html',
  styleUrl: './booklist.css',
  imports: [BookCard]
})
export class GenreList {
  books: Book[] = [];
  constructor (private api:BookApi) {}

  ngOnInit(): void {
    this.api.getByGenre("Romance").subscribe({
      next: (data) => {this.books = data;},
      error: (err) => console.error('API Error', err)
    });
  }

}
