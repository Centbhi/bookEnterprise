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
  isEditing?: boolean;
}

export interface User{
  name: string;
  isAdmin: boolean;
  password: string;
  books: Book[];
}

@Injectable({
  providedIn: 'root'
})

export class ApiService{
  private bookUrl = "/api/book"
  private userUrl = "/api/user"
  private currUser: User|null = null;
  constructor(private http: HttpClient){}

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.bookUrl);
  }

  getBook(id: number): Observable<Book> {
    return this.http.get<Book>(`${this.bookUrl}/${id}`);
  }

  createBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.bookUrl, book);
  }

  updateBook(id: number, book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.bookUrl}/${id}`, book);
  }

  deleteBook(id: number): Observable<void> {
    return this.http.delete<void>(`${this.bookUrl}/${id}`);
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

  getUser(name: string): Observable<User> {
    return this.http.get<User>(`${this.userUrl}/${name}`);
  }

  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.userUrl, user);
  }

  updateUser(name: string, user: User): Observable<User> {
    return this.http.put<User>(`${this.userUrl}/${name}`, user);
  }

  deleteUser(name: string): Observable<void> {
    return this.http.delete<void>(`${this.userUrl}/${name}`);
  }

}