import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule}   from '@angular/forms';
import { RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeloginComponent } from './employeelogin/employeelogin.component';
import { EmployeehomeComponent } from './employeehome/employeehome.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { CreateExpenseTicketComponent } from './create-expense-ticket/create-expense-ticket.component';
import { AuthGuard } from './authgaurd';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';


const routes:Routes = [
  {path: "", component: EmployeeloginComponent},
  {path: "employeehome", component: EmployeehomeComponent , canActivate: [AuthGuard]},
  {path:"createAcount", component:CreateAccountComponent },
  {path:"updatepassword", component:UpdatepasswordComponent},
  {path:"createTicket", component:CreateExpenseTicketComponent,  canActivate: [AuthGuard]}
  
]

@NgModule({
  declarations: [
    AppComponent,
    EmployeeloginComponent,
    EmployeehomeComponent,
    CreateAccountComponent,
    CreateExpenseTicketComponent,
    UpdatepasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
