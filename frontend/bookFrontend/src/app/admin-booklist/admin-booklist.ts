import { Component, OnInit } from '@angular/core';
import { BookApi, Book } from '../book-api';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'admin-booklist',
  imports: [CommonModule, FormsModule],
  templateUrl: './admin-booklist.html',
  styleUrl: './booklist.css'
})

export class AdminBookList implements OnInit{
  books: Book[] = [];
  constructor (private api:BookApi) {}

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

  validateNum(value: number, lowerLim: number = 0, upperLim: number = 9999): number{
    if(value > lowerLim){
      if(value < upperLim){
        return value;
      }else{
        return upperLim;
      }
    }else{
      return lowerLim;
    }
  }

  updateBook(book: Book): void{
    this.api.updateBook(book.id!, book).subscribe({
      next: (response) => {
        console.log('Book Update Successful:', response);
        book['isEditing'] = false;
      },
      error: (err) => console.log('Book Update Failure:', err)
    });
  }

  createBook(): void{
    const newBook: Book ={
      title: 'New Book',
      rating: 0,
      coverImgUrl: '',
      author: '',
      genre: '',
      datePublished: '',
      description: '',
      publisher: '',
      price: 0,
      status: 'Available',
      quantityStock: 0,
    };
    this.api.createBook(newBook).subscribe({
      next: (response) => {
        response.isEditing = true;
        this.books.unshift(response);
      },
      error: (err) => console.log('Book Creation Failure:', err)
    })

  }

  deleteBook(book: Book): void{
    this.api.deleteBook(book.id!).subscribe({
      next: (response) => {
        console.log('Book Deletion Successful:', response);
        this.books = this.books.filter(b => b.id !== book.id);
      },
      error: (err) => console.log('Book Deletion Failure:', err)
    });
  }

  editBook(book: Book): void{
    if(book.isEditing){
      this.updateBook(book);
    }
    book.isEditing = !book.isEditing;
  }
}
