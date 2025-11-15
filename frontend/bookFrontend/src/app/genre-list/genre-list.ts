import { Component, OnInit } from '@angular/core';
import { BookApi, Book } from '../book-api';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-genre-list',
  imports: [CommonModule],
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
