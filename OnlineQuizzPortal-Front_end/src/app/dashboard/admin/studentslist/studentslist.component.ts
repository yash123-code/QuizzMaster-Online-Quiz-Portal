import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Test} from '../test';
import {TestService} from '../../test.service';
import { TestQuestion } from '../test-question';
import { User } from '../../../standard/user';

@Component({
  selector: 'app-studentslist',
  templateUrl: './studentslist.component.html',
  styleUrls: ['./studentslist.component.css']
})
export class StudentslistComponent implements OnInit {
  students:User[]=[];
  constructor(private service:TestService,private route:Router) { }

  ngOnInit(): void {
    this.service.getAllStudents().subscribe(
      data=>{
              console.log(data);
              console.log("data recieved");
              this.students=data;
      },
      error=>
      {
        console.log("failed");
      }
    )
  }
public backTo()
{
  this.route.navigate(['/admin']);
}
}
