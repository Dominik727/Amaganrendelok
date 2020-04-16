import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../service/patient.service';
import { Patient } from '../model/patient';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  

  patient: Patient;

  constructor(private route: ActivatedRoute, private router: Router, private patientService: PatientService) {
    this.patient = new Patient();
  }

  onSubmit() {
    this.patientService.save(this.patient).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/patients']);
  }
  ngOnInit(): void {
  }

}
