import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';

import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientFormComponent } from './patient-form/patient-form.component';
import { PatientService } from './service/patient.service';
import { LoginFormComponent } from './login-form/login-form.component';
import { CardComponent } from './card/card.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SurgeryListComponent } from './surgery-list/surgery-list.component';
import { SurgeryDetailComponent } from './surgery-detail/surgery-detail.component';
import { CreateSurgeryComponent } from './create-surgery/create-surgery.component';
import { EditSurgeryComponent } from './edit-surgery/edit-surgery.component';
import { SearchComponent } from './search/search.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ProfileEditComponent } from './profile-edit/profile-edit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PatientListComponent,
    PatientFormComponent,
    LoginFormComponent,
    CardComponent,
    NavbarComponent,
    SurgeryListComponent,
    SurgeryDetailComponent,
    CreateSurgeryComponent,
    EditSurgeryComponent,
    SearchComponent,
    ProfilePageComponent,
    ProfileEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [PatientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
