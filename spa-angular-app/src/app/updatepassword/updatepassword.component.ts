import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-updatepassword',
  templateUrl: './updatepassword.component.html',
  styleUrls: ['./updatepassword.component.css']
})
export class UpdatepasswordComponent implements OnInit {
  

  public _url = 'http://localhost:8080/users/updatepassword';

  constructor(private router:Router,private http:HttpClient) { }

  ngOnInit(): void {
  }

 
   onSubmit(form:NgForm){
    console.log(form);
    const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'})}

    //make an if statement to check if username and password match in the database for login access
    this.http.post(this._url,JSON.stringify({username:form.value.username,password:form.value.password,newpassword:form.value.newpassword}),httpOptions
   ).subscribe({
     next:(data:any)=>{
      console.log(data)
       if(data ){
       localStorage.setItem("username",form.value.username);
      this.router.navigate(['employeehome'])
       }
     
     }
   })
   }

}
