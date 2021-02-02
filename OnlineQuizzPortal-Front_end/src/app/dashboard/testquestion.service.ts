import { HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Test} from './admin/test';
import {TestQuestion} from './admin/test-question'
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TestquestionService {

  constructor(private http:HttpClient) { }
  // getting all test calling REST API(Rest End Point)
  public getAllTestFromRemote():Observable<Test[]>{
    return this.http.get<any>("http://localhost:8080/test");
   }
   // getting options from remote calling REST API 
   public getAnswersByqId():Observable<Test[]>{
    return this.http.get<any>("http://localhost:8080/test");
   } 
}
