import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  isLoggedIn: boolean = false;
  constructor(private http:HttpClient) { }

  registerCustomer(data : any){
    return this.http.post("http://localhost:8082/api/v2/register",data)
  }

  
  customerLogin(data : {}){
    return this.http.post("http://localhost:8084/api/v1/login",data)
  }


}
