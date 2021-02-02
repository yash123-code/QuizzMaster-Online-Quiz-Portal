import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Test} from './test'
import {TestService} from '../test.service';
import { TestQuestion } from './test-question';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
username:any;
firstname:any;
constructor(private service:TestService,private route:Router) {}
  ngOnInit(): void {
    this.firstname=sessionStorage.getItem('firstname');
  this.username=sessionStorage.getItem('user'); 
}
public getAllStudents()
{
 this.route.navigate(['/studentlist']);
}
public getAllTests()
{
  this.route.navigate(['/testlist']);
}
}
