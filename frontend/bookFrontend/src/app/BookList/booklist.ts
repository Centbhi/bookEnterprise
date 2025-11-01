import { Component, OnInit } from '@angular/core';
import { ApiService, Book } from '../api';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-booklist',
  imports: [CommonModule, FormsModule],
  standalone: true,
  templateUrl: './booklist.html',
  styleUrl: './booklist.css'
})

export class BookList implements OnInit{
  books: Book[] = [];

  constructor (private api:ApiService) {}

  ngOnInit(): void {
    this.api.getBooks().subscribe({
      next: (data) => {
        console.log(data);
        this.books = data;
        this.books.forEach(book => 
          book['isEditing'] = false
        );
      },
      error: (err) => console.error('API Error', err)
    });
  }

  updateBook(book: Book): void{
    this.api.updateBook(book.id, book).subscribe({
      next: (updated) => {
        console.log('Book Update Successful:', updated);
        book['isEditing'] = false;
      },
      error: (err) => console.log('Book Update Failure:', err)
    });
  }

  editBook(book: Book): void{
    if(book.isEditing){
      this.updateBook(book);
    }
    book.isEditing = !book.isEditing;
  }


}
