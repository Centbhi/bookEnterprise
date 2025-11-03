import { Routes } from '@angular/router';
import { BookList } from './BookList/booklist';
import { Login } from './login/login';

export const routes: Routes = [
    { path: '', component: BookList, pathMatch: 'full'},
    { path: 'test', component: BookList, pathMatch: 'full'},
    { path: 'login', component: Login, pathMatch: 'full'}
];
