import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule}   from '@angular/forms';
import { RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {MatNativeDateModule} from '@angular/material/core';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';





import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeloginComponent } from './employeelogin/employeelogin.component';
import { EmployeehomeComponent } from './employeehome/employeehome.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { CreateExpenseTicketComponent } from './create-expense-ticket/create-expense-ticket.component';
import { AuthGuard } from './authgaurd';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { TicketApprovalComponent } from './ticket-approval/ticket-approval.component';


const routes:Routes = [
  {path: "", component: EmployeeloginComponent},
  {path:"employeehome", component: EmployeehomeComponent , canActivate: [AuthGuard]},
  {path:"createAcount", component:CreateAccountComponent },
  {path:"updatepassword", component:UpdatepasswordComponent},
  {path:"createTicket", component:CreateExpenseTicketComponent,  canActivate: [AuthGuard]}
  {path: "ticketApproval", component: TicketApprovalComponent, canActivate: [AuthGuard]} 
  
]

@NgModule({
  declarations: [
    AppComponent,
    EmployeeloginComponent,
    EmployeehomeComponent,
    CreateAccountComponent,
    CreateExpenseTicketComponent,
    UpdatepasswordComponent,
    TicketApprovalComponent
  ],
  imports: [
    ReactiveFormsModule, 
    MatInputModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent],
 
})
export class AppModule { }
