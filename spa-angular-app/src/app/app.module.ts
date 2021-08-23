import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule}   from '@angular/forms';
import { RouterModule, Routes} from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeloginComponent } from './employeelogin/employeelogin.component';
import { EmployeehomeComponent } from './employeehome/employeehome.component';
import { AuthGuard } from './authgaurd';

const routes:Routes = [
  {path: "login", component: EmployeeloginComponent},
  {path: "employeehome", component: EmployeehomeComponent , canActivate: [AuthGuard]}
]



@NgModule({
  declarations: [
    AppComponent,
    EmployeeloginComponent,
    EmployeehomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
