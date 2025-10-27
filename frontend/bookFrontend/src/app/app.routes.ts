import { Routes } from '@angular/router';
import { BookList } from './BookList/booklist';

export const routes: Routes = [
    { path: '', component: BookList, pathMatch: 'full'},
    { path: 'test', component: BookList, pathMatch: 'full'}
];
