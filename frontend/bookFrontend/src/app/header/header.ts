import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [RouterModule],
  templateUrl: './header.html',
  styleUrl: './header.css'
})

export class Header {
constructor(private router:Router){}
  confirmLogout(event: Event){
    event.preventDefault();
    if(window.confirm('Are you sure you want to logout?')){
      this.router.navigate(['/login'])
    }
  }
}
