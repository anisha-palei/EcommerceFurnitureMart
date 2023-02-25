import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Furniture } from '../model/furniture';
import { FurnitureService } from '../service/furniture.service';


@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
  constructor(private route : ActivatedRoute, private service : FurnitureService,private router:Router){}
  product : any;
  ngOnInit(): void {
    this.route.params.subscribe(
      {
        next :(data)=>{ this.getData((data['id']))
      
         
      }
      }
    )
  }

  getData(data : number){
    this.service.getProdById(data).subscribe(
      {
        next : data =>this.product = data,
        error : ()=>alert("not found")
      }
    )
  }

  addToCart(data:Furniture)
  {
      this.service.addFurniture(this.service.data.emailId,data).subscribe((res)=>{
      console.log(res);
    })
    this.router.navigate(['products']);
    alert("Data has been added")
  }
  //   let email:any=localStorage.getItem('emailId');
  //   this.prodService.addFurniture(email,data).subscribe((res)=>{
  //     console.log(res);
  //   })
  //   this.router.navigate(['products']);
  //   alert("Data has been added")
  // }
  


  goToCart()
  {
    this.router.navigate(['goToCart']);
  }

  back()
  {
    this.router.navigate(['products']);
  }
}
