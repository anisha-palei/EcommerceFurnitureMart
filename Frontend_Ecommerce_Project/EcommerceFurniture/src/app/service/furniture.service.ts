import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Furniture } from '../model/furniture';



@Injectable({
  providedIn: 'root'
})
export class FurnitureService {

data?: any;
  constructor(private http: HttpClient) { }

  public getProds(){
    const requestHeaders = new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
    return this.http.get("http://localhost:8082/api/v2/user/getAllFurniture",{'headers': requestHeaders})
  }
  public getProdById(id : number){
    const requestHeaders = new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
    return this.http.get("http://localhost:8082/api/v2/product/user/"+id,{'headers': requestHeaders})
  }

  public addFurniture(id : String,data:Furniture)
  {
    const requestHeaders = new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
    return this.http.post("http://localhost:8082/api/v2/user/addToCart/"+id,data,{'headers': requestHeaders});
  }

  public getCustomerById(id : string)
  {
    const requestHeaders = new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
    return this.http.get("http://localhost:8082/api/v2/user/furnitureCart/customer/"+id,{'headers': requestHeaders})
  }

  public getFurnitureDataToCart(id : string)
  {
    const requestHeaders = new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
    return this.http.get("http://localhost:8082/api/v2/user/furnitureCart/"+id,{'headers': requestHeaders})
  }
}
