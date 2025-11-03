import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService, User } from '../api';

@Component({
  selector: 'app-login',
  imports: [FormsModule,CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})

export class Login implements OnInit{

  constructor (private api:ApiService) {}

  ngOnInit(): void {
  }

  user: User = {
    name: '',
    password: '',
    isAdmin: false,
    books: []
  }

  isLogin = true;
  onSubmit(){
    
  }
}
