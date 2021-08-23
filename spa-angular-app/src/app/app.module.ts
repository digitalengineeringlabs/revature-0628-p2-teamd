import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { CreateExpenseTicketComponent } from './create-expense-ticket/create-expense-ticket.component';
import { AuthGuard } from './authguard';


const routes: Routes=[
  { path:"createAcount", component:CreateAccountComponent },
  { path:"createTicket", component:CreateExpenseTicketComponent,  canActivate: [AuthGuard]}
]
@NgModule({
  declarations: [
    AppComponent,
    CreateAccountComponent,
    CreateExpenseTicketComponent
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
