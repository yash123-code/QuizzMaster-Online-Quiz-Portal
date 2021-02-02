import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot,Router,RouterStateSnapshot, UrlTree,Routes } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthadminGuard implements CanActivate {
  constructor(private service:AuthService,private route:Router)
  {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean{
      //calling service method to check valid login
      if(this.service.loginAdmin())
      { 
            return true;
      }
      this.route.navigate(['/login']);
        return false;
  }  
}
