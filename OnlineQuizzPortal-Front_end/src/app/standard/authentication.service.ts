import { Injectable } from '@angular/core';
import {User} from './user';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http:HttpClient) { }
  //Registering User using REST API(Rest End Point)
  public RegisterFromRemote(user:User):Observable<User>{
   return this.http.post<any>("http://localhost:8080/user/registeruser",user);
  }
  //Authenticating User By calling REST API(Rest End Point)
  public loginFromRemote(user:User):Observable<User>{
    return this.http.post<any>("http://localhost:8080/user/login",user);
  }
}
