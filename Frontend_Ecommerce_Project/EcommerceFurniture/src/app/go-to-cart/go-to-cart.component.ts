import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Furniture } from '../model/furniture';
import { FurnitureService } from '../service/furniture.service';

@Component({
  selector: 'app-go-to-cart',
  templateUrl: './go-to-cart.component.html',
  styleUrls: ['./go-to-cart.component.css']
})
export class GoToCartComponent implements OnInit {

  product:Furniture[]=[];

  constructor(private service:FurnitureService,private router:Router){}
  ngOnInit(): void {
    this.service.getFurnitureDataToCart(this.service.data.emailId).subscribe((data:any )=>{
      this.product = data
      console.log("osoosppppppp"+ JSON.stringify(data));
    })
  }

  goToProducts()
  {
    this.router.navigate(['products']);
  }
  

}
