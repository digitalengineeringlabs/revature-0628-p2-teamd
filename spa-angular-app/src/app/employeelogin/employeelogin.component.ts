import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-employeelogin',
  templateUrl: './employeelogin.component.html',
  styleUrls: ['./employeelogin.component.css']
})
export class EmployeeloginComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    console.log(form);

    localStorage.setItem("username", form.value.username);
    this.router.navigate(['employeehome']);

  }

}
