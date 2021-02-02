import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin/admin.component';
import { StudentComponent } from './student/student.component';
import {Routes,RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import  {TestService} from '../dashboard/test.service';
import {TestquestionService} from '../dashboard/testquestion.service';
import { ViewtestComponent } from './admin/viewtest/viewtest.component';
import { AddtestComponent } from './admin/addtest/addtest.component';
import { DeletetestComponent } from './admin/deletetest/deletetest.component';
import { EditTestComponentComponent } from './admin/edit-test-component/edit-test-component.component';
import {FormsModule} from '@angular/forms';
import { TestlistComponent } from './admin/testlist/testlist.component';
import { StudentslistComponent } from './admin/studentslist/studentslist.component';
import { Test } from './admin/test';
import { TestlistComponentstud } from './student/testlist/testlist.component';
import { AddquestionComponent } from './admin/addtest/addquestion/addquestion.component';
import {ExamAlertComponent} from './student/exam-alert/exam-alert.component';
import {ExamStartComponent} from './student/exam-start/exam-start.component';
import { QuestionoptionComponent } from './admin/addtest/addquestion/questionoption/questionoption.component';
import { UpdatequestionComponent } from './admin/edit-test-component/updatequestion/updatequestion.component';
import { UpdateoptionsComponent } from './admin/edit-test-component/updatequestion/updateoptions/updateoptions.component';
import { UpdateComponent } from './admin/edit-test-component/updatequestion/updateoptions/update/update.component';
import { ViewoptionsComponent } from './admin/viewtest/viewoptions/viewoptions.component';
import { AuthGuard } from '../auth.guard';
import { AuthadminGuard } from '../authadmin.guard';
import { ResultComponent } from './student/result/result.component';


const routes:Routes=[
  {path:'admin',component:AdminComponent,canActivate:[AuthadminGuard]},
  {path:'student',component:StudentComponent,canActivate:[AuthGuard]},
  {path:'viewtest/:id',component:ViewtestComponent},
  {path:'addtest',component:AddtestComponent},
  {path:'edittest/:id',component:EditTestComponentComponent},
  {path:'edittest',component:EditTestComponentComponent},
  {path:'add',component:AddtestComponent},
  {path:'studentlist',component:StudentslistComponent},
  {path:'result',component:ResultComponent},
  {path:'studtestlist',component:TestlistComponentstud},
  {path:'addque/:id',component:AddquestionComponent},
  {path:'addque',component:AddquestionComponent},
  {path:'testlist',component:TestlistComponent},
  {path:'deltest',component:DeletetestComponent},
  {path:'examalert/:id',component:ExamAlertComponent},
  {path:'examstart/:id',component:ExamStartComponent},
  {path:'examalert',component:ExamAlertComponent},
  {path:'examstart',component:ExamStartComponent},
  {path:'addoptions/:id',component:QuestionoptionComponent},
  {path:'updateoptions/:id',component:UpdateoptionsComponent},
  {path:'updatequestion/:qid',component:UpdatequestionComponent},
  {path:'update/:id',component:UpdateComponent},
  {path:'questionoptions/:id',component:ViewoptionsComponent},
]
@NgModule({
  declarations: [AdminComponent, StudentComponent,StudentComponent, ViewtestComponent,ExamStartComponent ,AddtestComponent, DeletetestComponent,EditTestComponentComponent, TestlistComponent, StudentslistComponent,ExamAlertComponent, AddquestionComponent,TestlistComponentstud, QuestionoptionComponent, UpdatequestionComponent, UpdateoptionsComponent, UpdateComponent, ViewoptionsComponent, ResultComponent],
  imports: [
    CommonModule,HttpClientModule,FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers:[TestquestionService,TestService]
})
export class DashboardModule { }
