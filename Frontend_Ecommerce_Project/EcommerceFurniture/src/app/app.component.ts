import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from './service/customer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EcommerceFurniture';
  constructor(private service : CustomerService, private router : Router){}
  logout(){
    this.service.isLoggedIn = false;
    this.router.navigateByUrl("login")
  }
}
