import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GoToCartComponent } from './go-to-cart/go-to-cart.component';
import { HomeComponent } from './home/home/home.component';


import { LoginComponent } from './login/login.component';
import { ProductPageComponent } from './product-page/product-page.component';

import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { AuthGuard } from './service/auth.guard';
import { DeactivateGuard } from './service/deactivate.guard';

const routes: Routes = [
  {path:'',component:RegistrationFormComponent},
  {path:'registrationForm',component:RegistrationFormComponent},
  {path:'login',component:LoginComponent,canDeactivate:[DeactivateGuard]}, 
  {path:"products",component:HomeComponent, canActivate: [AuthGuard]},
  {path:"product/:id",component:ProductPageComponent,canActivate:[AuthGuard]},
  {path:"goToCart",component:GoToCartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
