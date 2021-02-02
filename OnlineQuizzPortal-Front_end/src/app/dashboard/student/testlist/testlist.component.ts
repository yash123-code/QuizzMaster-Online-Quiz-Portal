import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Test} from '../../admin/test';
import {TestquestionService} from './../../testquestion.service';

@Component({
  selector: 'app-testlist',
  templateUrl: './testlist.component.html',
  styleUrls: ['./testlist.component.css']
})
export class TestlistComponentstud implements OnInit {

  constructor(private service:TestquestionService,private route:Router) { }
  tests:Test[]=[];
  test:Test=new Test();
  ngOnInit(): void {
    // getting all tests calling service  
   this.service.getAllTestFromRemote().subscribe(
     data=>
     {
       console.log("data fetched");
        this.tests=data;
     },
     error=>{
        console.log("error occurs");
     }
   )
  }
  public startTest(id:number,test:Test)
  {
    this.test=test;
    sessionStorage.setItem('testname',test.testName);
    this.route.navigate(['/examalert',id]);
  }

}
