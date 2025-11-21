import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Book } from '../book-api';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-admin-card',
  imports: [FormsModule],
  templateUrl: './admin-card.html',
  styleUrl: './book-card.css',
})
export class AdminCard {
  @Input() book!: Book;
  @Output() update = new EventEmitter<Book>();

  validateNum(value: number, lowerLim: number = 0, upperLim: number = 9999): number{
    if(value > lowerLim){
      if(value < upperLim){
        return value;
      }else{
        return upperLim;
      }
    }else{
      return lowerLim;
    }
  }
  updateBook(){
    this.update.emit(this.book);
  }
}
