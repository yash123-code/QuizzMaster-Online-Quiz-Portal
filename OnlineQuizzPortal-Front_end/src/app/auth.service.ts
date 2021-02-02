import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
//providing Authentication for login componenet(If it is admin Login scenario)
  public loginAdmin()
  {
    if(sessionStorage.getItem('emailid') && sessionStorage.getItem('password') && sessionStorage.getItem('role')==='ADMIN')
{
    console.log("1");
      return true;
    }
    return false;
  }
  //providing Authentication for Admin component(If it is admin login scenario)
  public loginStudent()
  {
    if(sessionStorage.getItem('emailid') && sessionStorage.getItem('password') && sessionStorage.getItem('role')==='STUDENT')
    {
      console.log("2");
       return true;
    }
      return false;
  }
}
