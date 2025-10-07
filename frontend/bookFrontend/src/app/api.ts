import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Book {
  id: number;
  title: string;
  genre: string;
  status: string;
  datePublished: string;
  author: string;
  publisher: string;
  description: string;
  coverImgUrl: string;

  quantityStock: number;
  price: number;
  rating: number;
}

@Injectable({
  providedIn: 'root'
})

export class ApiService{
  constructor(private http: HttpClient){}

  getBooks() : Observable<Book[]> {
    return this.http.get<Book[]>(`/api/book`);
  }

  getBook(id:number) : Observable<Book> {
    return this.http.get<Book>(`/api/book/${id}`);
  }

  createBook(book:Book) : Observable<Book> {
    return this.http.post<Book>(`/api/book`,book);
  }

  updateBook(id:number,book:Book) : Observable<Book> {
    return this.http.put<Book>(`/api/book/${id}`,book);
  }

  deleteBook(id:number) : Observable<void>{
    return this.http.delete<void>(`/api/book/${id}`);
  }
}