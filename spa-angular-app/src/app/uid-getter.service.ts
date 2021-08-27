import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export interface UidGetterService {

  uid:number;
  email:string;
  employeeType:string;
  firstName:string;
  lastName:string;
  newpassword:string;
  password:string;
  phoneNumber:number;
  username:string;

  // constructor(myObject:JSON) { }
  // let myString = JSON.parse(myObject);

}
