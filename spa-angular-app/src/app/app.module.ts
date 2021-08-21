import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { CreateExpenseTicketComponent } from './create-expense-ticket/create-expense-ticket.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateAccountComponent,
    CreateExpenseTicketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
