import { Component, Input } from '@angular/core';

@Component({
  selector: 'booklist-layout',
  imports: [],
  templateUrl: './booklist-layout.html',
  styleUrl: './booklist-layout.css'
})
export class BooklistLayout {
  @Input() sectionTitle = '';
}
