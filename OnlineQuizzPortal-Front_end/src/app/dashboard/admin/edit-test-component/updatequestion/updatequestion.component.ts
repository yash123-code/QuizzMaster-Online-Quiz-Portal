import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router,RouterModule} from '@angular/router';
import {Observable} from 'rxjs';
import { Test } from '../../test';
import {TestQuestion} from '../../test-question';
import {TestService} from '../../../test.service';
import { QuestioptionService } from '../../questioption.service'
@Component({
  selector: 'app-updatequestion',
  templateUrl: './updatequestion.component.html',
  styleUrls: ['./updatequestion.component.css']
})
export class UpdatequestionComponent implements OnInit {
id:any;
success:any=false;
failure:any=false;

testquestion:TestQuestion=new TestQuestion();
  constructor(private service:TestService,private qservice:QuestioptionService,private route:Router,private router:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.paramMap.get("qid");
    this.testquestion.qId=this.id;
    this.service.getQuestionById(this.id).subscribe(
        data=>
        {
          console.log("data received");
          console.log(data);
          this.testquestion=data;
        },
        error=>{
          console.log("error occurs");
        },
    )
  }
  public updateQuestion(qId:any)
  {
     this.qservice.updateQuestion(qId,this.testquestion).subscribe(
       data=>{
         console.log("updated");
         this.success=true;
       },
       error=>
       {
        console.log("error");
        this.failure=true;
       }
     )
  }
  public backTo()
  {
    var id=sessionStorage.getItem('testid');
    sessionStorage.removeItem('testid');
   this.route.navigate(['/edittest',id]);
  }
  public testlist()
  {
    this.route.navigate(['testlist']);
  }
}
