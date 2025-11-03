import { Component, OnInit } from '@angular/core';
import { ApiService, Book } from '../api';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserBookList } from '../admin-booklist/user-booklist';
import { AdminBookList } from '../admin-booklist/admin-booklist';

@Component({
  selector: 'app-booklist',
  imports: [CommonModule, FormsModule, UserBookList, AdminBookList],
  standalone: true,
  templateUrl: './booklist.html',
  styleUrl: './booklist.css'
})

export class BookList{
  user = {isAdmin: true};

  test(): void{
    this.user.isAdmin = !this.user.isAdmin;
  }

}
