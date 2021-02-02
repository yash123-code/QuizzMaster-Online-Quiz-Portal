import { Component, OnInit,OnDestroy } from '@angular/core';
import { Test } from '../../admin/test';
import {ActivatedRoute, Router} from '@angular/router';
import {TestService} from '../../test.service';
import { TestQuestion } from '../../admin/test-question';
import { TestquestionService } from '../../testquestion.service';
import {Questionresponse} from './questionresponse';
import {Testoption} from '../../admin/testoption';
import { Examdetails } from './examdetails';
import { tick } from '@angular/core/testing';
import { getLocaleDateTimeFormat } from '@angular/common';
@Component({
  selector: 'app-exam-start',
  templateUrl: './exam-start.component.html',
  styleUrls: ['./exam-start.component.css']
})
export class ExamStartComponent implements OnInit,OnDestroy {
currentQuestion:any = 0;
totalmarks:any=0;
Id:any;
prev:any=false;
i:any=1;
select=false;
timer:any;
seconds:any;
endTime: any=30;
ellapsedTime = '00:00';
Qid:any;
answer:Testoption=new Testoption();
Aid:any;
duration = '';
sub:any=false;
flag=false;
valid:any=true;
response:Questionresponse=new Questionresponse();
testoptions:Testoption[]=[];
testquestion:TestQuestion[]=[];
examdetails:Examdetails=new Examdetails();
  constructor(private service:TestService,private router:ActivatedRoute,private route:Router){}
    ngOnInit(): void {
    this.Id=this.router.snapshot.paramMap.get("id");
    // calling service getting all questions for particular test
    this.service.getAllQuestionsByIdFromRemote(this.Id).subscribe(
      data=>{
              this.seconds=0;
              console.log(data);
              console.log("data received");
              this.testquestion=data;
              this.getOptions();
              this.startTime();
      },
      error=>
      {
         console.log("error occurs");
      }
    );

}
public startTime()
{
  this.timer=setInterval(()=>{
  this.seconds++;
},1000);
}
public clearTime()
{
  clearInterval(this.timer);

}
public displayTimeEllapsed()
{
  return Math.floor(this.seconds/60) + ':' + Math.floor(this.seconds % 60);
}
public submitTest() {
  console.log('Submitted');
}
public viewNext(qid:any,ansId:any,option:any){
  console.log(this.testquestion.length);
  if(option.isCorrect==true)
  {
    ++this.totalmarks;
  }
  if(this.i === this.testquestion.length-1)
  {
   this.sub=true;
  }
  if (this.i < this.testquestion.length) {
    ++this.currentQuestion;
    ++this.i;
    this.prev=false;
    console.log(this.i);
    this.getOptions();
    console.log("marks"+this.totalmarks);
    console.log(option);
  var uid:any=sessionStorage.getItem("userid");
  this.response.qrs.testId=this.Id;
  this.response.ans=option.answer;
  this.response.que.qId=qid;
  this.response.us.userId=uid;
  console.log(this.response);
  console.log("yash");
  //submitting response by the student for particular question
  this.service.submitResponse(qid,uid,this.Id,this.response).subscribe(
      data=>{
        console.log(data);
      },
      error=>
      {
         console.log("error");
      }
    )
}
this.valid=true;
}
public getOptions()
{
  console.log("data");
  // calling service getting all options for particular questions
  this.service.getOptionsByQId(this.testquestion[this.i - 1].qId).subscribe(
    (data)=>{
      console.log(data);
            console.log("data received");
           this.testoptions=data;
      },
      (error)=>{
         console.log("error occurrs");
      }
    );  
}
public setFlag()
{
   this.flag=true;
}
public submittest()
{
  this.clearTime();
  console.log("time"+this.timer);
  var examdetails=new Examdetails();
  examdetails.totalMarks=this.totalmarks;
  examdetails.userId=sessionStorage.getItem("userid");
  examdetails.respTime=this.timer;
  examdetails.testId=this.Id;
  examdetails.totalQue=this.testquestion.length;
  sessionStorage.setItem('marks',this.totalmarks);
  console.log(examdetails);
  //submitting examdetails  
  this.service.submitExamdetails(examdetails.userId,examdetails.testId,examdetails).subscribe(
    data=>
    {
      console.log(data);
      console.log("data received");    
    },
    error=>
    {
      console.log("error occurs"); 
    })
  this.route.navigate(['result']);
}
public selected(qId:any,ansId:any,option:Testoption)
{
 this.Qid=qId;
 this.Aid=ansId;
 this.answer=option;
 this.valid=false;
}
ngOnDestroy()
{
 console.log("In Destry Method");
 this.clearTime();
}
}



 


