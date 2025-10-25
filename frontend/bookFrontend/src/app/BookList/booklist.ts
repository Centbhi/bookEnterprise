import { Component, OnInit } from '@angular/core';
import { ApiService, Book } from '../api';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-booklist',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './booklist.html',
  styleUrl: './booklist.css'
})

export class BookList implements OnInit{
  books: Book[] = [];

  constructor (private api:ApiService) {}

  ngOnInit(): void {
    this.api.getBooks().subscribe({
      next: (data) => (this.books = data),
      error: (err) => console.error('API Error', err)
    });
  }


}
