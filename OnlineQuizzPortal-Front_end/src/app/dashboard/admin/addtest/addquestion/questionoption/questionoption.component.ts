import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Test} from '../../../test';
import {TestService} from '../../../../test.service';
import { TestQuestion } from '../../../test-question';
import { TestquestionService } from '../../../../testquestion.service';
import {Testoption} from '../../../testoption';
import {QuestioptionService} from '../../../questioption.service';
@Component({
  selector: 'app-questionoption',
  templateUrl: './questionoption.component.html',
  styleUrls: ['./questionoption.component.css']
})
export class QuestionoptionComponent implements OnInit {
 testoption:Testoption=new Testoption();
 id:any;
 success:any=false;
 failure:any=false;
constructor(private service:QuestioptionService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get("id");
    this.testoption.ques.qId=this.id;
  }
  public addOption(id:any)
  {
    this.service.addQuestionOption(id,this.testoption).subscribe(
      data=>
      {
          console.log(data);
          this.success=false;
          this.ngOnInit();
      },
      error=>
      {
        console.log(error);
        this.failure=true;
      }
    )
    }
   public backTo()
   {
    this.router.navigate(['/addquestion']);
   }


}
