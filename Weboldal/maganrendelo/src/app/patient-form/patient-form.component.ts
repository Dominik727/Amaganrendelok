import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../service/patient.service';
import { PatientDto } from '../model/patientdto';

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css']
})
export class PatientFormComponent {

  patient: PatientDto;

  constructor(private route: ActivatedRoute, private router: Router, private patientService: PatientService) {
    this.patient = new PatientDto();
  }

  onSubmit() {
    this.patientService.newPatient(this.patient).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/home']);
  }

}
