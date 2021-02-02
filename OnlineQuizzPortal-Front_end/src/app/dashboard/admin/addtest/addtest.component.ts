import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Test} from '../test';
import {TestService} from '../../test.service';
import { TestQuestion } from '../test-question';

@Component({
  selector: 'app-addtest',
  templateUrl: './addtest.component.html',
  styleUrls: ['./addtest.component.css']
})
export class AddtestComponent implements OnInit {
 test:any=new Test();
 success=false;
 error=false;
 toggle=true;
  constructor(private service:TestService,private route:Router) { }

  ngOnInit(): void {
  }
public createTest()
{
  this.service.createTest(this.test).subscribe(
    data=>{
      console.log("Test addded successfully")
      this.ngOnInit();
       this.success=true;
       this.toggle=false;
    },
    error=>
    {
        console.log("error occurs");
        this.error=true;
    }
  )
}
public addQuestion(id:number)
{
  this.route.navigate(['/addque',id]);
}
public back()
{
 this.route.navigate(['/testlist']);
} 
}