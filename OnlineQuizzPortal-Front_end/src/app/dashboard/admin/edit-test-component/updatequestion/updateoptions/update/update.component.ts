import { Component, OnInit } from '@angular/core';
import {Routes,RouterModule,ActivatedRoute, Router} from '@angular/router';
import {Testoption} from '../../../../testoption';
import {QuestioptionService} from '../../../../../admin/questioption.service';
@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
id:any;
failure:any=false;
success:any=false;
testoption:Testoption=new Testoption();
  constructor(private route:Router,private router:ActivatedRoute,private service:QuestioptionService) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.paramMap.get("id");
    this.service.getAnswerByansId(this.id).subscribe(
      data=>
      {
        console.log("data received");
        this.testoption=data;
      },
      error=>{
        console.log("Error Occurs");
      }
    )
  }
  public editOption(id:any)
  {
    this.service.updateAnswerById(id,this.testoption).subscribe(
     data=>
     {
       console.log(data);
       console.log("updated suuccessfully");
       this.success=true;
     },
    error=>
     {
      console.log("error occurs");
      this.failure=true;
     }
    )    
  }
  public backTo()
  {
    var id=sessionStorage.getItem('qid');
    sessionStorage.removeItem('qid');
    this.route.navigate(['/updateoptions',id]);    
  }
  public testlist()
  {
    this.route.navigate(['testlist']);
  }
}
