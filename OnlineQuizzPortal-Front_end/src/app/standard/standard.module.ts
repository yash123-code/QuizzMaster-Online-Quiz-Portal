import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ContactusComponent } from './contactus/contactus.component';
import { LogoutComponent } from './logout/logout.component';
import {FormsModule} from '@angular/forms';
import {Routes,RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {AdminComponent} from '../dashboard/admin/admin.component';
import {StudentComponent } from '../dashboard/student/student.component';
import { AuthenticationService } from './authentication.service';
import {AuthGuard} from '../auth.guard';
import { AuthadminGuard } from '../authadmin.guard';
const routes:Routes=[
  {path:'home',component:HomeComponent},  
  {path:'register',component:RegisterComponent},
  {path:'login/:flag',component:LoginComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthadminGuard]},
  {path:'student',component:StudentComponent,canActivate:[AuthGuard]},
  {path:'logout',component:LogoutComponent}
]

@NgModule({
  declarations: [HomeComponent, AboutusComponent, LoginComponent, RegisterComponent, ContactusComponent,LogoutComponent],
  imports: [
    CommonModule,FormsModule,RouterModule,HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers :[AuthenticationService],
  exports:[HomeComponent, AboutusComponent, LoginComponent, RegisterComponent, ContactusComponent,LogoutComponent]
})
export class StandardModule { }
