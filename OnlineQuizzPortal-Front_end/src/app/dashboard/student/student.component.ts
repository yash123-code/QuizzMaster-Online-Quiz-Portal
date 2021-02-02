import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Test} from '../admin/test';
import {TestService} from '../test.service';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor(private service:TestService,private route:Router) { }

  ngOnInit(): void {
  }

  public getAllTest()
  {
    this.route.navigate(['/studtestlist']);
  }

}
