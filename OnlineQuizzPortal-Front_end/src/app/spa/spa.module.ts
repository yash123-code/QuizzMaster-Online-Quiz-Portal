import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import{Routes,RouterModule} from '@angular/router';
import { ContainerComponent } from './container/container.component';
import { StandardModule } from '../standard/standard.module';
import { HomeComponent } from '../standard/home/home.component';
import { AboutusComponent } from '../standard/aboutus/aboutus.component';
import { ContactusComponent } from '../standard/contactus/contactus.component';
import { LoginComponent } from '../standard/login/login.component';
import { RegisterComponent } from '../standard/register/register.component';
import { AdminComponent } from '../dashboard/admin/admin.component';
import { StudentComponent } from '../dashboard/student/student.component';
import { AuthGuard } from '../auth.guard';
import { AuthadminGuard } from '../authadmin.guard';


const routes:Routes=[
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'home',component:HomeComponent,canActivate:[AuthGuard]},
  {path:'aboutus',component:AboutusComponent},
  {path:'contactus',component:ContactusComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthadminGuard]},
  {path:'student',component:StudentComponent,canActivate:[AuthGuard]}
]

@NgModule({
  declarations: [ContainerComponent],
  imports: [
    CommonModule,
    StandardModule,
    RouterModule.forRoot(routes)
  ],
  exports:[
    ContainerComponent
  ]
})
export class SPAModule { }
