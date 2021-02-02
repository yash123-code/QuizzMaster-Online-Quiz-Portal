import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Test} from '../../test';
import {TestService} from '../../../test.service';
import { TestQuestion } from '../../test-question';
import { TestquestionService } from '../../../testquestion.service';
@Component({
  selector: 'app-addquestion',
  templateUrl: './addquestion.component.html',
  styleUrls: ['./addquestion.component.css']
})
export class AddquestionComponent implements OnInit {

  question=new TestQuestion();
  success=false;
  id:any;
  marks:any;
  failure=false;
  toggle=false;
  flag:any=false;
  constructor(private service:TestService,private route:Router,private router:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.paramMap.get("id");
    this.question.test1.testId=this.id;
  this.question.marks=1;
  }
  public backTo()
  {
     this.route.navigate(['/addtest']);
  }
  public addQuestion(id:number)
  {
    this.service.addQuestionToTheTest(this.question,id).subscribe(
        data=>{
          console.log("question added");
            this.success=true;
            this.toggle=true;
            this.flag=false;
        },
        error=>{
          console.log("question additin failded");
          this.failure=true;
        }
    )
  }
  public addOptions(id:number){
    this.route.navigate(['/addoptions',id]);
  }
}
