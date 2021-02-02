import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private route:Router) { }
 flag:any; 
  ngOnInit(): void {
    this.logOut();
  }
public logOut()
{
  var flag=this.flag;
  setTimeout(function(){
  alert("logout succesfully");},1000);
  sessionStorage.clear();
  this.route.navigate(['/login']);
}
}
