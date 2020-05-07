import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/patient';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from '../service/patient.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  patient: Patient;

  constructor(private route: ActivatedRoute,
    private patientService: PatientService,    
    private location: Location) { }

    ngOnInit(): void {
      this.getPatient();
    }
  
    getPatient(): void {
      const id = +this.route.snapshot.paramMap.get('id');
      this.patientService.getPatient(id)
        .subscribe(patient => this.patient = patient);
    }
  
    goBack(): void {
      this.location.back();
    }

    save(): void {
      this.patientService.updatePatient(this.patient)
        .subscribe(() => this.goBack());
    }

}
