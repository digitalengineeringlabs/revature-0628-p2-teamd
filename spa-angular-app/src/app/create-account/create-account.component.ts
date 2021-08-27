import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

public _url = 'http://localhost:8080/users/create';

  constructor(private router:Router,private http:HttpClient) {  }

  ngOnInit(): void {
  }

  onSubmit(loginForm:NgForm) { 
   
          const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'})}
    
     this.http.post(this._url,JSON.stringify({
     firstName:loginForm.value.first_name,lastName:loginForm.value.last_name,phone_number:loginForm.value.phone_number,email:loginForm.value.email,
     employee_type:loginForm.value.employee_type,username:loginForm.value.user_name,password:loginForm.value.password}),httpOptions
     ).subscribe({
       next:(data:any)=>{
         console.log(data)
       }

     })
      this.router.navigate([''])  
  
  }

}
