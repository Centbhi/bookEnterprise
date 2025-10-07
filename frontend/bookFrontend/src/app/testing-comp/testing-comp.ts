import { Component, OnInit } from '@angular/core';
import { ApiService, Book } from '../api';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-testing-comp',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './testing-comp.html',
  styleUrl: './testing-comp.css'
})
export class TestingComp implements OnInit{
  books: Book[] = [];

  constructor (private api:ApiService) {}

  ngOnInit(): void {
    this.api.getBooks().subscribe({
      next: (data) => (this.books = data),
      error: (err) => console.error('API Error', err)
    });
  }


}
