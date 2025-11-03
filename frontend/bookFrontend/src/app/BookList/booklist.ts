import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserBookList } from '../admin-booklist/user-booklist';
import { AdminBookList } from '../admin-booklist/admin-booklist';
import { Router } from '@angular/router';
import { User, UserApi} from '../user-api';

@Component({
  selector: 'app-booklist',
  imports: [CommonModule, FormsModule, UserBookList, AdminBookList],
  standalone: true,
  templateUrl: './booklist.html',
  styleUrl: './booklist.css'
})


export class BookList implements OnInit{
  constructor (private api:UserApi,private router:Router) {}
  
  ngOnInit(): void {
    if(!this.api.getCurrUser){
      alert('You must be logged in to view this page');
      this.router.navigate(['/login']);
    }
  }
  
  get user(){
    return this.api.getCurrUser();
  }

  test(): void {
    const user = this.api.getCurrUser();
    if(!user||!user.id) return; 
    const updatedUser = { ...user, admin: !user.admin};
    this.api.updateUser(user.id, updatedUser).subscribe({
      next: updated => {this.api.setCurrUser(updated);
        console.log(updated);},
      error: err => console.error('Failed to update user:', err)
    });
  }
}
