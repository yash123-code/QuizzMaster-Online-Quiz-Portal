import { Component, OnInit,OnChanges } from '@angular/core';
import {Router} from '@angular/router';
import {Test} from '../test';
import {TestService} from '../../test.service';
import { TestQuestion } from '../test-question';

@Component({
  selector: 'app-testlist',
  templateUrl: './testlist.component.html',
  styleUrls: ['./testlist.component.css']
})
export class TestlistComponent implements OnInit,OnChanges {
  tests:Test[]=[];
  testquestion:TestQuestion[]=[];
  flag:any=false;
  test:Test=new Test();
constructor(private service:TestService,private route:Router) {}
  ngOnInit(): void {
    
    this.service.FetchTestListFromRemote().subscribe(
      data =>
      {console.log("response received");
        console.log(data);
        this.tests=data;
      }
      ,
      error=>
      {
        console.log("exception occured")
      }
    );
  }
  ngOnChanges()
  {

  }
//wwww.testbox.in/edittest/TESTID
public editTest(testId:number)
  {
    //this.flag=true;
    this.route.navigate(['/edittest', testId]);
    // this.service.FetchTestQuetionsFromRemote().subscribe(
    //      data=>{
    //        //console.log(data)
    //         this.testquestion=data;
    //         this.route.navigate(['/edittest', 11]);
    //      },
    //      error=>{
    //       console.log("Exception Occurs");
    //       this.route.navigate(['admin']);
    //      }
    // );
  }
  public viewTest(testId:number)
  {
    this.route.navigate(['/viewtest',testId]);
  }
  public addTest()
  {
    this.route.navigate(['/addtest']);
  }
  public deleteTest(testId:number)
  {
    this.service.deleteTestByIdFromRemote(testId).subscribe(
    data=>{     
            console.log(data);
          
    },
    error=>
    {
        console.log(error);
        this.ngOnInit();
    }
    )
}
public backTo()
{
  this.route.navigate(['/admin']);
}
}
