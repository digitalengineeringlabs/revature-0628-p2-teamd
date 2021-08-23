import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-expense-ticket',
  templateUrl: './create-expense-ticket.component.html',
  styleUrls: ['./create-expense-ticket.component.css']
})
export class CreateExpenseTicketComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(loginForm:NgForm) { 
    console.log(loginForm) 
    // this.router.navigate(['employeehome']);
  }

}
