import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeloginComponent } from './employeelogin/employeelogin.component';
import { EmployeehomeComponent } from './employeehome/employeehome.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeloginComponent,
    EmployeehomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
