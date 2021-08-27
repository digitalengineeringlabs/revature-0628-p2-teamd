import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-adminview',
  templateUrl: './adminview.component.html',
  styleUrls: ['./adminview.component.css']
})
export class AdminviewComponent implements OnInit {

  public id = localStorage.getItem("userid");
  public _url ='http://localhost:8080/tickets/admin';

 tickets:any = [];
 role:any = localStorage.getItem("employeeType");

  constructor(private router:Router,private http:HttpClient) { }

  ngOnInit(): void {
    this.fetch()
  }

  signOut(){
    localStorage.clear();
    this.router.navigate(['']);
  }

  refreshTable(){
    this.fetch();
  }

  createNewTicket(){
    this.router.navigate(['createTicket']);
  }

  updatePassword(){
    this.router.navigate(['updatepassword']);
  }
  approveOrDeny(){
    this.router.navigate(['ticketApproval']);
  }

  fetch(){
  this.http.get(this._url).subscribe(data=>{
    this.tickets= data;
  })
 }

}
