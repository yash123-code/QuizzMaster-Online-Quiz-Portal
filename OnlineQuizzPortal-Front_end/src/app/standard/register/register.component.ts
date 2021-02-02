import {User} from '../user';
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router,RouterModule } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
fails=" ";
user=new User();
constructor(private service:AuthenticationService,private route:Router)
{
}

public registration()
{
this.service.RegisterFromRemote(this.user).subscribe(
  data=>{
          console.log("Registration successfull");
          this.route.navigate(['/login']);
  },
  error=>{
        console.log("Registration");
        this.fails="Registration fails";
        this.route.navigate(['/register']);
  }

);
}
roleHasError=true; 
validaterole(value:any)
{
  if(value === " ")
  {
    this.roleHasError=true;
  }
  else{
    this.roleHasError=false;
  }
}
    ngOnInit(): any {
}
}