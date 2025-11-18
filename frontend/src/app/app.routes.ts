import { Routes } from '@angular/router';
import { BookList } from './list-container/list-container';
import { Login } from './login/login';
import { GenreList } from './genre-list/genre-list';

export const routes: Routes = [
    { path: '', component: BookList, pathMatch: 'full'},
    { path: 'login', component: Login, pathMatch: 'full'},
    { path: 'genre', component: GenreList, pathMatch: 'full'}
];
