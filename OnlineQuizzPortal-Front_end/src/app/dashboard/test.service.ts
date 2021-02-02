import { HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Test} from './admin/test';
import {TestQuestion} from './admin/test-question'
import {Observable} from 'rxjs';
import { User } from '../standard/user';
import { Testoption } from './admin/testoption';
import { Questionresponse } from './student/exam-start/questionresponse';
import { Examdetails } from './student/exam-start/examdetails';
@Injectable({
  providedIn: 'root'
})
export class TestService {
  

constructor(private http:HttpClient){}
//fetching all tests from remote calling Rest API(Rest End Point) 
public FetchTestListFromRemote():Observable<Test[]>{
 return this.http.get<Test[]>("http://localhost:8080/test");
}
//fetching all questions from remote calling REST API(Rest End Point)
public FetchTestQuetionsFromRemote(tId:number):Observable<TestQuestion[]>{
 return this.http.get<any>("http://localhost:8080/que/testId/"+tId);
}
//adding tes calling REST API(Rest End Point)
public testRemoteSubmit(test:Test):Observable<any>
{
 return this.http.post<any>("http://localhost:8080/test",test);
}
//adding question using REST API(Rest End Point)
public questionRemoteSubmit(testquestions:TestQuestion):Observable<any>{
  return this.http.post<any>("http://localhost:8080/que/",testquestions);
}
//getting question By Id from REST API(Rest End Point)
public getQuestionById(qId:number):Observable<TestQuestion>{
  return this.http.get<any>("http://localhost:8080/que/"+qId);
}
//updating question By Id from REST API(Rest End Point)
public updateQuestionById(qId:number,question:TestQuestion)
{
  return this.http.put<any>("http://localhost:8080/que/"+qId,question);
}
//creating test calling  REST API(Rest End Point)
public createTest(test:Test):Observable<any>
{
  return this.http.post<any>("http://localhost:8080/test",test); 
}
//adding question to the test calling REST API(Rest End Point)   
public addQuestionToTheTest(question:TestQuestion,id:number):Observable<any>
{
  return this.http.post<any>("http://localhost:8080/que/"+id,question); 
}
//getting all student details By Id from REST API(Rest End Point)
public getAllStudents():Observable<User[]>{
  return this.http.get<User[]>("http://localhost:8080/user"); 
}
//deleting test By Id from REST API(Rest End Point)
public deleteTestByIdFromRemote(id:number):Observable<any>{
 
  return this.http.delete<any>("http://localhost:8080/test/"+id)}

//getting questions By from REST API(Rest End Point)
public getAllQuestionsByIdFromRemote(id:number):Observable<TestQuestion[]>{
  return this.http.get<any>("http://localhost:8080/que/testId/"+id);
 
}
//getting options By 1uestion Id from REST API(Rest End Point)
public getOptionsByQId(id:number):Observable<Testoption[]>{
  return this.http.get<any>("http://localhost:8080/ans/queId/"+id);

}
//submitting responses calling  REST API(REst End Point)
public submitResponse(qid:number,uid:any,tid:any,response:Questionresponse):Observable<Questionresponse>{
  return this.http.post<Questionresponse>("http://localhost:8080/queresp/"+qid+"/"+uid+"/"+tid+"/",response);
}
//Submitting Exam details calling REST API(REst End Point)
public submitExamdetails(uid:any,tid:any,examdetails:Examdetails):Observable<Examdetails>
{
  return this.http.post<Examdetails>("http://localhost:8080/examdetails/"+uid+"/"+tid,examdetails);
}
}
