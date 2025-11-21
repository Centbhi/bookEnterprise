import { Component } from '@angular/core';
import { GenreList } from "../book-list/genre-list";
import { BooklistLayout } from "../landing-page/landing-page";
import { UserApi } from '../user-api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-genre-page',
  imports: [GenreList, BooklistLayout],
  templateUrl: './genre-page.html',
  styleUrl: './genre-page.css',
})
export class GenrePage {
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
export { GenreList };

