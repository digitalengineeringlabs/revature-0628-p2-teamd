import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {


  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(loginForm:NgForm) { 
    console.log(loginForm) 
    // this.router.navigate(['login']);
  
  }

}
