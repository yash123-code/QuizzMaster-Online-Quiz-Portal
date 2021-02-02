import { Component, OnInit } from '@angular/core';
import { Test } from '../../admin/test';
import {ActivatedRoute, Router} from '@angular/router';
import {TestService} from '../../test.service';
import { TestQuestion } from '../../admin/test-question';
import { TestquestionService } from '../../testquestion.service';

@Component({
  selector: 'app-exam-alert',
  templateUrl: './exam-alert.component.html',
  styleUrls: ['./exam-alert.component.css']
})
export class ExamAlertComponent implements OnInit {

  constructor(private testservice:TestquestionService,private route:ActivatedRoute ,private router:Router) { }
 Id:any;
 test:TestQuestion[]=[] ;
  ngOnInit(): void {
   this.Id=this.route.snapshot.paramMap.get("id");
  }
 public startTest()
 {
   let id=this.Id;
   this.router.navigate(['/examstart',id]);
 }
}
