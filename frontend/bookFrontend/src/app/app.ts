import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TestingComp } from './testing-comp/testing-comp';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,TestingComp],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {
  protected readonly title = signal('bookFrontend');
}
