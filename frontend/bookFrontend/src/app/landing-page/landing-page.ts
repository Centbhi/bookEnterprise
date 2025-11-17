import { Component, Input } from '@angular/core';

@Component({
  selector: 'landing-page',
  templateUrl: './landing-page.html',
  styleUrl: './landing-page.css'
})
export class BooklistLayout {
  @Input() sectionTitle = '';
}
