import { Component, Input, OnInit, SimpleChange,Output,EventEmitter } from '@angular/core';
import {ActivatedRoute, Router,RouterModule} from '@angular/router';
import {Observable} from 'rxjs';
import { Test } from '../test';
import {TestQuestion} from '../test-question';
import {TestService} from '../../test.service';
import { TestquestionService } from '../../testquestion.service';
@Component({
  selector: 'app-viewtest',
  templateUrl: './viewtest.component.html',
  styleUrls: ['./viewtest.component.css']
})
export class  ViewtestComponent implements OnInit {

testquestions:TestQuestion[]=[];
id:any;
  constructor(private service:TestService,private route:Router, private router:ActivatedRoute) { }
  public viewOptions(id:any,tid:any)
  {
  sessionStorage.setItem('testid',tid);
    this.route.navigate(['/questionoptions',id]);
  }
  public backTo()
  {
    this.route.navigate(['/testlist']);
  }
  ngOnInit(): void {
     this.id=this.router.snapshot.paramMap.get("id");
     this.service.FetchTestQuetionsFromRemote(this.id).subscribe(
        data=>
        {
          console.log(data);
          this.testquestions=data; 
        },
        error=>
        {
          console.log(error);
          console.log("erros occurs");
        }
     )
  }

}

