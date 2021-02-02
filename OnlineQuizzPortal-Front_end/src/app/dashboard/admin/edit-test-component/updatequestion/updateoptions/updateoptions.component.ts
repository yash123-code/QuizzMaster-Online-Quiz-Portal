import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router,RouterModule} from '@angular/router';
import {Observable} from 'rxjs';
import { Test } from '../../../test';
import {TestQuestion} from '../../../test-question';
import {TestService} from '../../../../test.service';
import { QuestioptionService } from '../../../../admin/questioption.service';
import {Testoption} from '../../../testoption';
@Component({
  selector: 'app-updateoptions',
  templateUrl: './updateoptions.component.html',
  styleUrls: ['./updateoptions.component.css']
})
export class UpdateoptionsComponent implements OnInit {
  id:any;
  options:Testoption[]=[];
    constructor(private service:TestService,private qservice:QuestioptionService,private route:Router,private router:ActivatedRoute) { }
  
    ngOnInit(): void {
      this.id=this.router.snapshot.paramMap.get("id");
      this.qservice.getAnswersByqId(this.id).subscribe(
          data=>
          {
            console.log("data received");
            console.log(data);
            this.options=data;
          },
          error=>{
            console.log("error occurs");
          },
      )
    }
    public updateOption(id:any,qid:any)
    {  
      sessionStorage.setItem('qid',qid);
        this.route.navigate(['/update',id]);
    }
    public backTo()
    {
    var id=sessionStorage.getItem('testid');
    sessionStorage.removeItem('testid');
   this.route.navigate(['/edittest',id]);
    }
    public testlist()
    {
      this.route.navigate(['/testlist']);
    }
  }
  
