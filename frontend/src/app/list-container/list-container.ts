import { Component, OnInit, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserBookList } from '../book-list/user-booklist';
import { AdminBookList } from '../book-list/admin-booklist';
import { BooklistLayout } from '../landing-page/landing-page';
import { Router } from '@angular/router';
import { UserApi } from '../user-api';

@Component({
  selector: 'app-list-container',
  imports: [FormsModule, UserBookList, AdminBookList, BooklistLayout],
  templateUrl: './list-container.html',
})

export class BookList implements OnInit{
  constructor (private api:UserApi,private router:Router) {}
  
  ngOnInit(): void {
    if(!this.api.getCurrUser()){
      alert('You must be logged in to view this page');
      this.router.navigate(['/login']);
    }
  }
  
  get user(){
    return this.api.getCurrUser();
  }

}