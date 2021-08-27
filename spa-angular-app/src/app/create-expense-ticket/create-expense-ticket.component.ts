import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';





@Component({
  selector: 'app-create-expense-ticket',
  templateUrl: './create-expense-ticket.component.html',
  styleUrls: ['./create-expense-ticket.component.css']
})
export class CreateExpenseTicketComponent implements OnInit {
  expenseForm: any;
  reason: any;
  amount: any;
  time: any;
  userid = localStorage.getItem("userid");
  public _url = 'http://localhost:8080/tickets/create/';

  constructor(private http: HttpClient, private router: Router, private fb: FormBuilder,) { }

  ngOnInit(): void {
    this.expenseForm = this.fb.group({
      reason: new FormControl(this.reason, [Validators.required]),
      amount: new FormControl(this.amount, [Validators.required, Validators.min(0)]),
      time: new FormControl(this.time, [Validators.required, Validators.pattern("[0-9]{4}-[0-9]{2}-[0-9]{2}")])
    });
  }

  onSubmit(form: NgForm) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    // if (this.expenseForm.valid) {
      console.log(form)
      // the string used from postman will be put in the json.stringify into the ticket backend
      this.http.post(this._url + this.userid, JSON.stringify({
        reason: form.value.reason, amount: form.value.amount, time: form.value.time, user_id: this.userid
      }), httpOptions
      ).subscribe({
        next: (data) => {
          console.log(data)
        }
      })
      this.router.navigate(['employeehome'])

    // }
  }

  get f() {
    return this.expenseForm.controls;
  }

}
