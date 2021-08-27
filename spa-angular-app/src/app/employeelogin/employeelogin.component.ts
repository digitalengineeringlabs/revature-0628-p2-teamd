import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';




@Component({
  selector: 'app-employeelogin',
  templateUrl: './employeelogin.component.html',
  styleUrls: ['./employeelogin.component.css']
})
export class EmployeeloginComponent implements OnInit {

  public _url = 'http://localhost:8080/users/login';

  constructor(private router:Router,private http:HttpClient) { }

  ngOnInit(): void {
  }

 
   onSubmit(form:NgForm){
    console.log(form);
    const httpOptions = {
    headers: new HttpHeaders({'Content-Type':  'application/json'})}

    this.http.post(this._url,JSON.stringify({username:form.value.username,password:form.value.password}),httpOptions
   ).subscribe({
     next:(data:any)=>{
      console.log(data.uid)
       if(data ){
       localStorage.setItem("username",form.value.username);
       localStorage.setItem("userid",data.uid);
       localStorage.setItem("employeeType", data.employeeType)
      this.router.navigate(['employeehome'])
       }
     
     }
   })
   }

   
   
}


