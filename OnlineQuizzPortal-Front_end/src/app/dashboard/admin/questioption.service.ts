import { HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Testoption } from './testoption';
import { TestQuestion } from './test-question';
@Injectable({
  providedIn: 'root'
})
export class QuestioptionService {

  constructor(private http:HttpClient)
   { }
   public addQuestionOption(id:any,questionoption:Testoption):Observable<any>
   {
     return this.http.post<any>("http://localhost:8080/ans/"+id,questionoption);
   }
   public updateQuestion(id:any,questionoption:TestQuestion):Observable<any>
   {
     return this.http.put<any>("http://localhost:8080/que/"+id,questionoption);
   }
   public getAnswersByqId(id:any):Observable<Testoption[]>
   {
     return this.http.get<any>("http://localhost:8080/ans/queId/"+id);
   }
   public getAnswerByansId(id:any):Observable<any>
   {
     return this.http.get<Testoption>("http://localhost:8080/ans/"+id);
   }
   public updateAnswerById(id:any,testoption:Testoption):Observable<any>
   {
     return this.http.put<Testoption>("http://localhost:8080/ans/"+id,testoption);
   }
}
