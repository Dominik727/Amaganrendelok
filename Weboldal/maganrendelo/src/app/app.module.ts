import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PatientListComponent } from '../patient-list/patient-list.component';
import { PatientFormComponent } from '../patient-form/patient-form.component';
import { PatientService } from '../service/patient.service';
import { LoginFormComponent } from '../login-form/login-form.component';
import { CardComponent } from '../card/card.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ClinicListComponent } from './clinic-list/clinic-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PatientListComponent,
    PatientFormComponent,
    LoginFormComponent,
    CardComponent,
    NavbarComponent,
    ClinicListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PatientService],
  bootstrap: [AppComponent]
})
export class AppModule { }