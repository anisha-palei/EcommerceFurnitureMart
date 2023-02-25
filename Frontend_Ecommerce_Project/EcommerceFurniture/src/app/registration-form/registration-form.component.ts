import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent {
  registrationForm:FormGroup;
  myControl = new FormControl();
  constructor(private formbuider:FormBuilder,private _snackBar: MatSnackBar,private customerService: CustomerService,private router:Router) {
      this.registrationForm = this.formbuider.group({
      customerName:new FormControl('',[Validators.required,Validators.minLength(2)]),
      emailId:new FormControl('',[Validators.pattern(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)]),
      password:new FormControl('',[Validators.required, Validators.pattern(/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/)]),
      confirmPassword:new FormControl('',[Validators.required]),
      age:new FormControl('',[Validators.required,Validators.pattern(/^(1[89]|[2-9]\d)$/gm)]),
      mobileNo:new FormControl('',[Validators.pattern(/^[6789]\d{9,9}$/)]),
},{validator:[this.passwordShouldMatchValidation]});
}

get age() {
  return this.registrationForm.get("age");
}

get customerName(){
  return this.registrationForm.get('customerName');
}

get emailId(){
  return this.registrationForm.get('emailId');
}
get password(){
  return this.registrationForm.get('password');
}
get confirmPassword(){
  return this.registrationForm.get('confirmPassword');
}
get mobileNo(){
  return this.registrationForm.get('mobileNo');
}
openSnackBar() {
  this._snackBar.open("Feedback submitted sussessfully","success"); 
}

passwordShouldMatchValidation(myControl:AbstractControl){
  const passwordValue=myControl.get('password')?.value;
  const confirmPasswordValue=myControl.get('confirmPassword')?.value;
  if(!passwordValue || !confirmPasswordValue){
    return null;
 }
if(passwordValue != confirmPasswordValue){
  return {passwordShouldMatch : false};   
}
return null;
}



onSubmit(){
  this.customerService.registerCustomer(this.registrationForm.value).subscribe(res => {alert("Registered sucessfully")})
 this.registrationForm.reset();
 this.router.navigate(['login']);
console.log("submitted successfully")

}
}
