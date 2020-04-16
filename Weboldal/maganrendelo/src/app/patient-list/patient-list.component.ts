import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient.service';
import { DoctorService } from '../service/doctor.service';
import { Doctor } from '../model/doctor';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[];
  doctors: Doctor[];

  constructor(private patientService: PatientService, private doctorService: DoctorService) { }

  ngOnInit(): void {
    this.patientService.findAll().subscribe(data => {
      this.patients = data;
    });
    this.doctorService.findAll().subscribe(data => {
      this.doctors = data;
    });
  }
}
