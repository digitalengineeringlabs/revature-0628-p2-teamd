import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-create-expense-ticket',
  templateUrl: './create-expense-ticket.component.html',
  styleUrls: ['./create-expense-ticket.component.css']
})
export class CreateExpenseTicketComponent implements OnInit {

public _url = 'http://localhost:8080/ticket';

  constructor(private http:HttpClient,private router:Router) {
  }
  
  userid = localStorage.getItem("userid");
  ngOnInit(): void {
    
  }

  onSubmit(form:NgForm){ 
        const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'})}

    console.log(form)
  // the string used from postman will be put in the json.stringify into the ticket backend
   this.http.post(this._url,JSON.stringify({
     reason:form.value.reason,amount:form.value.amount,time:form.value.time,user_id:this.userid
     }),httpOptions
     ).subscribe({
       next:(data)=>{
         console.log(data)
       }
     })
      this.router.navigate(['employeehome'])
   
  }

}
