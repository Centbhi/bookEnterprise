import { Component, Input } from '@angular/core';
import { UserApi } from '../user-api';
import { Router } from '@angular/router';

@Component({
  selector: 'app--list-container',
  templateUrl: './list-container.html',
  styleUrl: './list-container.css'
})
export class BooklistLayout {
  @Input() sectionTitle = '';
  @Input() sectionText= '';

  constructor (private api:UserApi,private router:Router) {}

  switchAdmin(): void {
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
