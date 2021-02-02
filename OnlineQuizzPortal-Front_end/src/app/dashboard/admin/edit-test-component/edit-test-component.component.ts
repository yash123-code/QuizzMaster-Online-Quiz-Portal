import { Component, Input, OnInit, SimpleChange,Output,EventEmitter } from '@angular/core';
import {ActivatedRoute, Router,RouterModule} from '@angular/router';
import {Observable} from 'rxjs';
import { Test } from '../test';
import {TestQuestion} from '../test-question';
import {TestService} from '../../test.service';
import { TestquestionService } from '../../testquestion.service';
@Component({
  selector: 'app-edit-test-componet',
  templateUrl: './edit-test-component.component.html',
  styleUrls: ['./edit-test-component.component.css']
})
export class EditTestComponentComponent implements OnInit {
  id:any;
  testquestions:TestQuestion[]=[];  
  toggle:any;
  constructor(private service:TestService,private route:Router,private router:ActivatedRoute) { }

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
         console.log("erros occurs");
       }
    )
      }
      public updateQuestion(qId:number,tid:any)
      {
        sessionStorage.setItem('testid',tid);
        this.route.navigate(['/updatequestion',qId]);    
      }
      public updateOptions(qId:number,tid:any)
      {
        sessionStorage.setItem('testid',tid);
        this.toggle=true;
        this.route.navigate(['/updateoptions',qId]);

      }
      public backTo()
      {
          this.route.navigate(['/testlist']);
      }
}  
