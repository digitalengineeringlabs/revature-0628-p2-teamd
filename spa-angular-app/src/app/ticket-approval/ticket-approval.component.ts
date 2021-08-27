import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http'

@Component({
  selector: 'app-ticket-approval',
  templateUrl: './ticket-approval.component.html',
  styleUrls: ['./ticket-approval.component.css']
})
export class TicketApprovalComponent implements OnInit {

  counter:number = 0;
  tickets:any = [];
  currentTicket:any;
  idNum:number = 0;

  public _url ='http://localhost:8080/ticket';

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    this.fetch();
    this.currentTicket = this.tickets[this.counter];
    console.log(this.currentTicket.id)
  }

  signOut(){
    localStorage.clear();
    this.router.navigate(['']);
  }

  approve(){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    
    this.currentTicket.status="Approved";
    this.idNum = this.currentTicket.id;
    this.http.post(this._url+'/update/'+this.idNum, this.currentTicket, httpOptions).subscribe(data=>{
      this.currentTicket = data;
    })
    
  }

  deny(){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    this.currentTicket.status="Denied";
    this.http.patch(this._url, this.currentTicket, httpOptions).subscribe(data=>{
      this.currentTicket = data;
    })
    
  }

  previous(){
    if(this.counter-1 >= 0){
      this.counter = this.counter - 1;
      this.currentTicket = this.tickets[this.counter];
    }
  }

  next(){
    if(this.counter + 1 < this.tickets.length){
      this.counter = this.counter + 1;
      this.currentTicket = this.tickets[this.counter];
    }
  }

  fetch(){
    this.http.get(this._url).subscribe(data=>{
      this.tickets = data;
      this.currentTicket = this.tickets[0];
    })
  }

}
