import { Component, OnInit } from '@angular/core';
import { ApiService, Book } from '../api';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'user-booklist',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './user-booklist.html',
  styleUrl: './booklist.css'
})

export class UserBookList implements OnInit{
  books: Book[] = [];
  constructor (private api:ApiService) {}

  ngOnInit(): void {
    this.api.getBooks().subscribe({
      next: (data) => {
        this.books = data;
      },
      error: (err) => console.error('API Error', err)
    });
  }

}
