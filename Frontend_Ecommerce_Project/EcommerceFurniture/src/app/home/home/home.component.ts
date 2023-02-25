import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FurnitureService } from 'src/app/service/furniture.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private service : FurnitureService, private router : Router){}
  product : any=[];
  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(){
    this.service.getProds().subscribe({
      next : (data)=>{
        this.product = data;
      },
      error : () => {alert("No products found")}
    })
  }


  goToCart()
  {
    this.router.navigate(['goToCart']);
  }
}
