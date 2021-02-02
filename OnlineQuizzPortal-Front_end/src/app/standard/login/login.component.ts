import { Component, OnInit } from '@angular/core'
import {User} from '../user';
import {AuthenticationService} from '../authentication.service';
import { Router,RouterModule,ActivatedRoute } from '@angular/router';
import {AuthService} from '../../auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg=" ";
  f:any;
  user =new User();
  error:any=" ";
  constructor(private service:AuthenticationService,private route:Router,private authservice:AuthService,private activate:ActivatedRoute) { }

  public loginUser()
  {
    if(sessionStorage.getItem('emailid') && sessionStorage.getItem('password') && sessionStorage.getItem('role'))
    {
       this.error="You are already login";
    }
    else{
    this.service.loginFromRemote(this.user).subscribe(
      data =>{      
        console.log(data);
        sessionStorage.setItem('emailid',data.emailId)
        sessionStorage.setItem('password',data.password);
        sessionStorage.setItem('userid',data.userId);
        sessionStorage.setItem('role',data.role);
        sessionStorage.setItem('firstname',data.firstName);
        sessionStorage.setItem('lastname',data.lastName);
        console.log("Confirmtion Received");
        if(sessionStorage.getItem('role')==='ADMIN')
        {
          this.route.navigate(['/admin']);
        }
        else if(sessionStorage.getItem('role')==='STUDENT')
        {
          this.route.navigate(['/student']);
        }
      },
      error=>{
        console.log("Exception occurs");
        this.msg="Bad Credentials,please enter valid Email and password";
      }
          
    );
  }
    }
  ngOnInit(): void {
  }
}