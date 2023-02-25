import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';
import { FurnitureService } from '../service/furniture.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  login:FormGroup;

  constructor(private formBuilder: FormBuilder,private _snackBar: MatSnackBar, private customerService: CustomerService,private router:Router,private service : FurnitureService){
    this.login=this.formBuilder.group({
      emailId: new FormControl('',[Validators.pattern(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)]),
      password: new FormControl('',[Validators.required])
    });
  }
  get emailId(){
    return this.login.get('emailId');
  }
  get password(){
    return this.login.get('password');
  }
  openSnackBar() {
    this._snackBar.open("Login sussessfully","success"); 
  }
  
  onSubmit(){
 
    this.customerService.customerLogin(this.login.value).subscribe((res:any) => {
      sessionStorage.setItem('token',JSON.stringify(res));
     console.log("ttttttokeeeennnn" + res.token);
      if(res){
        this.service.getCustomerById(this.login.value.emailId).subscribe((data:any)=>
        {
         
          this.service.data=data;
      
          console.log( "emailData" +JSON.stringify(data));
          
        })
       }
      this.customerService.isLoggedIn=true;
      this.router.navigate(['products']);
      alert("login sucessfully");},(error)=>{
        alert("Please check emailand password");
      })
     
  }


}
