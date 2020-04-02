import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PatientListComponent } from '../patient-list/patient-list.component';
import { PatientFormComponent } from '../patient-form/patient-form.component';
import { LoginFormComponent } from 'src/login-form/login-form.component';
import { ClinicListComponent } from './clinic-list/clinic-list.component';

const routes: Routes = [
  { path: 'patients', component: PatientListComponent },
  { path: 'signup', component: PatientFormComponent },
  { path: 'login', component: LoginFormComponent },
  { path: 'home', component: ClinicListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
