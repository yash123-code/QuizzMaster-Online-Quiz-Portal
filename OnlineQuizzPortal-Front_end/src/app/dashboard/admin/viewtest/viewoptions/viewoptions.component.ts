import { Component, OnInit } from '@angular/core';
import {Router,RouterModule,ActivatedRoute} from '@angular/router';
import {QuestioptionService} from '../../questioption.service';
import { Testoption } from '../../testoption';
@Component({
  selector: 'app-viewoptions',
  templateUrl: './viewoptions.component.html',
  styleUrls: ['./viewoptions.component.css']
})
export class ViewoptionsComponent implements OnInit {
  id:any;
  tid:any;
  options:Testoption[]=[];
  constructor(private route:Router,private router:ActivatedRoute,private service:QuestioptionService) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.paramMap.get("id");
    this.tid=this.router.snapshot.paramMap.get("tid");
    this.service.getAnswersByqId(this.id).subscribe(
      data=>{
               console.log("data received");
                this.options=data;
      },
      error=>
      {
        console.log("error");
      }
    )
  }
public backTo()
{
  let id=sessionStorage.getItem('testid');
  this.route.navigate(['viewtest',id]);
}
}
