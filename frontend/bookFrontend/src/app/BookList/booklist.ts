import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserBookList } from '../admin-booklist/user-booklist';
import { AdminBookList } from '../admin-booklist/admin-booklist';
import { Router } from '@angular/router';
import { User } from '../api';

@Component({
  selector: 'app-booklist',
  imports: [CommonModule, FormsModule, UserBookList, AdminBookList],
  standalone: true,
  templateUrl: './booklist.html',
  styleUrl: './booklist.css'
})


export class BookList implements OnInit{
  constructor(private router:Router){}
  user: User|null = null;
  
  ngOnInit(): void {
    if(!this.user){
      alert('You must be logged in to view this page');
      this.router.navigate(['/login']);
    }
  }

  test(): void{
    if(this.user)
      this.user.isAdmin = !this.user?.isAdmin;
  }

}
