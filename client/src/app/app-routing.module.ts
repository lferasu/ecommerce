import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CatalogComponent } from './catalog/catalog.component';
import { LoginComponent } from './login/login.component';
import { ProductComponent } from './product/product.component';
import { UserComponent } from './user/user.component';
import { CartComponent } from './cart/cart.component'
import { CheckoutComponent } from './checkout/checkout.component';
import { BankComponent } from './bank/bank.component';
import { CcComponent } from './cc/cc.component';
import { PaypalComponent } from './paypal/paypal.component';
import { SignupComponent } from './signup/signup.component';


const routes: Routes = [

  { path: 'catalog', component: CatalogComponent },
  { path: 'login', component: LoginComponent },
  { path: 'product', component: ProductComponent },
  { path: 'user', component: UserComponent },
  { path: 'cart', component: CartComponent },
  { path: 'signup', component: SignupComponent },
  {
    path: 'checkout', component: CheckoutComponent,
    children: [
      { path: 'bank', component: BankComponent },
      { path: 'cc', component: CcComponent },
      { path: 'paypal', component: PaypalComponent }
    ]
  },
  { path: '', redirectTo: 'catalog', pathMatch: 'full' }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
