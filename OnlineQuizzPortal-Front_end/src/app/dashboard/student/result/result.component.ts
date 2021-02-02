import { Component, OnInit } from '@angular/core';
import {Routes,Router} from '@angular/router';
@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  firstname:any;
  lastname:any;
  marks:any;
  test:any;
  constructor(private route:Router) { }

  ngOnInit(): void {
    this.firstname=sessionStorage.getItem('firstname');
    this.lastname=sessionStorage.getItem('lastname');
    this.marks=sessionStorage.getItem('marks');
    this.test=sessionStorage.getItem('testname');
  }
public backTo()
{
  this.route.navigate(['studtestlist']);
}
}
