import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientFormComponent } from './patient-form/patient-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { SurgeryListComponent } from './surgery-list/surgery-list.component';
import { SurgeryDetailComponent } from './surgery-detail/surgery-detail.component';
import { CreateSurgeryComponent } from './create-surgery/create-surgery.component';
import { EditSurgeryComponent } from './edit-surgery/edit-surgery.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ProfileEditComponent } from './profile-edit/profile-edit.component';
import { SearchComponent } from './search/search.component';
import { DoctorLoginComponent } from './doctor-login/doctor-login.component';

const routes: Routes = [
  { path: 'admin/usersdata', component: PatientListComponent },
  { path: 'registration', component: PatientFormComponent },
  { path: 'login', component: LoginFormComponent },
  { path: 'doctor/login', component: DoctorLoginComponent },
  { path: 'home', component: SurgeryListComponent },
  { path: 'detail/:id', component: SurgeryDetailComponent },
  { path: 'admin/surgeries/create', component: CreateSurgeryComponent },
  { path: 'doctor/:id/patients', component: PatientListComponent },
  { path: 'admin/surgeries/:id/edit', component: EditSurgeryComponent },
  { path: 'patient/:id', component: ProfilePageComponent },
  { path: 'patient/:id/edit', component: ProfileEditComponent },
  { path: 'doctor/:id', component: ProfilePageComponent },
  { path: 'doctor/:id/edit', component: ProfileEditComponent },
  { path: 'surgeries/:searchText', component: SearchComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
